package kim.figure.site.common.content;

import kim.figure.site.common.category.Category;
import kim.figure.site.common.tag.Tag;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.Instant;
import java.util.List;

/**
 * author         : walker
 * date           : 2022. 11. 18.
 * description    :
 */


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Content {

    @Transient
    public static final String SEQUENCE_NAME = "content_sequence";

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    private Long id;

    private String title;

    private ContentFormat contentFormat;

    private String rawContent;

    private String renderedContent;

    private String description;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant lastModifiedAt;

    private Instant publishAt;

    private List<String> ogKeywordList;

    private Category category;

    private List<Tag> tagList;

    @DBRef
    private List<Category> categoryList;

    //ogTag image
    String ogImage;

    Boolean isPublished;

    @Version
    private Integer version;



}
