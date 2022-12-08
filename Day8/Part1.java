import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Part1 {
    static int total = 0;
    public static void main(String[] args){
        ArrayList<String[]> inputs = new ArrayList<>();
        readFile(inputs);
        for(int i =1; i < inputs.size()-1; i++){
            for(int j=1; j < inputs.get(i).length-1; j++){
                int val = Integer.parseInt(inputs.get(i)[j]);
                checkVis(i, j, inputs);
                System.out.println(val + ": " + total);
            }
            System.out.println("");
        }
        total+= 2*inputs.size() + 2*inputs.get(0).length -4;
        System.out.println(total);
        
    }
    public static void readFile(ArrayList<String[]> list){
        File file = new File("input.txt");
        try{
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                list.add(reader.nextLine().split(""));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cant find file");
            System.exit(0);
        }
    }
    public static void checkVis(int a, int b,ArrayList<String[]> list){
        if(!checkleft(a,b,list)){
            if(!checkright(a,b,list)){
                if(!checkup(a,b,list)){
                    checkdown(a,b,list);
                }
            }
        }
    }
    public static boolean checkleft(int a, int b,ArrayList<String[]> list){
        for(int i = 0; i < b; i++){
            if(Integer.parseInt(list.get(a)[i])>=Integer.parseInt(list.get(a)[b])){
                return false;
            }
        }
        total++;
        return true;
    }
    public static boolean checkright(int a, int b,ArrayList<String[]> list){
        for(int i = b+1; i < list.get(a).length; i++){
            if(Integer.parseInt(list.get(a)[i])>=Integer.parseInt(list.get(a)[b])){
                return false;
            }
        }
        total++;
        return true;
    }
    public static boolean checkup(int a, int b,ArrayList<String[]> list){
        for(int i = 0; i < a; i++){
            if(Integer.parseInt(list.get(i)[b])>=Integer.parseInt(list.get(a)[b])){
                return false;
            }
        }
        total++;
        return true;
    }
    public static boolean checkdown(int a, int b,ArrayList<String[]> list){
        for(int i = a+1; i <list.size(); i++){
            if(Integer.parseInt(list.get(i)[b])>=Integer.parseInt(list.get(a)[b])){
                return false;
            }
        }
        total++;
        return true;
    }
    
}