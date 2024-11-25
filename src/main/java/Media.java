import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Media extends Search{
    protected String title;
    protected float rating;
    protected int releaseYear;
    protected String runningYears;
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
        hasSeen = new ArrayList<>();
        saved = new ArrayList<>();
    }   // Constructor for movies

    public Media(String title,
                 float rating,
                 String runningYears,
                 ArrayList<String> genre,
                 HashMap<Integer,Integer> seasonsAndEpisodes) {

        this.title = title;
        this.rating = rating;
        this.runningYears = runningYears;
        this.seasonsAndEpisodes = seasonsAndEpisodes;
        this.genre = genre;
        this.isPlaying = false;
        hasSeen = new ArrayList<>();
        saved = new ArrayList<>();
    }   // Constructor for series

    public void addToHasSeen(Media media) {
        this.hasSeen.add(media);
    }   // addToHasSeen()

    public ArrayList<Media> getHasSeen(){
        return this.hasSeen;
    }   // getHasSeen()

    public void saved(Media media) {
        this.saved.add(media);
    }   // addSaved()

    public ArrayList<Media> getSaved(){
        return this.saved;
    }   // getSaved()

    public void addGenre(String genre) {
        this.genre.add(genre.trim());
    }   // addGenre()

    public void removeGenre(String genre) {
        this.genre.remove(genre);
    }   // removeGenre()

    public void playMedia(){
        this.isPlaying = true;
        System.out.println(getTitle() + " is currently playing");
        // Add more code l8r
        // prints in console "[movie/series name] is currently playing"
    }   // end playMedia()

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
        int result;
        if (this instanceof Movie){
            result = releaseYear;
        } else {
            result = Integer.parseInt(null);
        }   // end if-else statement
        return result;
    }   // end getReleaseYear()

    public ArrayList<String> getGenre() {
        return this.genre;
    }   // end getGenre()

    public String getRunningYears() {
        return this.runningYears;
    }   // end getRunningYears()

    public HashMap<Integer, Integer> getSeasonAndEpisodes(){
        HashMap<Integer, Integer> result = new HashMap<>();
        if (this instanceof Series){
            result = seasonsAndEpisodes;
        }   else {
            result = null;
        }   // end if-else statement
        return result;
    }   // end getSeasonAndEpisodes

}