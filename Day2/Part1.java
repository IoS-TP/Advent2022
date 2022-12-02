import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Part1 {
    static int count = 0;
    public static void main(String[] args){
        ArrayList<String> inputs = new ArrayList<>(2500);
        readInfo("input.txt", inputs);
        for (String line : inputs){
            addScore(line);
        }
    }
    public static void readInfo(String filename, ArrayList<String> list){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNextLine()){
                list.add(read.nextLine());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Can't find file");
            System.exit(0);
        }
    }
    public static void addScore(String line){
        String a = "" + line.charAt(0);
        String b = "" + line.charAt(2);
        if (b.equals("X")){
            count++;
            if(a.equals("X")){
                count += 3;
            }
            else if (a.equals("Z")){
                count +=6;
            }
        }
        else if (b.equals("Y")){
            count+=2;
            if(a.equals("X")){
                count += 6;
            }
            else if (a.equals("Y")){
                count +=3;
            }
        }
        else{
            count +=3;
            if(a.equals("Y")){
                count += 6;
            }
            else if (a.equals("Z")){
                count +=3;
            }
        }
    }
}