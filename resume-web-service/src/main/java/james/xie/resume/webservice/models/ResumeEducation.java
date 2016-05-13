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
public class ResumeEducation implements ResumeData {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("major")
    private String major;
    @JsonProperty("school")
    private String school;
    @JsonProperty("location")
    private String location;
    @JsonProperty("degree")
    private String degree;
    @JsonProperty("year")
    private String year;
    @JsonProperty("GPA")
    private String GPA;
}
