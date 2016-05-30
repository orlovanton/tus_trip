package ru.tustrip.portal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by antonorlov on 27/05/16.
 */
@ControllerAdvice
@Controller
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory
            .getLogger(GlobalExceptionHandler.class);

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = BaseException.class)
//    public String handleBaseException(BaseException e){
//        return e.getMessage();
//    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e){
        logger.error("Exception occured: ", e);
        return "error";
    }
}
