package com.chernuw.validator;


import com.chernuw.model.Footwear;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class FootwearValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return Footwear.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.required");

        Footwear footwear = (Footwear) o;
        if (footwear.getPrice() < 0 ) {
            errors.rejectValue("price", "price.incorrect");
        }
    }
}
