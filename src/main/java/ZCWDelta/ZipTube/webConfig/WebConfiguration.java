package ZCWDelta.ZipTube.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500") // adjust to your frontend port
                .allowedOrigins("http://127.0.0.1:5501") // adjust to your frontend port
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");

    }


}
