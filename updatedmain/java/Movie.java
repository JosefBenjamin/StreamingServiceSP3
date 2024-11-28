import java.util.ArrayList;

public class Movie extends Media {

    Movie(String title, float rating, int releaseYear, ArrayList<String> genre) {
        super(title, rating, releaseYear, genre);
    }   // constructor


    @Override                           // Overrides the toString method
    public String toString() {          // Makes a new toString method so that can return a string instead of memory address
        String result = "\n";
        result += "Title: " + getTitle() + "\n";
        result += "Release Year: " + getReleaseYear() + "\n";
        result += "Genre(s): " + getGenre() + "\n";
        result += "IMDB Rating: " + getRating() + "\n";
        return result;
    }
}

