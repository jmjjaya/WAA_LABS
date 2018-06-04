/**
 * 
 */
package edu.mum.exercise_8B;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

/**
 * @author jeewa
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Bean("messageSource")
	   public MessageSource messageSource() {
	      ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
	      messageSource.setBasename("classpath:locale/welcome");
	      messageSource.setDefaultEncoding("UTF-8");
	      messageSource.setUseCodeAsDefaultMessage(true);
	      return messageSource;
	   }

	   @Bean
	   public CookieLocaleResolver localeResolver() {
	      CookieLocaleResolver localeResolver = new CookieLocaleResolver();
	      return localeResolver;
	   }

	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      ThemeChangeInterceptor themeChangeInterceptor = new ThemeChangeInterceptor();
	      themeChangeInterceptor.setParamName("theme");
	      registry.addInterceptor(themeChangeInterceptor);

	      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	      localeChangeInterceptor.setParamName("lang");
	      registry.addInterceptor(localeChangeInterceptor);
	   }
}
