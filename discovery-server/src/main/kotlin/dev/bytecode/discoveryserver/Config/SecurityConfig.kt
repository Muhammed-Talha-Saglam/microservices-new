package dev.bytecode.discoveryserver.Config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.DefaultSecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Value("\${eureka.username}")
    private lateinit var userName: String

    @Value("\${eureka.password}")
    private lateinit var password: String

    @Bean
    fun userDetailsService(): InMemoryUserDetailsManager? {
        NoOpPasswordEncoder.getInstance()
        val user: UserDetails = User.withDefaultPasswordEncoder()
            .username(userName)
            .password(password)
            .authorities("USER")
            .build()

        return InMemoryUserDetailsManager(user)
    }

    @Bean
    @Throws(Exception::class)
    fun configure(http: HttpSecurity): DefaultSecurityFilterChain? {
        http.csrf().disable()
            .authorizeHttpRequests().anyRequest()
            .authenticated()
            .and()
            .httpBasic()

        return http.build()
    }
}