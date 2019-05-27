/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author João
 */
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

    private static DataSource dataSource;

    public AppConfig() throws ClassNotFoundException {
        dataSource = AppConfig.getDataSource();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {

        String userSql = "SELECT email, senha, ativo FROM Usuario "
                + " WHERE email = ?";
        String roleSql = "SELECT u.email, p.nome FROM Usuario u, Papel p,"
                + " Usuario_Papel up WHERE up.usuario_id = u.id and"
                + " up.papel_id = p.id and u.email = ?";

        builder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(userSql)
                .authoritiesByUsernameQuery(roleSql)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

//@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/site_venda_crud/cadastro").hasRole("ADMIN")
//                .antMatchers("/promocao/filtrar_url").hasRole("SITE")
//                .antMatchers("/teatro_crud/cadastro").hasRole("ADMIN")
//                .antMatchers("/promocao/cadastro").hasAnyRole("TEATRO")
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic()
//                .and()
//		.exceptionHandling().accessDeniedPage("/erro/403")
//                .and()
//                .logout().logoutSuccessHandler(logoutSuccessHandler())
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
//}
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/site_venda_ingresso/form.ufscar").hasRole("ADMIN")
                .antMatchers("/promocao/filtrar_url").hasRole("SITE")
                .antMatchers("/teatro_crud/form.ufscar").hasRole("ADMIN")
                .antMatchers("/promocao/form.ufscar").hasAnyRole("TEATRO")
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessHandler(logoutSuccessHandler())
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

        http.csrf().disable();
    }

    private LogoutSuccessHandler logoutSuccessHandler() {
        LogoutSuccessHandler lsh = (HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) -> {
            hsr1.sendRedirect("/ProjetoWeb1");
        };
        return (lsh);
    }

    public static DataSource getDataSource() throws ClassNotFoundException {

        if (dataSource == null) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/ProjetoWeb1";
            String user = "root";
            String password = "root";
            dataSource = new DriverManagerDataSource(url, user, password);
        }

        return dataSource;
    }
}
