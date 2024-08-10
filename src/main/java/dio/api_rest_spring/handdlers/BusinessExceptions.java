package dio.api_rest_spring.handdlers;

public class BusinessExceptions extends RuntimeException {
    public BusinessExceptions (String message) {
        super(message);
    }
    public BusinessExceptions(String message, Object ... params) {
        super(String.format(message, params));
    }
}
