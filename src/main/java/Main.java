import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String str = "src/main/java/files/film.txt";
        System.out.println("Working Directory: " + new File("src/main/java/files/film.txt").getAbsolutePath());

        ArrayList<Media> aL = new FileIO().readMediaData(str);
        System.out.println(aL.get(2));

    }
}