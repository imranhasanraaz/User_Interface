package utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.passay.CharacterData;
import org.passay.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static utils.RandomGenerator.getRandomInteger;


public class LoginDataGenerator {


    public static String getEmail(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    public static String getDomain() {
        List<String> domains = Arrays.stream(domainsList.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return domains.get(getRandomInteger(domains.size()));
    }

    public static String getPassword(String email, int length) {
        PasswordGenerator generator = new PasswordGenerator();
        final int numberOfCyrillicLetter = 1;
        final int numberOfUpperCaseLetter = 1;
        final int numberOfDigit = 1;
        final int numberOfAlphabeticalLetter = (length - (numberOfCyrillicLetter + numberOfUpperCaseLetter + numberOfDigit));


        CharacterData cyrillicLetter = CyrillicCharacterData.LowerCase;
        CharacterRule cyrillicRule = new CharacterRule(cyrillicLetter);
        cyrillicRule.setNumberOfCharacters(numberOfCyrillicLetter);

        CharacterData alphabeticalChars = EnglishCharacterData.Alphabetical;
        CharacterRule alphabeticalRule = new CharacterRule(alphabeticalChars);
        alphabeticalRule.setNumberOfCharacters(numberOfAlphabeticalLetter);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(numberOfUpperCaseLetter);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(numberOfDigit);


        String emailChar = String.valueOf(getRandomInteger(email.length()));

        return generator.generatePassword(length, cyrillicRule, alphabeticalRule, upperCaseRule, digitRule).concat(emailChar);

    }

    public enum domainsList {
        yahoo,
        gmail,
        hotmail,
        aol
    }
}