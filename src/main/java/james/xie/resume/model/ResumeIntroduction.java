package james.xie.resume.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jamesxieaudaexplorecom on 5/1/16.
 */
@Document(collection = "Introduction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeIntroduction implements ResumeData{
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("introduction")
    private String introduction;

}
