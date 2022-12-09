package gr.codelearn.javapathjakartarestadvantageshowcase.exception;

import gr.codelearn.javapathjakartarestadvantageshowcase.transfer.ApiError;
import gr.codelearn.javapathjakartarestadvantageshowcase.transfer.ApiResponse;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Provider
@Slf4j
public class ValidationExceptionHandler implements ExceptionMapper<ValidationException> {
    @Override
    public Response toResponse(ValidationException exception) {
        log.info("Test placeholder {}", LocalDateTime.now());
        Response.Status response = Response.Status.BAD_REQUEST;
        return Response
                .status(response)
                .entity(
                        ApiResponse.builder().apiError(
                                new ApiError(response.getStatusCode(),exception.getMessage())
                        )
                .build()

        ).build();
    }
}
