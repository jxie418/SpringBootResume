package james.xie.resume.api.controller;


import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by jamesxieaudaexplorecom on 5/6/16.
 */
public interface ExceptionAttributes {
    Map<String,Object> getExceptionAttributes(Exception exception, HttpServletRequest httpRequest, HttpStatus httpStatus);

}
