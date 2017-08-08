package com.chernuw.validator;

import com.chernuw.model.User;
import com.chernuw.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "confirmPassword.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "nameReg.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phoneReg.required");
        User user = (User) o;
////////////////////////////////
//        USERNAME
////////////////////////////////
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "username.exists");
        }
        Pattern patternUsername = Pattern.compile("^[a-zA-Z0-9_]{2,20}$");
        Matcher matcherUsername = patternUsername.matcher(user.getUsername());
        if (!matcherUsername.matches()){
            errors.rejectValue("username", "username.onlyAlphaNumeric");
        }
        if(user.getUsername().length()<2){
            errors.rejectValue("username","username.short");
        }
        if(user.getUsername().length()>20){
            errors.rejectValue("username","username.long");
        }
////////////////////////////////
//        PASSWORD
////////////////////////////////
        Pattern patternPassword = Pattern.compile("(?=^.{4,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\n");
        Matcher matcherPassword = patternPassword.matcher(user.getPassword());
        if (!matcherPassword.matches()){
            errors.rejectValue("password", "password.onlyAlphaNumericSymbols");
        }
        if (user.getPassword().length() < 4) {
            errors.rejectValue("password", "password.short");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.notMatch");
        }
////////////////////////////////
//        NAME
////////////////////////////////
        Pattern patternName = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]{2,20}$");
        Matcher matcherName = patternName.matcher(user.getName());
        if (!matcherName.matches()){
            errors.rejectValue("name", "name.onlyAlpha");
        }
        if(user.getName().length()<2){
            errors.rejectValue("name","name.short");
        }
        if(user.getName().length()>20){
            errors.rejectValue("name","name.long");
        }
////////////////////////////////
//        SURNAME
////////////////////////////////
        Pattern patternSurname = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]{2,20}$");
        Matcher matcherSurname = patternSurname.matcher(user.getName());
        if (!matcherSurname.matches()){
            errors.rejectValue("surname", "surname.onlyAlpha");
        }
        if(user.getSurname().length()<2){
            errors.rejectValue("surname","surname.short");
        }
        if(user.getSurname().length()>20){
            errors.rejectValue("surname","surname.long");
        }
////////////////////////////////
//        PHONE
////////////////////////////////
        if (!user.getPhone().matches("\\+\\d{12}")) {
            errors.rejectValue("phone", "phone.incorrect");
        }
////////////////////////////////
//        EMAIL
////////////////////////////////
        if (!user.getEmail().isEmpty() && !user.getEmail().matches(".+@\\w+\\.\\w+")) {
            errors.rejectValue("email", "email.incorrect");
        }
    }
}
