package org.jargc;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

//@Provider
public class SmartbarExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        if(causedByConstrainViolation(e)){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                //.entity(e.getClass().getName())
                .build();
    }

    private static boolean causedByConstrainViolation(Exception e){
        Throwable cause = e.getCause();
        while(cause!=null){
            if(cause instanceof ConstraintViolationException){
                return true;
            }
            cause = cause.getCause();
        }
        return false;
    }
}
