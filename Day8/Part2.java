import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Part2 {
    static int total = 0;
    public static void main(String[] args){
        ArrayList<String[]> inputs = new ArrayList<>();
        readFile(inputs);
        int maxans = 0;
        for(int i =0; i < inputs.size(); i++){
            for(int j=0; j < inputs.get(i).length; j++){
                int val = Integer.parseInt(inputs.get(i)[j]);
                int a = checkVis(i, j, inputs);
                if (a>maxans){
                    maxans=a;
                }
                System.out.println(val + ": " + maxans);
            }
            System.out.println("");
        }

        
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
    public static int checkVis(int a, int b,ArrayList<String[]> list){
        int ans = checkleft(a,b,list) * checkright(a,b,list) * checkup(a,b,list) * checkdown(a,b,list);
        return ans;
    }
    public static int checkleft(int a, int b,ArrayList<String[]> list){
        int ans = 0;
        for(int i = b-1; i >=0; i--){
            ans++;
            if(Integer.parseInt(list.get(a)[i])>=Integer.parseInt(list.get(a)[b])){
                return ans;
            }
        }
        return ans;
    }
    public static int checkright(int a, int b,ArrayList<String[]> list){
        int ans = 0;
        for(int i = b+1; i < list.get(a).length; i++){
            ans++;
            if(Integer.parseInt(list.get(a)[i])>=Integer.parseInt(list.get(a)[b])){
                return ans;
            }
        }
        return ans;
    }
    public static int checkup(int a, int b,ArrayList<String[]> list){
        int ans = 0;
        for(int i = a-1; i >=0; i--){
            ans++;
            if(Integer.parseInt(list.get(i)[b])>=Integer.parseInt(list.get(a)[b])){
                return ans;
            }
        }
        return ans;
    }
    public static int checkdown(int a, int b,ArrayList<String[]> list){
        int ans = 0;
        for(int i = a+1; i < list.size(); i++){
            ans++;
            if(Integer.parseInt(list.get(i)[b])>=Integer.parseInt(list.get(a)[b])){
                return ans;
            }
        }
        return ans;
    }
    
}