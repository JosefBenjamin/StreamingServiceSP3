import java.util.ArrayList;

public class MediaPlayer {
    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    Login login = new Login();
    String str = "src/main/java/files/film.txt";
    String str1 = "src/main/java/files/serier.txt";
    ArrayList<Media> aL = io.readMovieData(str);
    ArrayList<Media> aL2 = io.readSeriesData(str1);
    ArrayList<Media> foundContentToUser = new ArrayList<>();


    MediaPlayer(){
        System.out.println("Welcome to Nutflix :)!\n");

        // String saveAnswer = ui.promptText("Do you have an account Yes or No?");
        String choice = ui.promptText("1. Login\n2. Create user\n3. Exit\n");
        switch(choice) {
            case "1":
                if (login.loginUser(ui.promptText("Enter your username: "), ui.promptText("Enter your password: "))){
                    success();
                } else {
                    System.out.println("Failed to login, please try again!");
                    MediaPlayer tryAgain = new MediaPlayer();
                }

                break;


            case "2":
                login.createUser(ui.promptText("Choose a username"), ui.promptText("Choose a password"));
                MediaPlayer beginOver = new MediaPlayer();
                break;

            case "3":
                System.exit(0);
                break;

        }




         //else if (saveAnswer.equalsIgnoreCase("No") || saveAnswer.equalsIgnoreCase("n")){
            //login.createUser(ui.promptText("Choose a username"), ui.promptText("Choose a password"));
//  }


       // Media idfc = aL.get(2);
       // idfc.playMedia();
       //  idfc.pauseMedia();



    }
    public void success(){
        Search search = new Search(io.readMovieData(str), io.readSeriesData(str1));



        String userPrompt = "Type \"m\" if you're looking for a movie\n" +
                "Type \"s\" if you're looking for a series";

        int answer = ui.promptNumeric("How do you wanna search for a media?\nType 1: By title\n" +
                "Type 2: By release year (movie) or running years (series)\n" +
                "Type 3: By IMDB rating\n" +
                "Type 4: By genre\n");

        switch (answer){
            case 1:
                System.out.println("Search for movies or series titles");

                break;
            case 2:
                System.out.println("Search for release of a movie or running years from a series");
                if (search.searchMediaYearBool(ui.promptBinary(userPrompt, "m", "s"))){

                    foundContentToUser = search.searchMediaYearMedia(true, search.getDesiredYear());
                    int userNumericInput = ui.promptNumeric("Please tell me what movie from the list you wanna watch\n");
                    if (userNumericInput < 1 || userNumericInput > foundContentToUser.size()) {
                        System.out.println("Invalid selection. Please choose a number between 1 and " + foundContentToUser.size());
                    } else {
                        Media media = foundContentToUser.get(userNumericInput - 1);
                        media.playMedia();
                    }
                } else {
                    foundContentToUser = search.searchMediaYearMedia(false, search.getDesiredYear());
                        int userNumericInput = ui.promptNumeric("Please tell me what series from the list you wanna watch\n");
                        if (userNumericInput < 1 || userNumericInput > foundContentToUser.size()) {
                            System.out.println("Invalid selection. Please choose a number between 1 and " + foundContentToUser.size());
                        } else {
                            Media media = foundContentToUser.get(userNumericInput - 1);
                            media.playMedia();
                        }


                }
                break;
            case 3:
                System.out.println("Search for IMDB rating");
                search.searchMediaRatingBool(ui.promptBinary(userPrompt, "m", "s"));
                break;
            case 4:
                System.out.println("Search for genres");
                search.searchMediaGenreBool(ui.promptBinary(userPrompt, "m", "s"));
        }   // end switch case
    }
}