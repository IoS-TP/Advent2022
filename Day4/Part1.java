import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Part1 {
    public static void main(String[] args){

    }
    public static void readFile(ArrayList<String> list){
        File file = new File("input.txt");
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNext()){
                String line = (reader.next());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cant find file");
            System.exit(0);
        }
    }
}