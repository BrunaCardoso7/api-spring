package dio.api_rest_spring.handdlers;

public class RequiredFieldsException extends BusinessExceptions{
    public RequiredFieldsException(String campo) {
        super("O campo %s é obrigatório", campo);
    }
}
