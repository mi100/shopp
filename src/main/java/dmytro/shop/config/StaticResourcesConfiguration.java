package dmytro.shop.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static dmytro.shop.service.FileService.IMG_DIR;

public class StaticResourcesConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println(IMG_DIR);
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:" + IMG_DIR);
    }
}
