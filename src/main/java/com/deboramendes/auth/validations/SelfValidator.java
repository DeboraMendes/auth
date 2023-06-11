package com.deboramendes.auth.validations;

import com.deboramendes.auth.exceptions.AppExceptionGenerator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
@Valid
public abstract class SelfValidator {

    private final Validator validator;

    protected SelfValidator() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    protected void validateSelf(final SelfValidator selfValidator) {
        log.trace("m=validateSelf(selfValidator={})", selfValidator.getClass());
        final Set<ConstraintViolation<SelfValidator>> violations = validator.validate(selfValidator);
        if (!violations.isEmpty()) {
            violations.forEach(violation ->
                    log.error("{}.{}: {}",
                            violation.getRootBean().getClass(),
                            violation.getPropertyPath(),
                            violation.getMessage()
                    )
            );
            throw AppExceptionGenerator.generateBusinessException("Invalid data");
        }
    }
}
