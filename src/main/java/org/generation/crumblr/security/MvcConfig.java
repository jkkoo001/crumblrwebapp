package org.generation.crumblr.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;
@Configuration
public class MvcConfig implements WebMvcConfigurer {

//	@Value("${image.folder}")
//	private String imageFolder;
	// now imageFolder variable the value = productimages/images


	public void addViewControllers(ViewControllerRegistry registry) {
		//Map the browser's URL to a specific View (HTML) inside resources/templates directory
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/about").setViewName("about");
		registry.addViewController("/products").setViewName("products");
		registry.addViewController("/item-form").setViewName("item-form");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("index");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static")
			.addResourceLocations("classpath:/static/")
			.setCachePeriod(0);

		//expose the productimages folder to allow external client to access the files from the server
//		Path uploadDir = Paths.get(imageFolder);
//		String uploadPath = uploadDir.toFile().getAbsolutePath();
//
//		// ** to access all the images
//		registry.addResourceHandler("/" + imageFolder + "/**")
//			.addResourceLocations("file:" + uploadPath + "/")
//			.setCachePeriod(0);

	}  // override to add resource handler

}




