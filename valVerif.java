import javafx.scene.control.TextField;

/*
=====================================================================
- valVerif - Class - used for error checking and validation when
  extracting input from TextField objects in JavaFX GUI
- Methods - verifName, verifPhone, verifDate
- Author: Damian Brito
- Date: 03/06/2020
=====================================================================
*/
public class valVerif {

    /*
     =====================================================================
      - verifName - validates string name
      - Input - String name
      - Output - Boolean result if name value passes or fails validation
     =====================================================================
    */
    public boolean verifName(TextField name){
        // character array is created from value from Name TextField
        char[] nameList = name.getText().toCharArray();

        // checks that the string has been entered into method
        if (nameList.length < 3){
            return false;
        }

        // loops through each char in nameList
        for (char letter : nameList){

            // if letter is a number, dash, period, or space
            if (Character.isDigit(letter) || (!Character.isAlphabetic(letter) && letter != '-') &&
                    (letter != '.' && letter != ' ')){
                // method will return false
                return false;
            }
        }
        // if for loop is not tripped, then method will return true and name has passed validation.
        return true;
    } // end of verifName


    /*
     ===========================================================================
      - verifPhone - validates string phone number
      - Input - String phone number
      - Output - Boolean result if phone number value passes or fails validation
     ===========================================================================
    */
    public boolean verifPhone(TextField phone) {
        // if loop checks if there are dashes in phone number
        if (phone.getText().contains("-")) {
            // the string is split into three groups ([123,456,7890] 123-456-7890)
            String[] phoneNumPieces = phone.getText().split("-");

            // if each section has less than 3 digits then false is returned
            if (phoneNumPieces.length < 3) {
                return false;
            } else {

                // for each section in phone number
                for (String section : phoneNumPieces) {
                    // section is split into chars and each char is checked
                    // to verify that it is a digit
                    char[] pList = section.toCharArray();

                    for (char digit : pList) {
                        // if the digit is an actual letter, then the method returns false
                        if (Character.isAlphabetic(digit)) {
                            return false;
                        }
                    }
                }
            }
        } else {
            char[] pList = phone.getText().toCharArray();
            // if user input is just numbers, the string is then split into chars
            // and each char is screened to verify it is not a letter
            for (char digit : pList) {
                // if the digit is an actual letter, then the method returns false
                if (Character.isAlphabetic(digit)) {
                    return false;
                }
            }
        }
        // returns true if validation passes
        return true;
    } // end of verifPhone


    /*
     ===========================================================================
      - verifDate - validates date
      - Input - String date
      - Output - Boolean result if date value passes or fails validation
     ===========================================================================
    */
    public boolean verifDueDate(TextField dueDate){
        // checks if value from textfield has slashes
        if (dueDate.getText().contains("/")){

            // date is now split into three sections accordingly
            String[] dateSplit = dueDate.getText().split("/");

            // if during split, the format was not mm/dd/yy, then the length of dateSplit is not three
            // if loop is true, then method returns false
            if (dateSplit.length < 3){
                return false;
            } else {
                // try statement is initiated to test if date only has numbers
                try {
                    // each date has been assigned to a variable
                    int month = Integer.parseInt(dateSplit[0]);
                    int day = Integer.parseInt(dateSplit[1]);
                    int yr = Integer.parseInt(dateSplit[2]);

                    // if the month is not within range 1 -12 or day not in range 1 - 31 or year is less than 2019
                    // then method returns false
                    if (((0 > month | month > 12) | (0 > day | day > 32)) | 2019 > yr){
                        return false;
                    }
                    // if any of those are not digits, then the exception is thrown and caught here, which
                    // returns false
                } catch (NumberFormatException nfe) {
                    return false;
                }
            }
            // This part will do the same as above if the input has dashes instead of slashes
        } else if (dueDate.getText().contains("-")){
            String[] dateSplit = dueDate.getText().split("-");
            try {
                int month = Integer.parseInt(dateSplit[0]);
                int day = Integer.parseInt(dateSplit[1]);
                int yr = Integer.parseInt(dateSplit[2]);
                if (((0 > month | month > 12) | (0 > day | day > 32)) | 2019 > yr){
                    return false;
                }
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        // returns true if no false statements have been tripped
      return true;
    }

// end of class
}
