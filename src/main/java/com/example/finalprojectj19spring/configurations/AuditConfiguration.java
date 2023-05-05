package com.example.finalprojectj19spring.configurations;

import com.example.finalprojectj19spring.handlers.AuditAwareHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Karl-Erik Sirkas
 * @Date 3/29/2023
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditConfiguration {
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditAwareHandler();
    }
}
