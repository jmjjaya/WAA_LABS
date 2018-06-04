/**
 * 
 */
package edu.mum.exercise_8B;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author jeewa
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/welcome")
				.hasAnyRole("SALES", "ADMIN", "ACCOUNTANT").antMatchers("/cars").hasAnyRole("SALES", "ADMIN")
				.antMatchers("/books").hasAnyRole("ADMIN", "ACCOUNTANT").anyRequest().authenticated().and().formLogin()
				.permitAll().and().logout().permitAll();

		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("sales").password("sales").authorities("ROLE_SALES").and()
				.withUser("admin").password("admin").authorities("ROLE_ADMIN").and().withUser("accountant")
				.password("acct").authorities("ROLE_ACCOUNTANT");
	}

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
