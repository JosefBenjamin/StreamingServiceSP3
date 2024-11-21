import java.util.ArrayList;

public abstract class Media {
    private String title;
    private float rating;
    private int releaseYear;
    private ArrayList<String> genre = new ArrayList<>();
    boolean isPlaying;

    Media(String title, float rating, int releaseYear, ArrayList<String> genre) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }   // constructor

    public void addGenre(String genre) {
        this.genre.add(genre.trim());
    }   // addGenre()

    public void removeGenre(String genre) {
        this.genre.remove(genre.trim());
    }   // removeGenre()

    public void playMedia(){
        isPlaying = true;
        // Add more code l8r
    }   // playMedia()

    public void pauseMedia(){
        isPlaying = false;
    }   // pauseMedia()
/*
    public String getTitle() {
        return this.title;
    }   // getTitle()

    public float getRating() {
        return this.rating;
    }   // getRating()

    public int getReleaseYear() {
        return this.releaseYear;
    }   // getReleaseYear()

    public ArrayList<String> getGenre() {
        return this.genre;
    }   // getGenre()
    */

}