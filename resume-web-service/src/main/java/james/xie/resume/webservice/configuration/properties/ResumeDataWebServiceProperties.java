package james.xie.resume.webservice.configuration.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jamesxieaudaexplorecom on 2/24/16.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Configuration
public class ResumeDataWebServiceProperties {
    @Value("${james.xie.resume.url}")
    private String resumeUrl;
    @Value("${james.xie.resume.timeout.in.millis}")
    private Integer resumeRequestTimeoutInMillis;
}