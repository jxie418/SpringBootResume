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
@Document(collection = "Summary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeSummary implements ResumeData {
    @Id
    @JsonProperty("_id")
    private String _id;
    @JsonProperty("summaryInfo")
    private String summaryInfo;
}
