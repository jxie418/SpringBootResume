package james.xie.resume.api.controller;

import james.xie.resume.webservice.exception.ResumeDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public void handleGenericException(Exception ex) throws Exception {
        log.error(ex.getMessage());
        throw ex;
    }

    @ExceptionHandler(ResumeDataException.class)
    public void handleAudaVINException(ResumeDataException resumeDataException) throws Exception {
        log.error(resumeDataException.getMessage(), resumeDataException);
        throw resumeDataException;
    }
}
