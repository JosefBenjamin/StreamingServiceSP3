import java.util.ArrayList;
import java.util.HashMap;

public class Series extends Media{


    public Series(String title, float rating, String runningYears, ArrayList<String> genre, HashMap<Integer,Integer> seasonAndEpisodes){
        super(title, rating, runningYears, genre, seasonAndEpisodes);
    } //End of constructor

    public ArrayList<Movie> loadSeries(String str) {
        playMedia();
        return null;
    }



}

