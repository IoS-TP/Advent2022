import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Part1 {
    public static int total = 0;
    public static void main(String[] args){
        ArrayList<String[]> list = new ArrayList<>();
        readFile(list);
        for (String[] line : list){
            comparer(line[0], line[1]);
        }
        System.out.println(total);

    }
    public static void readFile(ArrayList<String[]> list){
        File file = new File("input.txt");
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                list.add(line.split(","));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cant find file");
            System.exit(0);
        }
    }
    public static void comparer(String one, String two){    
        String[] first = one.split("-");
        String[] second = two.split("-");

        if(Integer.parseInt(first[0]) >= Integer.parseInt(second[0])){
            if(Integer.parseInt(first[1]) <= Integer.parseInt(second[1])){
                total++;
            }
            else if(Integer.parseInt(first[0]) == Integer.parseInt(second[0])){
                if(Integer.parseInt(first[1]) >= Integer.parseInt(second[1])){
                    total++;
                }
            }
        }
        if(Integer.parseInt(first[0]) < Integer.parseInt(second[0])){
            if(Integer.parseInt(first[1]) >= Integer.parseInt(second[1])){
                total++;
            }
        }
    }   
}