package james.xie.resume.webservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jamesxieaudaexplorecom on 5/1/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeIntroduction implements ResumeData{
    @JsonProperty("id")
    private Long id;
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("introduction")
    private String introduction;

}
