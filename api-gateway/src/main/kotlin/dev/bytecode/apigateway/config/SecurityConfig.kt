package dev.bytecode.apigateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun springSecurityFilterChain(serverHttpSecurity: ServerHttpSecurity): SecurityWebFilterChain {
        serverHttpSecurity.csrf()
            .disable()
            .authorizeExchange { exchange ->
                exchange
                    .pathMatchers("/eureka/**")
                    .permitAll()
                    .anyExchange()
                    .authenticated()
            }
            .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt)

        return serverHttpSecurity.build()
    }
}