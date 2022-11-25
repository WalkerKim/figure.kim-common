package kim.figure.site.common.category;

import jakarta.persistence.*;
import kim.figure.site.common.content.Content;


import java.util.List;

/**
 * author         : walker
 * date           : 2022. 11. 18.
 * description    :
 */
@Entity(name = "category")
public class Category {
    @Id
    private String id;

    private String name;

    private String uriKey;

    private Integer depth;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Category> childCategoryList;

    @ManyToOne
    private Category parentCategory;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Content> contentEntityList;





}
