package kim.figure.site.common.category;

import kim.figure.site.common.content.Content;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * author         : walker
 * date           : 2022. 11. 18.
 * description    :
 */
@Document
@Builder
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Setter
public class Category {
    @Id
    private String id;

    private String name;

    private String uriKey;

    private Integer depth;

    private Category parentCategory;

    @DBRef
    private List<Category> childCategoryList;

    private List<Content> contentEntityList;
}
