import java.util.ArrayList;

public class Search {

    private String username;
    private String password;
    private ArrayList<Media> movieContent;
    private ArrayList<Media> seriesContent;
    public ArrayList<Media> foundContent;
    final String movies = "src/main/java/files/film.txt";
    final String series = "src/main/java/files/serier.txt";

    public Search(ArrayList<Media> movieContent, ArrayList<Media> seriesContent) {
        foundContent = new ArrayList<>();
        this.movieContent = new FileIO().readMovieData(movies);
        this.seriesContent = new FileIO().readSeriesData(series);
    }   // end Constructor


    public boolean searchMediaName(boolean isMovie) {                                      // If it isn't a movie it must be a series
            foundContent.clear();
            TextUI userInput = new TextUI();
            String mediaNameInput;
            ArrayList<Media> mediaList = (isMovie ? movieContent : seriesContent);
            String mediaType = (isMovie ? "movie(s)" : "series");

        mediaNameInput = userInput.promptText("Search for a "+ mediaType +" name: ");

        // Loop through the media list (either movieContent or seriesContent)
        for (Media media : mediaList) {
            // Perform case-insensitive comparison of movie/series title
            if (media.getTitle().equalsIgnoreCase(mediaNameInput)) {                        // Gets title from media object and then uses .equals with user input, the condition is NOT sensitive
                System.out.println("Found: \n" + media);
                foundContent.add(media);
                return true;  // Movie or series found
            }   // end if-else statement
        }   // end for-each loop

        // If no match is found
        System.out.println("No matching "+ mediaType +" found.");                              // print custom error message
        return false;                                                                       // Movie or series not found
    }   // end searchMediaName()

    public boolean searchMediaGenre(boolean isMovie) {                                     // if isMovie == true, otherwise (if false) it's a series
        foundContent.clear();
        TextUI userInput = new TextUI();                                                   // TextUI is initiated to use its method userInput

        String mediaType = (isMovie ? "movie(s)" : "series");
        String genreNameInput = userInput.promptText("Search for a " + mediaType + " rating: ");
        ArrayList<Media> mediaGenres = new ArrayList<>();

        ArrayList<Media> mediaList = (isMovie ? movieContent : seriesContent);

        // Loop through the media list (either movieContent or seriesContent)
        for (Media media : mediaList) {
            ArrayList<String> genres = media.getGenre();

            for (String genre : genres ) {
                if (genre.equalsIgnoreCase(genreNameInput)) {
                    //System.out.println("Found: " + genre);
                    mediaGenres.add(media);
                } // once true is returned the method is exited
            } // for each loop ending
        }   // end for-each loop

        // If no match is found
        if (mediaGenres.size() != 0) {
            userInput.displayList(mediaGenres, "Found these " + mediaType + " matching your desired genre");
            foundContent = mediaGenres;
            return true;
        } else {
            System.out.println("No matching genre found."); //print custom error message
            return false;  // Movie or series not found
        }   // end if-else statement
    } //end searchGenre() method

    public boolean searchMediaRating(boolean isMovie) {
        TextUI userInput = new TextUI();
        ArrayList<Media> mediaRatings = new ArrayList<>();
        String mediaType = (isMovie ? "movie(s)" : "series");                                                      //if isMovie is true "movie" is chosen, if false "series" will be chosen
        String ratingInput = userInput.promptText("Search for a " + mediaType + " rating: ");
        ArrayList<Media> conte = (isMovie ? movieContent : seriesContent);                                          // we've used ternary statements to show we're able to use them

        try {
            Float rating = Float.parseFloat(ratingInput);
            for (Media media : conte) {
                if (media.getRating() >= rating){
                    mediaRatings.add(media);
                }   // end if statement
            }   // end for-each loop

            userInput.displayList(mediaRatings, "Found these " + mediaType + " ratings");
            return true;

        } catch( NumberFormatException e ) {
            e.getMessage();
            }
            return false;
        } // end searchMediaRating()


    public boolean searchMovieYear(boolean isMovie) {
        TextUI ui = new TextUI();

        if (isMovie){
            ArrayList<Media> movieYear = new ArrayList<>();
            int desiredYear = ui.promptNumeric("Search for a movie release year: ");

            for (Media movie : movieContent){
                if (movie.getReleaseYear() == desiredYear){
                    movieYear.add(movie);
                }   // end if statement
            }   // end for-each loop
            if (movieYear.size() != 0)  {
                ui.displayList(movieYear, "These are the movies for year " + desiredYear);
                return  true;
            }   // end if statement
            System.out.println("No movies found at the year "+ desiredYear);
            return false;
        } else {
           int  userInputInt = ui.promptNumeric("Search for a series release year name: ");
            ArrayList<Media> seriesYear = new ArrayList<>();
            // Loop through the media list (either movieContent or seriesContent)
            for (Media media : seriesContent) {
                for (int i : media.getRunningYears()){
                    if (i == userInputInt){
                        seriesYear.add(media);
                    } // end if statement
                }   // end inner for-each loop
            }   // end outer for-each loop
            if (seriesYear.size() != 0){
                ui.displayList(seriesYear, "These series where running in " + userInputInt);
                return  true;
            }
            // If no match is found
            System.out.println("No matching series found by the year " + userInputInt); //print custom error message
            return false;  // Movie or series not found
        }

    }   // end searchMovieYear()
/*
    public boolean searchSeriesYear() {                                           //if it isn't a movie it must be a series
        int userInput;



    }// end searchMediaYear()
*/
    public boolean searchSeasonAndEpisodes(){return true;}
}   // end Search class