package stringValidator;

import static java.lang.Character.*;

/**
 * @author Rhiannon Farren
 */
public class StringValidator {
    public boolean validateString(String userInput) {
        // RULE 1 : String starts with a capital letter
        if (!isUpperCase(userInput.charAt(0))) {
            // return false - first character is lowercase therefore string is invalid
            return false;
        }
        
        // RULE 2 : String has an even number of quotation marks
        // RULE 4 : String has no period character other than the last character
        // initialise quotationCount to hold number of quotations in the string
        int quotationCount = 0;
        // initialise periodCount to hold number of periods in the string
        int periodCount = 0;
        // check every character in string for quotation marks and periods and increment relevant variable
        for (char c : userInput.toCharArray()) {
            if (c == '"') {
                quotationCount++;
            }
            if (c == '.') {
                periodCount++;
            }
        }
        // check if quotationCount is an even number
        if (quotationCount%2 != 0) {
            // return false - odd number of quotation marks therefore string is invalid
            return false;
        }
        // check if periodCount is greater than 1
        if (periodCount > 1) {
            // return false - there is more than one period charcter within string therefore its invalid
            return false;
        }
        
        // RULE 3 : String ends with a period character
        // initialise noOfChars as total number of characters in string to get the position of the last character
        int noOfChars = userInput.toCharArray().length;
        if (userInput.charAt(noOfChars - 1) != '.') {
            // return false - last character isn't a period character therefore string is invalid
            return false;
        }
        
        // RULE 5 : Numbers below 13 are spelled out ("one", "two", etc...)
        /*
         As each character is being checked as an individual, an extra for loop is needed to check
         if there are any numbers with more than one character e.g. 12
         The numberInString variable will be used to hold the full number in the string
        */
        String numberInString = "";
        for (int i = 0; i < userInput.toCharArray().length; i++) {
            // check numberInString variable to make sure number hasnt already been checked
            if (isDigit(userInput.charAt(i)) && !numberInString.isEmpty()) {
                // character is already apart of number checked in previous iteration
                continue;
            } else {
                // reassign variable to empty string for next number in string if needed
                numberInString = "";
            }
            // check every character in string for a number using isDigit
            if (isDigit(userInput.charAt(i))) {
                // assign the first digit to this variable
                numberInString = String.valueOf(userInput.charAt(i));
                // for loop to check next characters for digits as number can be greater than 9
                for (int j = i+1; j < userInput.toCharArray().length; j++) {
                    if (isDigit(userInput.charAt(j))) {
                        numberInString = numberInString + String.valueOf(userInput.charAt(j));
                    } else {
                        // break out of loop as next character isnt a number
                        break;
                    }
                }
                // check if this number is below 13 otherwise the sentence is valid
                if (Integer.parseInt(numberInString) < 13) {
                    // return false - string contains a number below 13
                    return false;
                }
            }
        }
        return true;
    }
}
