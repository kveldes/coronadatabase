/*
Διάμεσου αυτής της κλάσης ορίζουμε τις δίκες μας ρυθμίσεις στο Spring Boot Security.
 Through this class we define our own settings in Spring Boot Security.
*/
package com.test.coronadatabase;


import java.util.Arrays;
import com.test.coronadatabase.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


//Με τις παρακάτω σημάνσεις απενεργοποιούμε την default web ρύθμιση ασφάλειας και ορίζουμε διάμεσου αυτής της κλάσης τις δίκες μας ρυθμίσεις.
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Override //Μέθοδος από την οποία ορίζουμε ποια endpoints είναι ασφαλή και ποια όχι.
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().disable().cors().and().authorizeRequests().anyRequest().permitAll();

        http.csrf().disable().cors().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated() //Ορίζουμε ότι η POST μέθοδο που αιτείτε το /Login endpoint επιτρέπετε χωρίς authentication &
                                             // όλα τα αλλά αιτήματα για endpoint πέραν του Login θα απαιτούν authentication.
                .and()
                // Filter for the api/login requests
                .addFilterBefore(new LoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // Filter for other requests to check JWT in header
                .addFilterBefore(new AuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);

    }

    /**
     * Κάνουμε χρήση σε αυτή την class του CROS (Cross origin Resource Sharing filter).
     * Αυτό χεριάζετε από το frontend το οποίο στέλνει αιτήματα από άλλες πήγες origin.
     * To cross filter υποκλέβει αιτήματα και αν ανίχνευση cross origin προσθέτει τα απαραίτητα headers στο αίτημα.
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        //config.setAllowCredentials(false);
        config.setAllowCredentials(true);
        config.applyPermitDefaultValues();

        source.registerCorsConfiguration("/**", config);
        return source;
    }



    /**
     * Μέθοδος η οποία καθιστά ενεργούς χρήστες από την DB.
     * Ποτέ δεν σώζουμε τα passwds με την μορφή απλού κειμένου στην Db.
     * Οπότε εμείς καθορίζουμε έναν passwd hasing αλγόριθμο μέσα στην configureGlobal μέθοδο. Εδώ χρησιμοποιούμε τον BCrypt αλγόριθμο.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}

