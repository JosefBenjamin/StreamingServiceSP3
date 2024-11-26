import java.util.ArrayList;

public class MediaPlayer {
    MediaPlayer(){

        TextUI ui = new TextUI();
        FileIO io = new FileIO();
        Login login = new Login();
        String str = "src/main/java/files/film.txt";
        String str1 = "src/main/java/files/serier.txt";

        String saveAnswer = ui.promptText("Do you have an account Yes or No?");

        Search search = new Search(io.readMovieData(str), io.readSeriesData(str1));

        if(saveAnswer.equalsIgnoreCase("Yes") || saveAnswer.equalsIgnoreCase("y")){
            if (login.loginUser(ui.promptText("Enter username: "), ui.promptText("Enter password: "))){
                String userPrompt = "Type \"y\" if you're looking for a movie\nType \"n\" if you're looking for a series";
                int answer = ui.promptNumeric("What do you wanna do");

                switch (answer){
                    case 1:
                        System.out.println("Search for movies or series titles");
                        //Search for a title
                        search.searchMediaName(ui.promptBinary(userPrompt));
                        break;
                    case 2:
                        System.out.println("Search for release of a movie or running years from a series");
                        search.searchMovieYear(ui.promptBinary(userPrompt));
                        break;
                    case 3:
                        System.out.println("Search for IMDB rating");
                        search.searchMediaRating(ui.promptBinary(userPrompt));
                        break;
                    case 4:
                        System.out.println("Search for genres");
                        search.searchMediaGenre(ui.promptBinary(userPrompt));
                }   // end switch case
            } else {
                // idfc yet
                System.out.println("We didn't find your account in our database");
            }

        } else if (saveAnswer.equalsIgnoreCase("No") || saveAnswer.equalsIgnoreCase("n")){
            login.createUser(ui.promptText("Choose a username"), ui.promptText("Choose a password"));
        }




        //login.createUser(ui.promptText("Please enter a username!"), ui.promptText("Please enter a password"));

        //System.out.println("Working Directory: " + new File("src/main/java/files/film.txt").getAbsolutePath());
        ArrayList<Media> aL = io.readMovieData(str);

        ArrayList<Media> aL2 = io.readSeriesData(str1);

        //search.searchMediaRating(false);

        Media idfc = aL.get(2);
        idfc.playMedia();
        idfc.pauseMedia();



/*
        Scanner scan = new Scanner(System.in);
        System.out.println("Whalecum to Nutflix!\n");
        */
    }
}
