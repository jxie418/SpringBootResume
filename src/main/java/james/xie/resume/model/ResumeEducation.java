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
@Document(collection = "Education")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeEducation implements ResumeData {
    @Id
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
