import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileIO {

    FileIO(){

    }
    /*
    public ArrayList<Media> readMediaData(String path){
        ArrayList<Media> data = new ArrayList<>();
        Media media;
        File file = new File(path);

        try (Scanner scan = new Scanner(file)){
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] value = line.split(";");
                try{
                    if (value.length == 4){
                                                                                 // .trim() is a method of the String class, we use to remove LEADING and TRAILING whitespace aka " "
                        String title = value[0].trim();                          // value[0] is the title which is a string
                        int releaseYear = Integer.parseInt(value[1].trim());     // releaseYear gets turned into a String on lines 20-21. Thus, parseInt to typecast from String to int
                        String genre = value[2].trim();                          // Trims whitespaces

                        // splitting genres
                        ArrayList<String> genresAL = new ArrayList<>();           // Creating an ArrayList to save the splitted genres (meant to be a parameter for the media constructor)
                        String[] genreArray = genre.split(",");             // Each genre is split at "," and then saved into the String Array
                        for (String str : genreArray){                            // for-each loop does: takes a genre adds to the String variable (Str) and then is added to genresAL and the repeated
                            genresAL.add(str);                                    // Iteration through the array we've just created and adding each index to and the ArrayList we're returning as part of the Media object
                        }   // end for-each loop

                        float rating = Float.parseFloat(                           // We're using parseInt to typecast from string to float
                                value[3].replace(',','.').trim());  // We're trimming value[3] since there is at every line there is whitespace.
                                                                                   // We're replacing "," with "." because Oracle is a US based company any there number system is wrong
                        media = new Movie(title, rating, releaseYear, genresAL);   // Instantiating a subclass (Movie) to the media Object made earlier
                        data.add(media);                                           // We add the newly instantiated media Object to the 'data' ArrayList which we return at the end of the method
                                                                                   // Adds the media to our ArrayList which we returns
                    } else if (value.length == 5 || value.length == 6){
                        HashMap<Integer, Integer > seasonsAndEpisodes = new HashMap<>();   // Declaring a HasMap we'll instantiate once we've split season and episodes from each other
                        // parsing and trimming values
                        String title = value[0].trim();                                    // The first split is always the title
                        String runningYears = value[1].trim();                              // We're trimming value[1] since there is whitespace at every line.                            String splitRunningYears = runningYears.split("-");Stri

                        ArrayList<Integer> runningYearsAL = new ArrayList<>();
                        String[] rY = runningYears.split("-");
                        int startingYear = Integer.parseInt(rY[0]);

                        if(rY.length == 1) {
                            while(startingYear <= 2024){
                                runningYearsAL.add(startingYear);
                                startingYear++;
                            }   // end while loop (the loop ends once an ArrayList has been created containing the running years of a series). The last year is 2024

                        } else if (rY.length > 1) {
                            int endingYear = Integer.parseInt(rY[1]);
                            while(startingYear != endingYear+1){
                                runningYearsAL.add(startingYear);
                                startingYear++;
                            }   // end while loop (the loop ends once an ArrayList has been created )
                        }   // end if-else statement

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
                        media = new Series(title, rating, runningYearsAL, genresAL, seasonsAndEpisodes);
                        data.add(media);
                    } else {
                        throw new IllegalArgumentException("You have given an invalid input!\nPlease give me a new input which is valid");
                    }   // end if-else statement

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }   // end inner try-catch block
            }
        }  catch(FileNotFoundException fnfe){                                       // In case the file isn't found at the given path
            fnfe.printStackTrace();
        }   // end outer try-catch block
        return data;
    }   // end readMediaData()
    */

    public ArrayList<Media> readMovieData(String path) {                  // Method can only be used in FileIO class returns an AR with media objects
        ArrayList<Media> data = new ArrayList<>();
        Media media;                                                             // Initializing a variable of object Media called media
        File file = new File(path);                                              // Declares a File Object, and instantiates the Object with the path given as argument for the func
        try (Scanner scan = new Scanner(file)) {                                 // Wraps Scanner class in a try-catch for best practice. Instance of scanner takes instance of file as argument
            while(scan.hasNextLine()){                                           // This loop runs while the file has another line
                String line = scan.nextLine();                                   // Each line is being overwritten and saved in "line" String variable
                String[] value = line.split(";");                          // Splits the at the ";" for each category of a media content i.e. title, year, genre, rating
                try {
                    if (value.length == 4) {                                      // We hardcoded 4 since there is only 4 values in movies (Title, releaseYear, Genre, Rating)
                        // .trim() is a method of the String class, we use to remove LEADING and TRAILING whitespace aka " "
                        String title = value[0].trim();                          // value[0] is the title which is a string
                        int releaseYear = Integer.parseInt(value[1].trim());     // releaseYear gets turned into a String on lines 20-21. Thus, parseInt to typecast from String to int
                        String genre = value[2].trim();                          // Trims whitespaces

                        // splitting genres
                        ArrayList<String> genresAL = new ArrayList<>();          // Creating an ArrayList to save the splitted genres (meant to be a parameter for the media constructor)
                        String[] genreArray = genre.split(",");            // Each genre is split at "," and then saved into the String Array
                        for (String str : genreArray){                            // for-each loop does: takes a genre adds to the String variable (Str) and then is added to genresAL and the repeated
                            genresAL.add(str);                                    // Iteration through the array we've just created and adding each index to and the ArrayList we're returning as part of the Media object
                        }   // end for-each loop

                        float rating = Float.parseFloat(                         // We're using parseInt to typecast from string to float
                                value[3].replace(',','.').trim()); // We're trimming value[3] since there is at every line there is whitespace.
                                                                                 // We're replacing "," with "." because Oracle is a US based company any there number system is wrong
                        media = new Movie(title, rating, releaseYear, genresAL); // Instantiating a subclass (Movie) to the media Object made earlier
                        data.add(media);                                         // We add the newly instantiated media Object to the 'data' ArrayList which we return at the end of the method
                                                                                 // Adds the media to our ArrayList which we returns
                    }  else {
                        System.out.println("Invalid input!\nGive me a valid input pleeeeeeeease!");             // If this is false: if (value.length == 4), the else block runs
                        throw new IllegalArgumentException();
                }    // end catch block
            } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                }// end while loop
        } catch(FileNotFoundException fnfe){                                       // In case the file isn't found at the given path
            fnfe.printStackTrace();
        }   // end try-catch block
        return data;                                                               // returns the ArrayList we declared in line 12
                                                                                   // & we have added a Media Object at every turn of the while loop
    }   // end readMediaData()

    public ArrayList<Media> readSeriesData(String path){
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
                            String runningYears = value[1].trim();                              // We're trimming value[1] since there is whitespace at every line.                            String splitRunningYears = runningYears.split("-");Stri

                            ArrayList<Integer> runningYearsAL = new ArrayList<>();
                            String[] rY = runningYears.split("-");
                            int startingYear = Integer.parseInt(rY[0]);

                            if(rY.length == 1) {
                                while(startingYear <= 2024){
                                    runningYearsAL.add(startingYear);
                                    startingYear++;
                                }   // end while loop

                            } else if (rY.length > 1) {
                                int endingYear = Integer.parseInt(rY[1]);
                                while(startingYear != endingYear+1){
                                    runningYearsAL.add(startingYear);
                                    startingYear++;
                                }   // end while loop
                            }   // end if-else statement

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
                            media = new Series(title, rating, runningYearsAL, genresAL, seasonsAndEpisodes);
                            data.add(media);
                                                                                      // end if-else block
                    } catch (NumberFormatException nfe){
                        nfe.printStackTrace();
                    }   // end inner try-catch block
                }   // end while loop
            }catch(FileNotFoundException fnfe){                                       // In case the file isn't found at the given path
                fnfe.printStackTrace();
                System.out.println("");
            }  // end out try-catch block
        return data;
    }   // end readSeriesData()



    public void writeToSeenList(Media seenItem, String path, User user) {
        // Specify directory and file paths
        String directoryPath = "Users"+ File.separator+user.getusername();                  // Creates a directory for each user
        String filePath = directoryPath + File.separator + "HasSeen.txt";                   // Find out what File.separator does

        // create a directory path
        File directory = new File(directoryPath);                                               // Creates a new File for each users hasSeen list
        if (!directory.exists()){
            if(directory.mkdir()){
                System.out.println("Directory created: " + directoryPath);
                return;
            } else {
                System.out.println("Failed to create directory!");
            }   // end inner if-else statement
        } else {
            System.out.println("Directory aldread exists: " + directory);
        }   // end outer if-else statement

        // create a file inside the directory
        File file = new File(filePath);
        try {
            if (file.createNewFile()){
                System.out.println("File created: " + filePath);
            }   else {
                System.out.println("File already exists: " + filePath);
            }   // end if-else statement

        } catch (FileAlreadyExistsException faee){
            faee.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }   // end try-catch block

        try (FileWriter writer = new FileWriter(file)){
            writer.write(seenItem.toString() +"\n*****************************\n\n");
        } catch (FileAlreadyExistsException faee){
            faee.printStackTrace();
        } catch (IOException ioe){
            System.out.println("something went wrong when writing to file" + ioe.getMessage());
        }   // end try-catch block

        if (file.exists()){
            FileWriter writer = null;
            try {
                writer = new FileWriter(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }   // end try-catch block
            try {
                writer.write(seenItem.toString() +"\n*****************************\n\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }   // end try-catch block
        }   // end if statement
    }   // end writeToSeen()

    public void writeData(ArrayList<String> items, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            for (String s: items) {
                writer.write(s+"\n");
            }   // end for-each loop
            writer.close();
        }catch (IOException e){
            System.out.println("something went wrong when writing to file");
        }   // end try-catch block
    }   // end writeData
}   // end FileIO

