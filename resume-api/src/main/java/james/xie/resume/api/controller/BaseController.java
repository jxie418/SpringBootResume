package james.xie.resume.api.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by jamesxieaudaexplorecom on 5/6/16.
 */
@Slf4j
public class BaseController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleException(Exception exception, HttpServletRequest request) {
        log.error("> handleException");
        log.error("- Exception: ",exception);
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();
        Map<String,Object> responeBody = exceptionAttributes.getExceptionAttributes(exception,request, HttpStatus.INTERNAL_SERVER_ERROR);
        log.error("< handleException");
        return new ResponseEntity<Map<String,Object>>(responeBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler()
    public ResponseEntity<Map<String,Object>> handleNoResultException(NoResultException noResultExcpetion, HttpServletRequest request) {
        log.info("> handleNoResultException");
        ExceptionAttributes exceptionAttributes = new DefaultExceptionAttributes();
        Map<String,Object> responseBody = exceptionAttributes.getExceptionAttributes(noResultExcpetion,request,HttpStatus.NOT_FOUND);
        return new ResponseEntity<Map<String, Object>>(responseBody,HttpStatus.NOT_FOUND);
    }

}
