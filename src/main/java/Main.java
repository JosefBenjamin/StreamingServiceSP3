import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String str = "src/main/java/files/film.txt";
        //System.out.println("Working Directory: " + new File("src/main/java/files/film.txt").getAbsolutePath());

        TextUI ui = new TextUI();
        FileIO io = new FileIO();
        ArrayList<Media> aL = io.readMovieData(str);
        String str1 = "src/main/java/files/serier.txt";
        ArrayList<Media> aL2 = io.readSeriesData(str1);
        //System.out.println(neww.get(2));
        //ArrayList<Media> neww = io.readMediaData("src/main/java/files/serier.txt");

        //System.out.println(aL.get(2));
        //System.out.println(aL2.get(2));
       // System.out.println(aL.get(2));
        //System.out.println(aL);
        ArrayList<String> gg = new ArrayList<>();
        gg.add("Hentai");
        Movie mulan = new Movie("Mulan",10.0f,1998,gg);

        //User user = new User("username", "pass");
        Login login = new Login();
        login.createUser("JuiceControlTheWeather", "SuddMienPic");
        System.out.println(login);

        Scanner scan = new Scanner(System.in);
        System.out.println("Whalecum to Nutflix!\n");
        ui.displayList(aL2,"Juice control the weather\n");


    }
}