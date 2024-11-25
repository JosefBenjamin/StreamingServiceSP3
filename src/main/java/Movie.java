import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Movie extends Media{

    Movie(String title, float rating, int releaseYear, ArrayList<String> genre) {
        super(title, rating, releaseYear, genre);
    }   // constructor


    @Override                           //Overrides the toString method
    public String toString() {          //Makes a new toString method so that can return a string instead of memory address
        return getReleaseYear() + " - " + getTitle(); //Concatenation the ints into a String and returns a string
    }
/*
    public static ArrayList<Movie> readMovie(String str){
        ArrayList<Movie> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(str)) {
                String line;
                while((line = reader.readLine()) != null) {
                        String[] movieDetails = line.split(";");
                        if (movieDetails.length==4){
                            String title = movieDetails[0];
                            float rating = Float.parseFloat(movieDetails[1]);
                            int releaseYear = Integer.parseInt(movieDetails[2]);
                            //her skal vi lave genren
                            //skal genre listen bare laves i media når de findes for både film og serier?


                            movies.add(new Movie(title,rating, releaseYear, new ArrayList<String>()));
                        }

                }

//filmene skal vel være objekter så jeg tænker vi i denne klasse kan læse filen med film med readfile osv
                    // så kan den instans af klassen movie være objektet der bliver played i media i guess
                    // add more code l8r
                }


 */
}