import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    Scanner scan = new Scanner(System.in);

    public ArrayList<String> promptChoice(ArrayList<String> options, int limit, String msg) {               //
        ArrayList<String> saveUserChoices = new ArrayList<String>();                       //Temporarily saves users choices as long as program is running
        int count = 1;
        while (saveUserChoices.size() < limit) {                                           //
            String choice = promptText(count + ":");
            saveUserChoices.add(choice);
            count++;
        }
        return saveUserChoices;
    }

    public void displayList(ArrayList<Media> options, String msg) {
        System.out.println("*******");
        System.out.println(msg);
        System.out.println("*******");

        int i = 1;
        for (Media mediaContent : options) {
            System.out.println(i + ": " + mediaContent.toString());
            System.out.println("*******");
            i++;
        }   // for-loop
    }   // end displayList

    public boolean promptBinary(String msg, String choiceTrue, String choiceFalse){
        String input = promptText(msg);
        if(input.equalsIgnoreCase(choiceTrue)){
            return true;
        }
        else if(input.equalsIgnoreCase(choiceFalse)){
            return false;
        }
        return promptBinary(msg, choiceTrue, choiceFalse);
    }

    public String promptText(String msg) {                                  // promptText method allows the user to make a String text input
        System.out.println(msg);                                            // msg parameter displays messages to user
        String input = scan.nextLine();
        return input;
    } // end promptText()

    public int promptNumeric(String msg) {
        System.out.println(msg);                                            // promptNumeric method allows the user to make a String text input
        String input = scan.nextLine();                                     // Give brugere et sted at placere sit svar og vente på svaret
        int number = Integer.parseInt(input);                               // Konvertere svaret til et tal
        return number;
    }   // end promptNumeric()
}

