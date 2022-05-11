package ecommerceapp.exception.handler;

import ecommerceapp.exception.InvalidAdminDetailsException;
import ecommerceapp.exception.InvalidUserDetailsException;
import ecommerceapp.exception.OrderDetailsMisMatchException;
import ecommerceapp.exception.ProductDetailsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SportyShoesExceptionHandler {

    @ExceptionHandler(InvalidUserDetailsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleInvalidUserDetailsException(final InvalidUserDetailsException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(InvalidAdminDetailsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleInvalidAdminDetailsException(final InvalidAdminDetailsException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(ProductDetailsNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleProductDetailsNotFoundException(final ProductDetailsNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(OrderDetailsMisMatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleOrderDetailsMisMatchException(final OrderDetailsMisMatchException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleException(final Exception exception) {
        return exception.getMessage();
    }

}
