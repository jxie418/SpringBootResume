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
public class ResumeProject implements ResumeData{
    @JsonProperty("id")
    private Long id;
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("projectName")
    private String projectName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("responsibility")
    private String responsibility;
    @JsonProperty("company")
    private String company;
    @JsonProperty("technologies")
    private String technologies;
    @JsonProperty("role")
    private String role;
    @JsonProperty("year")
    private String year;

}
