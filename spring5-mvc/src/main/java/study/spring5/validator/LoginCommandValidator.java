package study.spring5.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import study.spring5.command.LoginCommand;

public class LoginCommandValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
    }
}
