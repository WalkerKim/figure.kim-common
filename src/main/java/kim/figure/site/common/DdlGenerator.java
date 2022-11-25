package kim.figure.site.common;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * author         : walker
 * date           : 2022. 09. 06.
 * description    :
 */
public class DdlGenerator {
    public static Path makeDdl() {
        Map<String, Object> settings = new HashMap<>();
        settings.put(Environment.URL, "jdbc:h2:mem:schema");
        settings.put(Environment.HBM2DDL_CREATE_SOURCE, "metadata");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        settings.put(Environment.PHYSICAL_NAMING_STRATEGY, "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
//        settings.put(Environment.IMPLICIT_NAMING_STRATEGY, "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        Set<Class> classSet = findAllClassesUsingClassLoader("kim.figure.site.common.content");
        classSet.addAll(findAllClassesUsingClassLoader("kim.figure.site.common.category"));
        classSet.addAll(findAllClassesUsingClassLoader("kim.figure.site.common.tag"));
        for(Class clazz : classSet){
            metadataSources.addAnnotatedClass(clazz);
        }
        Path targetPath = Path.of("create.sql");
        if(Files.exists(targetPath)){
            try {
                Files.delete(targetPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        };
        Metadata metadata = metadataSources.buildMetadata();
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setFormat(true);
        schemaExport.setOutputFile("create.sql");
        schemaExport.create(EnumSet.of(TargetType.SCRIPT), metadata);
        return targetPath;
    }

    public static Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}
