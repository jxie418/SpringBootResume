package james.xie.resume.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Created by jamesxieaudaexplorecom on 2/23/16.
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Resume Web Service Error!")
public class ResumeDataException extends Exception {
    public ResumeDataException(String message) {
        super(message);
    }

    public ResumeDataException(String message, Exception exception) {
        super(message, exception);
    }
}
