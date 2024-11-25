import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileIO {

    FileIO(){

    }

    public static ArrayList<Media> readMovieData(String path) {
        ArrayList<Media> data = new ArrayList();
        Media media;
        File file = new File(path);                                              // Declares a File Object, and instantiates the Object with the path given as argument for the func
        try (Scanner scan = new Scanner(file)) {
            while(scan.hasNextLine()){                                           // This loop runs while the file has another line
                String line = scan.nextLine();
                String[] value = line.split(";");                          // Splits the at the ";" for each category of a media content i.e. title, year, genre, rating
                try {
                    if (value.length == 4){                                      // We hardcoded 4 since there is only 4 values in movies (Title, releaseYear, Genre, Rating)
                        // parsing and trimming values
                        String title = value[0].trim();                          // The first split will always be the title
                        int releaseYear = Integer.parseInt(value[1].trim());     // We're trimming value[1] since there is whitespace at every line.
                                                                                 // We're using parseInt to typecast from string to int
                        String genre = value[2].trim();                          // Trims whitespaces
                        // splitting genres
                        ArrayList<String> genresAL = new ArrayList<>();          // Creating an ArrayList for genres, meeant to be a parameter for the media constructor
                        String[] genreArray = genre.split(",");            // We're splitting the genre string at ","
                        for (String str : genreArray){
                            genresAL.add(str);                                    // Iteration through the array we've just created and adding each index to and the ArrayList we're returning as part of the Media object
                        }   // end for-each loop

                        float rating = Float.parseFloat(                         // We're using parseInt to typecast from string to float
                                value[3].replace(',','.').trim());// We're trimming value[3] since there is at every line there is whitespace.
                                                                                 // We're replacing "," with "." because Oracle is a US based company any there number system is wrong
                        media = new Movie(title, rating, releaseYear, genresAL); // Instantiating the media Object we declared in line 13
                                                                                 // In this case we instance it as a Movie Object.
                        data.add(media);                                         // We add the newly instantiated media Object to the 'data' ArrayList which we return at the end of the func
                                                                                 // Adds the media to our ArrayList which we returns
                    } else {
                        System.out.println("Invalid input!\nGive me a valid input pleeeeeeeease!");
                        throw new IllegalArgumentException();
                    }   // end if-else block
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }   // end catch block
            }   // end while loop
        } catch(FileNotFoundException fnfe){                                       // In case the file isn't found at the given path
            fnfe.printStackTrace();
        }   // end try-catch block
        return data;                                                               // returns the ArrayList we declared in line 12
                                                                                   // & we have added a Media Obejct at every urn of the while loop
    }   // end readMediaData()

    public static ArrayList<Media> readSeriesData(String path){
        ArrayList<Media> data = new ArrayList();
        Media media;
        File file = new File(path);

            try (Scanner scan = new Scanner(file)){
                while(scan.hasNextLine()){
                    String line = scan.nextLine();
                    String[] value = line.split(";");

                    try {
                            HashMap<Integer, Integer > seasonsAndEpisodes = new HashMap<>();   // Declaring a HasMap we'll instantiate once we've split season and episodes from each other
                            // parsing and trimming values
                            String title = value[0].trim();                                    // The first split is always the title
                            String runningYears = value[1].trim();                             // We're trimming value[1] since there is whitespace at every line.
                            String genre = value[2].trim();                                    // We're trimming the whitespaces in genre
                            ArrayList<String> genresAL = new ArrayList<>();                    // Creating an ArrayList for genres
                            String[] genreArray = genre.split(",");                      // we're splitting the genre string at ","
                            // splitting genres
                            for (String str : genreArray){
                                genresAL.add(str);                                             // Iteration through the array we've just created and adding each index to and the ArrayList we're returning as part of the Media object
                            }   // end for-each loop
                            float rating = Float.parseFloat(                                   // We're using parseInt to typecast from string to float
                                    value[3].replace(',','.').trim());         // We're trimming value[3] since there is at every line there is whitespace.
                                                                                                // We're replacing "," with "." because Oracle is a US based company any there number system is wrong
                            String seasonData = value[4];
                            String[] pairs = seasonData.split(",");             // Creates a new array for storing different seasons and their respective episode amounts

                            // For-each loop is used to separate season number from the amount of episodes
                            for(String pair : pairs){
                                String[] parts = pair.split("-");               // String array stores the split between seasons and episodes in that order
                                int season = Integer.parseInt(parts[0].trim());       // seasons is always parts[0]
                                int episode = Integer.parseInt(parts[1].trim());      // episode is always parts[1]
                                seasonsAndEpisodes.put(season, episode);              // Add seasons as key and an episodes as values to seasonsAndEpisodes HashMap
                            }   // end for-each loop
                            media = new Series(title, rating, runningYears, genresAL, seasonsAndEpisodes);
                            data.add(media);
                                                                                      // end if-else block
                    } catch (NumberFormatException nfe){
                        nfe.printStackTrace();
                    }   // end inner try-catch block
                }   // end while loop
            }catch(FileNotFoundException fnfe){                                       // In case the file isn't found at the given path
                fnfe.printStackTrace();
            }  // end out try-catch block

        return data;
    }   // end readSeriesData()

    public void writeData(ArrayList<String> items, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            for (String s: items) {
                writer.write(s+"\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println("something went wrong when writing to file");
        }
    }
}