package com.hoaxify.ws.constraint;

import com.hoaxify.ws.dao.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

  @Autowired private UserRepository userRepository;

  @Override
  public boolean isValid(
      final String username, final ConstraintValidatorContext constraintValidatorContext) {
    return !userRepository.existsByUsername(username);
  }
}
