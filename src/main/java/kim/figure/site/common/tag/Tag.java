package kim.figure.site.common.tag;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import kim.figure.site.common.content.Content;

import java.util.List;

/**
 * author         : walker
 * date           : 2022. 11. 19.
 * description    :
 */
@Entity(name="tag")
public class Tag {
    @Id
    private String id;

    @OneToMany
    List<Content> contentEntityList;

}
