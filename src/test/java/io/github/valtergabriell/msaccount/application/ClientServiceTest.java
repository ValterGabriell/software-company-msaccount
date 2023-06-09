package io.github.valtergabriell.msaccount.application;

import io.github.valtergabriell.msaccount.application.dto.CreateClientRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Pattern;


import static io.github.valtergabriell.msaccount.application.exception.ExceptionsValues.EMAIL_PATTERN;
import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {


    @DisplayName(value = "Verify if id has 11 digits ")
    @ParameterizedTest
    @ValueSource(strings = {"12345678945"})
    void itShouldReturnTrueWhenIdHasElevenDigitsAndFalseWhenIsNot(String id){
        int length = id.length();
        assertEquals(11, length);
    }

    @DisplayName(value = "Verify if id has 14 ")
    @ParameterizedTest
    @ValueSource(strings = {"12345678912345"})
    void itShouldReturnTrueWhenIdHas14DigitsAndFalseWhenIsNot(String id){
        int length = id.length();
        assertEquals(14, length);
    }

    @DisplayName(value = "Verify if id is bigger than 11 and return true if it is 14")
    @ParameterizedTest
    @ValueSource(strings = {"12345678945236"})
    void itShouldReturnTrueWhenIdisBiggerThan11Andis14(String id){
        int length = id.length();
        if (length > 11){
            assertEquals(14, length);
        }
    }


    @DisplayName(value = "Verify if id has just one type of digit")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void itShouldReturnTrueIfCpfHasJustOneTypeOfNumber(String value){
        String newString = "1".repeat(11);
        assertEquals(value, newString);
    }

    @DisplayName(value = "Verify if phone number has 13 digits")
    @ParameterizedTest
    @ValueSource(strings = {"", "12345", "65478", "12345678945","1234567894562"})
    void itShouldReturnTrueWhenPhoneNumberHasFourteenDigitsAndFalseWhenIsNot(String phone){
        assertEquals(13, phone.length());
    }

    @DisplayName(value = "Verify if phone starts with 55")
    @ParameterizedTest
    @ValueSource(strings = {"", "12345", "65478", "12345678945","12345678945612", "553256"})
    void itShouldReturnTrueWhenPhoneNumberStartsWithFive(String phone){
        assertEquals("55", phone.substring(0, 2));
    }

    @DisplayName("Verify if is email valid")
    @ParameterizedTest
    @ValueSource(strings = {"vgabrielbri@hotmail.com", "用户名@领域.电脑"})
    void itShouldReturnTrueIfEmailIsValid(String email){
        String regexPattern = EMAIL_PATTERN;
        assertTrue(Pattern.compile(regexPattern).matcher(email).matches());
    }

}