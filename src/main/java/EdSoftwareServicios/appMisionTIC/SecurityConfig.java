package EdSoftwareServicios.appMisionTIC;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/users").hasRole("ADMINISTRADOR")
                .antMatchers("/movements").hasAnyRole("ADMINISTRADOR","OPERATIVO")
                .antMatchers("/enterprises").hasAnyRole("ADMINISTRADOR","OPERATIVO")
                .antMatchers(HttpMethod.PATCH, "/movements/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.DELETE, "/movements/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.DELETE, "/enterprises/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.PATCH, "/users/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.PATCH, "/enterprises/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.POST, "/enterprises/**").hasRole("ADMINISTRADOR")
                .antMatchers(HttpMethod.POST, "/users/**").hasRole("ADMINISTRADOR")
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("correo")
                .passwordParameter("password")
                .defaultSuccessUrl("/")

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
        ;


    }
}