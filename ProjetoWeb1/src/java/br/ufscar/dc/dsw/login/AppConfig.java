package br.ufscar.dc.dsw.login;



import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public AppConfig() throws ClassNotFoundException {
        dataSource = JDBCUtil.getDataSource();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {

        builder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email, senha, ativo"
                        + " from Usuario where email = ?")
                .authoritiesByUsernameQuery("select email, nome "
                        + "from Papel where email = ?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/site_venda_crud/cadastro").hasRole("ADMIN")
                .antMatchers("/promocao/filtrar_url").hasRole("SITE")
//                .antMatchers("/teatro_crud/lista").anonymous()
                .antMatchers("/teatro_crud/cadastro").hasAnyRole("ADMIN", "TEATRO")
                .antMatchers("/promocao/cadastro").hasAnyRole("ADMIN", "TEATRO")
//                .antMatchers("/promocao/lista").hasAnyRole("ADMIN", "TEATRO", "SITE")
//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
		.exceptionHandling().accessDeniedPage("/erro/403")
                .and()
                .logout().logoutSuccessHandler(logoutSuccessHandler())
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    private LogoutSuccessHandler logoutSuccessHandler() {
        LogoutSuccessHandler lsh = (HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) -> {
            hsr1.sendRedirect("/ProjetoWeb1");
        };
        return (lsh);
    }
}
