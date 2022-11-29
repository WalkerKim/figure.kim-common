package kim.figure.site.common.tag;

import kim.figure.site.common.content.Content;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * author         : walker
 * date           : 2022. 11. 19.
 * description    :
 */

public class Tag {
    @Id
    private String id;

    List<Content> contentEntityList;

}
