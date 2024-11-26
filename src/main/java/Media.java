import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Media{
    protected String title;
    protected float rating;
    protected int releaseYear;
    protected ArrayList<Integer> runningYears;
    protected ArrayList<String> genre = new ArrayList<>();
    protected boolean isPlaying;
    protected HashMap<Integer, Integer> seasonsAndEpisodes = new HashMap<>();
    protected ArrayList<Media> hasSeen;
    protected ArrayList<Media> saved;


    public Media(String title,
                 float rating,
                 int releaseYear,
                 ArrayList<String> genre) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.isPlaying = false;
        this.hasSeen = new ArrayList<>();
        this.saved = new ArrayList<>();
    }   // Constructor for movies

    public Media(String title,
                 float rating,
                 ArrayList<Integer> runningYears,
                 ArrayList<String> genre,
                 HashMap<Integer,Integer> seasonsAndEpisodes) {
        this.title = title;
        this.rating = rating;
        this.runningYears = runningYears;
        this.seasonsAndEpisodes = seasonsAndEpisodes;
        this.genre = genre;
        this.isPlaying = false;
        this.hasSeen = new ArrayList<>();
        this.saved = new ArrayList<>();
    }   // Constructor for series



    public void addGenre(String genre) {
        this.genre.add(genre.trim());
    }   // addGenre()

    public void removeGenre(String genre) {
        this.genre.remove(genre);
    }   // removeGenre()

    public void playMedia(){
        isPlaying = true;
        System.out.println(getTitle() + " is currently playing");

        addToSeen(this);
        // Add more code l8r
        // prints in console "[movie/series name] is currently playing"
    }   // end playMedia()

    public void addToSeen(Media media){
        hasSeen.add(media);
    }   // en addToSeen()

    public void pauseMedia(){
        this.isPlaying = false;
        System.out.println(getTitle() + " has stopped playing");
    }   // end pauseMedia()

    public String getTitle() {
        return this.title;
    }   // end getTitle()

    public float getRating() {
        return this.rating;
    }   // end getRating()

    public int getReleaseYear() {
        int result = 0;
        if (this instanceof Movie){
            result = releaseYear;
        }   // end if-else statement
        return result;
    }   // end getReleaseYear()

    public ArrayList<String> getGenre() {
        return this.genre;
    }   // end getGenre()

    public ArrayList<Integer> getRunningYears() {
        ArrayList<Integer> result = null;
       if (this instanceof Series){
         result = runningYears;
       }    // end if statement
        return result;
    }   // end getRunningYears()

    public HashMap<Integer, Integer> getSeasonAndEpisodes() {
        HashMap<Integer, Integer> result = new HashMap<>();
        if (this instanceof Series) {
            result = seasonsAndEpisodes;
        }   else {
            result = null;
        }   // end if-else statement
        return result;
    }   // end getSeasonAndEpisodes()
}   // end Media