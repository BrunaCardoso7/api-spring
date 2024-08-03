package dio.api_rest_spring;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {
    public int Somar (int a, int b) {
        return a + b;
    }
}
