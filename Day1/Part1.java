import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Part1 {
    public static void main(String[] args) {
        ArrayList<Integer> calories = new ArrayList<>(100);
        readFile("input.txt", calories);
        System.out.println(calories);
    }
    public static void readFile(String filename, ArrayList<Integer> list){
        File file = new File(filename);
        try{
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String num = reader.nextLine();
                if (num.equals("")){
                    list.add(-1);
                }
                else{
                    list.add(Integer.parseInt(num));
                }

            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
    }
}