package com.algocrafters.app.cookbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Main security configuration to secure API endpoints.
 *
 * @author Vitali Tchalov (github/VitaliTch)
 * @author {name}
 *
 * @since 0.1
 */
@Configuration
@EnableWebSecurity
public class ApiSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /*
         * Access to every API endpoint requires the "user" to be authenticated.
         * 'permitAll' access allows Anonymous authentication.
         * Request path naming pattern:
         * - admin - system level access API
         * - account/admin - account level admin access API
         * - account/restricted - account level access API for users with POWERUSER role (privileges)
         * - public - any authenticated User, including Anonymous.
         */
        return http.authorizeHttpRequests(authorize -> authorize
                // NOTE: the order in which the matchers are specified DOES matter.
                // It should provide more control to arrange them in the order of requiring stricter security to more permissive.
                .requestMatchers("/v1/public/**").permitAll()
                .requestMatchers("/v1/account/restricted/**").hasRole("POWERUSER")
                .requestMatchers("/v1/account/admin/**").hasRole("ACCOUNT_ADMIN")
                // Access to any other API not matched to one of the patterns above is permitted for ANY authenticated user (including Anonymous).
                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                // TODO: 2023-12-09 temporary disabled while there is only a single available API permitted to public access.
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

}
