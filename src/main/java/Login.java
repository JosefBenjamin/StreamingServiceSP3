import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Login {
    private static final String USER_DATA = "src/main/java/files/Users.txt";               // This attribute ensures that path to .txt file is always predetermined
    //Start of constructor
    public Login() {

    } //End of constructor

    public void createUser(String username, String password) {                              // method returns nothing takes two parameters String username and String password
        if (User.isUsernameTaken(username, USER_DATA)) {                                    // checks condition from class User with methods isUsernameTaken, thus if username matches this code block executes
            System.out.println("Sorry! Username not available");
        } else {
            try (FileWriter writer = new FileWriter(USER_DATA, true)) {
                writer.write(username + "::" + password + "::1" +"\n");                  // Default user is not admin, there is only one admin user that is already made
                System.out.println("User created successfully!");
            } catch (IOException e) {
                System.out.println("Error saving user: \n");
                e.printStackTrace();
            }   // end try-catch-block
        }   // end if-else statement
    }   // end createUser()


    public boolean loginUser (String username, String password){
        boolean result = false;
        if (User.isUsernameTaken(username, USER_DATA) ) {
            File file = new File(USER_DATA);
            try (Scanner scan = new Scanner(file)) {                                          // We have chosen to put the declaration and instantiation of the Scanner Object inside a try-catch block
                                                                                              // Since the Scanner Object will close by itself
                while (scan.hasNextLine()) {                                                  // while loop condition stays 'true' so long as the file at USER_DATA has a new line
                    String line = scan.nextLine();                                            // Declares and instantiates the variable line as the current/next line
                    String[] value = line.split("::");                                  // Declares and instantiates an array 'sections'.
                    if (value.length == 3 && value[0].equals(username) && value[1].equals(password)) {
                        System.out.println("You've successfully logged in!\n");
                          return true;                                                      // When func returns true it means that the username is preoccupied
                    }   // if statement
                }   // end while loop
            } catch (FileNotFoundException e) {
                System.out.println("Error reading user data: " + e.getMessage());
            }   // end try-catch block
        } else {
            System.out.println("No username matches!\n");
        }   // end if-statement
    return result;
    }   // end loginUser() method
}   // end Login class
