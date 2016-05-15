package james.xie.resume.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jamesxieaudaexplorecom on 5/1/16.
 */
@Document(collection = "Project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeProject implements ResumeData{
    @Id
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
