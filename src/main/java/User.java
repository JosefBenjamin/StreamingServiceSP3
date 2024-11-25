import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class User {
    //Attributes begin here
    private String username;
    private static ArrayList<Media> seen;
    private static ArrayList<Media> later;
    private boolean isAdmin;

    //Constructor
    public User(String username) {
        this.username = username;
        this.isAdmin = false;
        this.later = new ArrayList<>();
        this.seen  = new ArrayList<>();
    } //  Constructor

    // make it so user cannot use "::" in a password or username;

    public boolean  isAdmin(){
        boolean result = false;
        if (this.isAdmin){
            result = true;
        }   // end if statement
        return result;
    }   // end isAdmin()

    public  void addToLater(Media media){
        later.add(media);
    }   // end addToLater()

    public  void removeFromLater(Media media){
        later.remove(media);
    }   // end removeFromLater()

    public static void addToSeen(Media media){
        seen.add(media);
    }   // end addToSeen()

    public  void removeFromSeen(Media media){
        seen.remove(media);
    }   // end removeFromSeen

    //Getter method for Media ArrayList object
    public ArrayList<Media> getSeen(){
        return seen;
    }   // end getSeen()

    public ArrayList<Media> getLater() {
        return later;
    }

@Override
    public String toString(){
        return this.username;
    }


     private static final String USER_DATA = "src/main/java/files/Users.txt";
/*
     public static void createUser(String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("Sorry! Username not available");

        } else {

        try (FileWriter writer = new FileWriter(USER_DATA, true)) {
            writer.write(username + "::" + password + ":: Not Admin" +"\n");                 // Default user is not admin, there is only one admin user that is already made
            System.out.println("User created successfully!");
        } catch (IOException e) {
            System.out.println("Error saving user: \n");
            e.printStackTrace();
            }   // end try-catch-block
        }   // end if-else statement
    }   // end createUser()
*/

    public static boolean isUsernameTaken(String username, String usersPath) {
        File file = new File(usersPath);                                                  // Declares & instantiates a File Object based on the path USER_DATA which is defined in global-scope
        try (Scanner scan = new Scanner(file)) {                                          // We have chosen to put the declaration and instantiation of the Scanner Object inside a try-catch block
                                                                                          // Since the Scanner Object will close by itself

            while (scan.hasNextLine()) {                                                  // while loop condition stays 'true' so long as the file at USER_DATA has a new line
                String line = scan.nextLine();                                            // Declares and instantiates the variable line as the current/next line
                String[] sections = line.split("::");                               // Declares and instantiates an array 'sections'.
                                                                                          // The Array contains 3 indies [0]-username, [1]-password, [2]-permission status
                if (
                        sections.length > 0 && sections[0].equals(username)) {
                    return true;                                                          // When func returns true it means that the username is preoccupied
                }   // if-else statement
            }   // end while loop
        } catch (FileNotFoundException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }   // end try-catch block
        return false;                                                                     // When func returns false it means the username is available
    }   // end isUsernameTaken()



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
                }

                                                                                            // If no matching username-password pair is found, return false.
            }
        }
        return false;
    } // end login()

    public User getCurrentUser(){
         return this;
    }

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
/*
    public static void ikkemain(int ihh) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome\n");

        String str = "src/main/java/files/film.txt";
       // ArrayList<Media> aL = new FileIO().readMediaData(str);

      //  System.out.println(aL.get(2));

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
 */


}



