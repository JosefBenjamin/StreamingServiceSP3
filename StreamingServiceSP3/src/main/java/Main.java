import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String USER_DATA = "users.txt";
    String s = "h";
    /*

    public static void createUser(String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("Sorry! Username not available");
            return;
        }

        try (FileWriter writer = new FileWriter(USER_DATA, true)) {
            writer.write(username + ":" + password + "\n");
            System.out.println("User created successfully!");
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }


    public static boolean isUsernameTaken(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length > 0 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }
        return false;
    }



    public static boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome");

        while (true) {
            System.out.println("\nChoose an option:");
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