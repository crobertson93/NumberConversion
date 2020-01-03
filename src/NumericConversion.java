

import java.util.Scanner;
public class NumericConversion {
    public static long hexStringDecode(String hex){              //decodes an entire hexadecimal string and returns it
                                                                 //value

        long step = 0;
        long total = 0;
        long wtf = 0;
        long hexVal = 0;
        int n = hex.length();
        for (int i = 0; i < n; i++){
            char x = hex.charAt(i);

            if (hex.charAt(2) == 'x'){
                i = -2;
                n = -2;
            }

            if (Character.isDigit(hex.charAt(i))) {               //translates the character of the string to a value
                if (x == '0') {
                    hexVal = 0;
                }
                else if (x == '1') {
                    hexVal = 1;
                }
                else if (x == '2') {
                    hexVal = 2;
                }
                else if (x == '3') {
                    hexVal = 3;
                }
                else if (x == '4') {
                    hexVal = 4;
                }
                else if (x == '5') {
                    hexVal = 5;
                }
                else if (x == '6') {
                    hexVal = 6;
                }
                else if (x == '7') {
                    hexVal = 7;
                }
                else if (x == '8') {
                    hexVal = 8;
                }
                else if (x == '9') {
                    hexVal = 9;
                }
            }

            if (Character.isLetter(hex.charAt(i))) {             // if a string character is a letter, assigns numerical
                if (x == 'a' || x == 'A') {                      //value
                    hexVal = 10;
                } else if (x == 'b' || x == 'B') {
                    hexVal = 11;
                } else if (x == 'c' || x == 'C') {
                    hexVal = 12;
                } else if (x == 'd' || x == 'D') {
                    hexVal = 13;
                } else if (x == 'e' || x == 'E') {
                    hexVal = 14;
                } else if (x == 'f' || x == 'F') {
                    hexVal = 15;
                }
            }

            step = (long)(hexVal * Math.pow(16, (n - 1 - i)));
            total = total + step;
        }

        return total;
    }

    public static short hexCharDecode(char digit){                           //Decodes a single hexadecimal digit and
        Short hexVal = 0;                                                    // returns its value

        if (Character.isLetter(digit)) {
            char x = digit;
            if (x == 'a' || x == 'A') {
                hexVal = 10;
            } else if (x == 'b' || x == 'b') {
                hexVal = 11;
            } else if (x == 'c' || x == 'C') {
                hexVal = 12;
            } else if (x == 'd' || x == 'D') {
                hexVal = 13;
            } else if (x == 'e' || x == 'E') {
                hexVal = 14;
            } else if (x == 'f' || x == 'F') {
                hexVal = 15;
            }
        }

        return hexVal;
    }

    public static short binaryStringDecode(String binary){         //Decodes a binary string and returns its value
        int i = 0;
        int n = binary.length();
        int binaryVal = 0;
        short last = 0;
        short decimal = 0;

        for (i = 0; i < n; i++) {
            char x = binary.charAt(i);

            if (binary.charAt(2) == 'b') {
                i = -2;
                n = -2;
            }
            if (Character.isDigit(binary.charAt(i))) {
                if (x == '0') {
                    binaryVal = 0;
                }

                if (x == '1') {
                    binaryVal = 1;
                }
            }

            decimal = (short) (binaryVal * (Math.pow(2, (n - 1 - i))));
            last = (short) (last + decimal);
        }

        return last;
    }

    public static String binaryToHex(String binary){            //decodes a binary string, re-encodes it as hexadecimal
        short hexDec = binaryStringDecode(binary);              // and returns the hexadecimal string
        short decimalNum = 0;
        char hexChar = '0';
        String binaryHex = "";
        String reverse = "";

        while(hexDec > 0) {
            decimalNum = (short) (hexDec % 16);
            if (decimalNum == 0) {
                hexChar = '0';
            }
            if (decimalNum == 1) {
                hexChar = '1';
            }
            if (decimalNum == 2) {
                hexChar = '2';
            }
            if (decimalNum == 3) {
                hexChar = '3';
            }
            if (decimalNum == 4) {
                hexChar = '4';
            }                                       //this general section turns a value into a hexadecimal character
            if (decimalNum == 5) {
                hexChar = '5';
            }
            if (decimalNum == 6) {
                hexChar = '6';
            }
            if (decimalNum == 7) {
                hexChar = '7';
            }
            if (decimalNum == 8) {
                hexChar = '8';
            }
            if (decimalNum == 9) {
                hexChar = '9';
            }
            if (decimalNum == 10) {
                hexChar = 'A';
            }
            if (decimalNum == 11) {
                hexChar = 'B';
            }
            if (decimalNum == 12) {
                hexChar = 'C';
            }
            if (decimalNum == 13) {
                hexChar = 'D';
            }
            if (decimalNum == 14) {
                hexChar = 'E';
            }
            if (decimalNum == 15) {
                hexChar = 'F';
            }
            binaryHex = binaryHex + hexChar;
            hexDec = (short) (hexDec / 16);
        }
        for(int i = binaryHex.length() - 1; i >= 0; i--)
        {
            reverse = reverse + binaryHex.charAt(i);
        }

        return reverse;

    }
    public static void main (String[] args){           //the main method prints the menu and gives the operation options

        Scanner scnrA = new Scanner(System.in);
        boolean menu = true;
        int operation = 0;
        String input;

        while(menu == true) {
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.println("");
            System.out.println("Please enter an option: ");


            operation = scnrA.nextInt();

            while (operation < 1 || operation > 4) {              //while unnecessary, this is an invalid selection loop
                System.out.println("Error, please enter valid selection.");
                System.out.println("");
                System.out.println("Please enter an option: ");

                operation = scnrA.nextInt();
            }

            if (operation == 4){                            //quits program
                System.out.println("Goodbye!");
                System.exit(0);
            }

            System.out.println("Please enter the numeric string to convert: ");



            String hex = scnrA.next();
            String binary = hex;





            if(operation == 1){                                      //performs operation 1
                double operationOne = hexStringDecode(hex);
                System.out.print("Result: ");
                System.out.printf("%.0f", operationOne);
                System.out.println("");

            }
            else if (operation == 2) {                              //performs operation 2
                short operationTwo = binaryStringDecode(binary);
                System.out.println("Result: " + operationTwo);
            }
            else if (operation == 3) {                              //performs operation 3
                String operationThree = binaryToHex(binary);
                System.out.println("Result: " + operationThree);
            }


            System.out.println("");
        }


    }
}
