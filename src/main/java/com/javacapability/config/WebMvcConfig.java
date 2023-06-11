package com.javacapability.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.javacapability.repo.JCRepoImp;
import com.javacapability.repo.JCRepository;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.javacapability.controller", "com.javacapability.repo" })
public class WebMvcConfig {
	

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");

		return vr;
	}

	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/javacompetency");
		ds.setUsername("root");
		ds.setPassword("Nithin@6");

		return ds;
	}

	@Bean
	public JCRepository getJCRepository() {
		return new JCRepoImp(getDataSource());
	}

	

	

}
