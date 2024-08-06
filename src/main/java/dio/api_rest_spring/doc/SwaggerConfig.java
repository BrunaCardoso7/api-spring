package dio.api_rest_spring.doc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API de Usuários")
                        .description("Nesta aplicação de gerenciamento de usuário, é possível cadastrar novos usuários, listá-los entre outras operações.")
                        .version("v1.0")
                        .contact(new Contact().name("Bruna Cardoso")
                                .url("https://github.com/BrunaCardoso7")
                                .email("contato@brunacardoso.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação do Projeto")
                        .url("http://localhost:8080/"));
    }
}
