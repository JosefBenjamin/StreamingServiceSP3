import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class User {
    private String username;
    private String password;
    boolean isAdmin;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAdmin = false;
    } //  Constructor

    // make it so user cannot use "::" in a password or username;

    // 'if (String password.matches("::") || String username.matches("::")){
    // System.out.println("You're not allowed to use repeated \":\" symbols in your password or username\nPlease chose another username or password");
    // *recursion*
    // }

     private static final String USER_DATA = "src/main/java/files/Users.txt";

    public static void createUser(String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("Sorry! Username not available");
            return;
        } else {

        try (FileWriter writer = new FileWriter(USER_DATA, true)) {
            writer.write(username + "::" + password + "::1" +"\n");                 // "1" is added to show that a newly created user is NOT an admin ("0" means admin)
            System.out.println("User created successfully!");
        } catch (IOException e) {
            System.out.println("Error saving user: \n");
            e.printStackTrace();
            }   // end try-catch-block
        }   // end if-else statement
    }   // end createUser()


    public static boolean isUsernameTaken(String username) {
        File file = new File(USER_DATA);                                                  // Declares & instantiates a File Object based on the path USER_DATA which is defined in global-scope
        try (Scanner scan = new Scanner(file)) {                                          // We have chosen to put the declaration and instantiation of the Scanner Object inside a try-catch block
                                                                                          // Since the Scanner Object will close by itself

            while (scan.hasNextLine()) {                                                  // while loop condition stays 'true' so long as the file at USER_DATA has a new line
                String line = scan.nextLine();                                            // Declares and instantiates the variable line as the current/next line
                String[] sections = line.split("::");                               // Declares and instantiates an array 'sections'.
                                                                                          // The Array contains 3 indies [0]-username, [1]-password, [2]-permission status
                if (    sections.length !=2 ||
                        sections.length > 0 && sections[0].equals(username)) {
                    return true;                                                          // When func returns true it means that the username is preoccupied
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }
        return false;                                                                     // When func returns false it means the username is available
    }

    public static boolean login(String username, String password) {

        // Use a try-with-resources block to automatically close the Scanner object after use.
        try (Scanner scan = new Scanner(USER_DATA)) {

            // Read the file line by line.
            while (scan.hasNextLine()) {
                String line = scan.nextLine();                                              // Reads the next line from the file.

                String[] sections = line.split("::");                                 // Splits the line into an array using "::" as the splitting point ().
                                                                                            // Expected array format: [0]-username, [1]-password, [2]-admin flag.

                if (    sections.length == 3 &&                                             // Ensures the line has exactly 3 parts (username, password, admin flag).
                        sections[0].equals(username) &&                                     // Compares the username in the file with the input username.
                        sections[1].equals(password)) {                                     // Compares the password in the file with the input password.
                    return true;                                                            // If both match, the method returns true, indicating successful login.
                }   // end if-statement
            }   // end while-loop
        } // catch (FileNotFoundException e) {                                                 // Handles the case where the file is not found.
            // System.out.println("Error: User data file not found. " + e.getMessage());
        // }   // end try-catch block

        return false;                                                                       // If no matching username-password pair is found, return false.
    }   // end login()



/*
    public static boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("::");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }
        return false;
    }

 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome\n");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create User");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Create User
                    System.out.print("Choose a username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Choose a password: ");
                    String newPassword = scanner.nextLine();
                    createUser(newUsername, newPassword);
                    break;

                case 2: // Login
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    if (login(username, password)) {
                        System.out.println("You logged in! Welcome!");
                        //her kan vi kalde en menu function så man bliver tilbudt at søge/vælge film eller serier osv.
                        //inde i den funktion kan vi have endnu en switch.

                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;

                case 3: // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



}


