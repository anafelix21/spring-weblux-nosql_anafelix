package pe.edu.vallegrande.app.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SwaggerUiController {

    @GetMapping(value = "/swagger-ui.html", produces = MediaType.TEXT_HTML_VALUE)
    public Mono<String> swaggerUi() {
        String html = """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <title>Swagger UI - Customer API</title>
                <link rel="stylesheet" href="https://unpkg.com/swagger-ui-dist@5.11.0/swagger-ui.css">
                <style>
                    body { margin: 0; padding: 0; }
                </style>
            </head>
            <body>
                <div id="swagger-ui"></div>
                <script src="https://unpkg.com/swagger-ui-dist@5.11.0/swagger-ui-bundle.js"></script>
                <script>
                    SwaggerUIBundle({
                        url: '/api-docs',
                        dom_id: '#swagger-ui',
                        presets: [SwaggerUIBundle.presets.apis],
                        layout: 'BaseLayout'
                    });
                </script>
            </body>
            </html>
        """;
        return Mono.just(html);
    }
}
