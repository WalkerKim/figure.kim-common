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
@Setter
@ToString
public class Content {

    @Transient
    public static final String SEQUENCE_NAME = "content_sequence";

    @Id
    private Long id;

    private String title;

    private ContentFormat contentFormat;

    private String rawContent;

    private String renderedContent;

    private String description;

    private Instant createdAt;

    private Boolean isDraft;

    private Instant lastModifiedAt;

    private Instant publishedAt;

    private List<String> ogKeywordList;

    @DBRef
    private List<Tag> tagList;

    @DBRef
    private List<Category> categoryList;

    private List<Long> recommendPostIdList;

    //ogTag image
    private String ogImage;

    private Boolean isPublished;

    private Long recommendStat;

    private Integer version;



}
