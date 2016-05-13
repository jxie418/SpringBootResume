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
public class ResumeWorkExperience implements ResumeData {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("position")
    private String position;
    @JsonProperty("location")
    private String location;
    @JsonProperty("manager")
    private String manager;
    @JsonProperty("year")
    private String year;

}
