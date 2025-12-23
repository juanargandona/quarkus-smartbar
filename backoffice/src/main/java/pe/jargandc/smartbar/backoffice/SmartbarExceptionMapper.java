package pe.jargandc.smartbar.backoffice;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class SmartbarExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception e) {
        if(causedByConstrainViolation(e)){
            return Response.status(Response.Status.CONFLICT).build();
        }
        throw new RuntimeException(e);
    }

    private static boolean causedByConstrainViolation(Exception e){
        Throwable cause = e.getCause();
        while(cause!=null){
            if(cause instanceof ConstraintViolationException){
                return true;
            }
        }
        return false;
    }
}
