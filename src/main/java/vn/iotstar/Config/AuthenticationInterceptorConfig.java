package vn.iotstar.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import vn.iotstar.interceptor.AdminAuthenticationInterceptor;
import vn.iotstar.interceptor.SideAuthenticationInterceptor;

@Configuration
public class AuthenticationInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private AdminAuthenticationInterceptor adminAuthenticationInterceptor;
	
	@Autowired
	private SideAuthenticationInterceptor sideAuthenticationInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminAuthenticationInterceptor)
		.addPathPatterns("/admin/**");
		
		registry.addInterceptor(sideAuthenticationInterceptor)
		.addPathPatterns("/side/**");
	}

}
