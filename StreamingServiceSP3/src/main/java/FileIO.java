import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    public static ArrayList<String> readData(String path) {
        ArrayList<String> data = new ArrayList();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);


            while(scan.hasNextLine()){
                String line = scan.nextLine(); // "tess, 40000"
                data.add(line);
            }

        }catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
        return data;
    }


    public static ArrayList<Media> readMovieData(String path, String type) {
        ArrayList<Media> data = new ArrayList();
        File file = new File(path); // finds the file at a given path

        try (Scanner scan = new Scanner(file)) {
            while(scan.hasNextLine()){                                      // This loop runs while the file has another line
                String line = scan.nextLine();
                String[] value = line.split(";");

                try {
                    if (value.length != 4){                                 // we hardcoded 4 since there is only 4 values in movies (Title, releaseYear, Genre, Rating)
                        throw new IllegalArgumentException(value[1].trim());
                    }

                    // parsing and trimming values
                    String title = value[0].trim();                          // the first split will always be the title
                    int releaseYear = Integer.parseInt(value[1].trim());     // we're trimming value[1] since there is at every line there is whitespace.
                    // we're using parseInt to typecast from string to int
                    String genre = value[2].trim();
                    float rating = Float.parseFloat(value[3].trim());        // we're trimming value[3] since there is at every line there is whitespace.
                    // we're using parseInt to typecast from string to float

                    // splitting genres
                    ArrayList<String> genresAL = new ArrayList<>();
                    String[] genreArray = genre.split(",");           // we're splitting the genre string at ","
                    for (String str : genreArray){
                        genresAL.add(str);                                  // iteration through the array we've just created and adding each index to and the ArrayList we're returning as part of the Media object
                    }

                    Media media;

                    if (type.equals("movie")){
                        media = new Movie(title, rating, releaseYear, genresAL);  // Creates a new instance of the movie object
                    } else{
                        String season = Arrays.toString(value[4].split("-"));
                        media = new Series();
                    }

                    // Creating media instance
                    data.add(media);                                        // Adds the media to our ArrayList which we returns

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
            }

        }
        catch(FileNotFoundException fnfe){

        }
        return data;
    }

    public static void saveData(List<String> items, String path, String header) {

        try {
            FileWriter writer = new FileWriter(path);
            writer.write(header+"\n"); //Giv csv filen en header
            for (String s: items) {
                writer.write(s+"\n"); //"Tess, 40000";
            }
            writer.close();
        }catch (IOException e){
            System.out.println("something went wrong when writing to file");
        }
    }
}
