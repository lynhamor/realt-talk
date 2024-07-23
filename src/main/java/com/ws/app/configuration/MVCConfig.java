package com.ws.app.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ws.app.util.CommonConstants;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.ws.app" })
public class MVCConfig implements WebMvcConfigurer {

	private static final int CACHE_PERIOD = 31556926; // one year cache period
	
	private static final Logger LOG = LoggerFactory.getLogger(MVCConfig.class);
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		try {
			registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
			registry.addViewController("/")
					.setViewName("index");

			LOG.info("addViewControllers..");
		}catch (Exception e) {
			LOG.error("Error Encountered: {}",e.getMessage());
		}
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		try {
			registry.addResourceHandler("/"+CommonConstants.ASSETS+"/**")
					.addResourceLocations("/"+CommonConstants.ASSETS+"/")
					.setCachePeriod(CACHE_PERIOD)
					.resourceChain(true)
					.addResolver(new PathResourceResolver());
			
			LOG.info("addResourceHandlers..");
		}catch (Exception e) {
			LOG.error("Error Encountered: {}",e.getMessage());
		}
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		try {

			InternalResourceViewResolver resolver = new InternalResourceViewResolver();
			resolver.setPrefix(CommonConstants.WEB_PREFIX);
			resolver.setSuffix(CommonConstants.JSP);
			resolver.setViewClass(JstlView.class);
			registry.viewResolver(resolver);
			
			LOG.info("configureViewResolvers..");
		} catch (Exception e) {
			LOG.error("Error Encountered: {}",e.getMessage());
		}
	}
}
