package stringValidator;

import static org.junit.Assert.*;

/**
 * @author Rhiannon Farren
 */
public class StringValidatorTest {
    
    public StringValidatorTest() {
    }

    /**
     * Tests of validateString method, of class StringValidator.
     */
    @org.junit.Test
    public void testRule1Invalid() {
        System.out.println("testRule1");
        String userInput = "the quick brown fox said \"hello Mr lazy dog\".";
        StringValidator instance = new StringValidator();
        boolean expResult = false;
        boolean result = instance.validateString(userInput);
        assertEquals("Failed. String was returned to be valid incorrectly", expResult, result);
    }
    @org.junit.Test
    public void testRule1Valid() {
        System.out.println("testRule1");
        String userInput = "The quick brown fox said \"hello Mr lazy dog\".";
        StringValidator instance = new StringValidator();
        boolean expResult = true;
        boolean result = instance.validateString(userInput);
        assertEquals("Failed. String was returned to be valid incorrectly", expResult, result);
    }
    
    @org.junit.Test
    public void testRule2Invalid() {
        System.out.println("testRule2");
        String userInput = "\"The quick brown fox said \"hello Mr lazy dog\".";
        StringValidator instance = new StringValidator();
        boolean expResult = false;
        boolean result = instance.validateString(userInput);
        assertEquals("Failed. String was returned to be valid incorrectly", expResult, result);
    }
    @org.junit.Test
    public void testRule2Valid() {
        System.out.println("testRule2");
        String userInput = "The quick brown fox said hello Mr lazy dog.";
        StringValidator instance = new StringValidator();
        boolean expResult = true;
        boolean result = instance.validateString(userInput);
        assertEquals("Failed. String was returned to be valid incorrectly", expResult, result);
    }
    
    @org.junit.Test
    public void testRule3Invalid() {
        System.out.println("testRule3");
        String userInput = "The quick brown fox said \"hello Mr lazy dog.\"";
        StringValidator instance = new StringValidator();
        boolean expResult = false;
        boolean result = instance.validateString(userInput);
        assertEquals("Failed. String was returned to be valid incorrectly", expResult, result);
    }
    
    @org.junit.Test
    public void testRule4Invalid() {
        System.out.println("testRule4");
        String userInput = "The quick brown fox said \"hello Mr. lazy dog\".";
        StringValidator instance = new StringValidator();
        boolean expResult = false;
        boolean result = instance.validateString(userInput);
        assertEquals("Failed. String was returned to be valid incorrectly", expResult, result);
    }
    
    @org.junit.Test
    public void testRule5Invalid() {
        System.out.println("testRule5");
        String userInput = "One lazy dog is too few, 12 is too many.";
        StringValidator instance = new StringValidator();
        boolean expResult = false;
        boolean result = instance.validateString(userInput);
        assertEquals("Failed. String was returned to be valid incorrectly", expResult, result);
    }
    @org.junit.Test
    public void testRule5Valid() {
        System.out.println("testRule5");
        String userInput = "One lazy dog is too few, twelve is too many.";
        StringValidator instance = new StringValidator();
        boolean expResult = true;
        boolean result = instance.validateString(userInput);
        assertEquals("Failed. String was returned to be valid incorrectly", expResult, result);
    }
    @org.junit.Test
    public void testRule5Valid_2() {
        System.out.println("testRule5");
        String userInput = "One lazy dog is too few, 15 is too many.";
        StringValidator instance = new StringValidator();
        boolean expResult = true;
        boolean result = instance.validateString(userInput);
        assertEquals("Failed. String was returned to be valid incorrectly", expResult, result);
    }
}
