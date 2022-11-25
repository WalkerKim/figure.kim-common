package kim.figure.site.common.content;

import jakarta.persistence.*;
import kim.figure.site.common.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * author         : walker
 * date           : 2022. 11. 18.
 * description    :
 */

@Entity(name = "CONTENT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private ContentFormat contentFormat;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String rawContent;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String renderedContent;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = true)
    private Boolean draft = true;

    @Column(nullable = true)
    private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

    @Column(nullable = true)
    private ZonedDateTime publishAt;

    @ElementCollection
    private List<String> ogKeywordList;

    @OneToOne
    private Category category;

    @Column(nullable = true)
    private String publicSlug;

    //ogTag image
    String ogImage;

    //og tag description
    String ogDescription;

    Boolean isPublished;



}
