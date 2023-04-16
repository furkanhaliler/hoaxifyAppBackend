package com.hoaxify.ws.constraint;

import com.hoaxify.ws.dao.UserRepository;
import com.hoaxify.ws.model.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

  @Autowired private UserRepository userRepository;

  @Override
  public boolean isValid(
      final String userName, final ConstraintValidatorContext constraintValidatorContext) {
    return !userRepository.existsByUserName(userName);
  }
}
