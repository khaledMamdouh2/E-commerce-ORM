package com.pettopia.view.utilities;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationChecks {

    private final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-.]+([A-Za-z0-9-_.]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9-]+)*(.[A-Za-z]{2,})$");
    private final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z[ ]{0,1}]{3,20}$");
    private final Pattern CREDIT_NO_PATTERN = Pattern.compile("^[0-9]{16}$");
    private final Pattern CREDIT_LIMIT_PATTERN = Pattern.compile("^[1-9]\\d*$");
    private Matcher patternMatcher;

    /**
     * check if the string is empty or not
     *
     * @param string
     * @return - true if empty <br>
     * - false if not
     *
     */
    public boolean isEmptyString(String string) {
        boolean emptyString = false;
        if (string.trim().length() == 0 || string.equals(null) || "".equals(string.trim())) {
            emptyString = true;
        }
        return emptyString;
    }

    /**
     * check if the email is valid or not
     *
     * @param email
     * @return - true if valid <br>
     * - false if not
     *
     */
    public boolean isEmail(String email) {
        patternMatcher = EMAIL_PATTERN.matcher(email);
        return !isEmptyString(email) && patternMatcher.matches();
    }

    /**
     * check if the name is valid or not
     *
     * @param name
     * @return - true if valid <br>
     * - false if not
     *
     */
    public boolean isName(String name) {
        patternMatcher = NAME_PATTERN.matcher(name);
        return !isEmptyString(name) && patternMatcher.matches();
    }

    /**
     * check if the age of the user is legal or not
     *
     * @param dateOfBirth
     * @return - true if legal <br>
     * - false if not
     *
     */
    public boolean isLegalAged(LocalDate dateOfBirth) {
        boolean legalAge = false;
        if (!isEmptyString(dateOfBirth.toString()) && dateOfBirth.getYear() <= 2000) {
            legalAge = true;
        }

        return legalAge;
    }

    /**
     * check if the password is valid or not, it should be more than or equal 8
     * and less than or equal 30
     *
     * @param pass
     * @return - true if valid <br>
     * - false if not
     *
     */
    public boolean isValidPassword(String pass) {
        boolean validPass = false;
        if (pass.length() >= 8 && pass.length() <= 30) {
            validPass = true;
        }
        return validPass;
    }

    /**
     * check if the confirmation password matches the password or not, it should
     * be more than or equal 8 and less than or equal 30
     *
     * @param pass
     * @param confirmPass
     * @return - true if valid <br>
     * - false if not
     *
     */
    public boolean isMatchPassword(String pass, String confirmPass) {
        boolean matchPass = false;
        if (pass.equals(confirmPass)) {
            matchPass = true;
        }
        return matchPass;
    }

    /**
     * check if the credit-limit is valid or not
     *
     * @param creditLimit
     * @return - true if valid <br>
     * - false if not
     *
     */
    public boolean isValidCreditLimit(String creditLimit) {
        patternMatcher = CREDIT_LIMIT_PATTERN.matcher(creditLimit);
        return !isEmptyString(creditLimit) && patternMatcher.matches();
    }

    /**
     * check if the credit number is valid or not
     *
     * @param creditNo
     * @return - true if valid <br>
     * - false if not
     *
     */
    public boolean isValidCreditNo(String creditNo) {
        patternMatcher = CREDIT_NO_PATTERN.matcher(creditNo);
        return !isEmptyString(creditNo) && patternMatcher.matches();
    }

}
