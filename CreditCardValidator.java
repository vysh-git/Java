import java.util.Scanner;
public class CreditCardValidator {
     private String ccNumber;
    
        // Constructor to read credit card number
        public CreditCardValidator(String ccNumber) {
            this.ccNumber = ccNumber;
        }
    
        // Method to validate the credit card
        public void validate() {
            int length = ccNumber.length();
            if (length < 8 || length > 9) {
                System.out.println("Invalid credit card number");
                return;
            }
    
            // Step a: Remove the last digit
            char lastDigitChar = ccNumber.charAt(length - 1);
            int lastDigit = Character.getNumericValue(lastDigitChar);
            String remainingNumber = ccNumber.substring(0, length - 1);
    
            // Step b: Reverse the remaining digits
            String reversed = new StringBuilder(remainingNumber).reverse().toString();
    
            // Step c: Double the digits in odd positions and sum them
            int sum = 0;
            for (int i = 0; i < reversed.length(); i++) {
                int digit = Character.getNumericValue(reversed.charAt(i));
                if (i % 2 == 0) { // Odd-positioned in 1-based index
                    digit *= 2;
                    if (digit > 9) {
                        digit = digit / 10 + digit % 10; // Add the digits if doubled result is two digits
                    }
                }
                sum += digit;
            }
    
            // Step d: Add up all the digits
            // Already done in the loop
    
            // Step e: Subtract the last digit from 10
            int checkDigit = 10 - (sum % 10);
    
            // Step f: Compare checkDigit with lastDigit
            switch (checkDigit) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    if (checkDigit == lastDigit) {
                        System.out.println("Valid credit card number");
                    } else {
                        System.out.println("Invalid credit card number");
                    }
                    break;
                default:
                    System.out.println("Invalid credit card number");
            }
        }
    
        // Main method
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            // Read the credit card number from the user
            System.out.print("Enter the credit card number: ");
            String ccNumber = scanner.nextLine();
    
            // Create an instance of the CreditCardValidator class and validate
            CreditCardValidator validator = new CreditCardValidator(ccNumber);
            validator.validate();
    
            scanner.close();
        }
    }
    

