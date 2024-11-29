import java.util.ArrayList;
import java.util.HashMap;

public class Series extends Media{


    public Series(String title, float rating, ArrayList<Integer> runningYears, ArrayList<String> genre, HashMap<Integer,Integer> seasonAndEpisodes){
        super(title, rating, runningYears, genre, seasonAndEpisodes);
    } //End of constructor

    public ArrayList<Movie> loadSeries(String str) {
        playMedia();
        return null;
    }

    @Override
    public String toString(){
        String result = "\n";
        result += "Title: " + getTitle()+"\n";
        result += "Running Years: " + getRunningYears()+"\n";
        result += "Genre(s): " + getGenre() +"\n";
        result += "IMDB Rating: " + getRating()+"\n";
        return result;
    }   // end toString()




}   // end Series

