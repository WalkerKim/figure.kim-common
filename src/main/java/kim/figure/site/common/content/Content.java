package kim.figure.site.common.content;

import kim.figure.site.common.category.Category;
import kim.figure.site.common.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.ZoneId;
import java.time.ZonedDateTime;
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
public class Content {

    @Id
    private Long id;

    private String title;

    private ContentFormat contentFormat;

    private String rawContent;

    private String renderedContent;

    private String description;

    private Boolean draft = true;

    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

    private ZonedDateTime publishAt;

    private List<String> ogKeywordList;

    private Category category;

    private List<Tag> tagList;

    private String publicSlug;

    //ogTag image
    String ogImage;

    //og tag description
    String ogDescription;

    Boolean isPublished;



}
