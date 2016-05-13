package james.xie.resume.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jamesxieaudaexplorecom on 5/11/16.
 */
@Entity
public class Greeting {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    public Greeting() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
