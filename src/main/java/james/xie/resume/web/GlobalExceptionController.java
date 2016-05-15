package james.xie.resume.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by jamesxieaudaexplorecom on 5/14/16.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public void handleGenericException(Exception ex) throws Exception {
        log.error(ex.getMessage());
        throw ex;
    }

}
