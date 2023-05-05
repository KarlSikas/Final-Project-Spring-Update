package com.example.finalprojectj19spring.handlers;

import com.example.finalprojectspring.utils.Constants;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


/**
 * @author Karl-Erik Sirkas
 * @Date 3/28/2023
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(Constants.Audit.DEFAULT_AUDITOR);
    }
}