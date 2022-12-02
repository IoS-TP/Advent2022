import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Part2 {
    static int count = 0;
    public static void main(String[] args){
        ArrayList<String> inputs = new ArrayList<>(2500);
        readInfo("input.txt", inputs);
        for (String line : inputs){
            String a = "" + line.charAt(0);
            String b = "" + line.charAt(2);
            addScore(a,b);
        }
        System.out.println(count);
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
    public static void addScore(String a, String b){
        if (b.equals("X")){
            if(a.equals("A")){
                count += 3;
            }
            else if (a.equals("C")){
                count +=2;
            }
            else{
                count +=1;
            }
        }
        else if (b.equals("Y")){
            count+=3;
            if(a.equals("A")){
                count += 1;
            }
            else if (a.equals("B")){
                count +=2;
            }
            else{
                count+=3;
            }
        }
        else{
            count +=6;
            if(a.equals("B")){
                count += 3;
            }
            else if (a.equals("C")){
                count +=1;
            }
            else{
                count+=2;
            }
        }
    }
}