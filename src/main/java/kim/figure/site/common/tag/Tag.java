package kim.figure.site.common.tag;

import kim.figure.site.common.content.Content;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * author         : walker
 * date           : 2022. 11. 19.
 * description    :
 */

@Document
@Getter
@Setter
public class Tag {

    public Tag(String id) {
        this.id = id;
    }
    @Id
    private String id;

//    List<Content> contentEntityList;

}
