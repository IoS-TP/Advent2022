import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Part1 {
    public static void main(String[] args){
        String word = readFile();
        //System.out.println(word);
        System.out.println(findBreak(word));
        
        
    }
    public static String readFile(){
        File file = new File("input.txt");
        try{
            Scanner reader = new Scanner(file);
            return reader.nextLine();
        }
        catch (FileNotFoundException e){
            System.out.println("Cant find file");
            System.exit(0);
        }
        return "";
    }
    public static String findBreak(String word){
        String[] chars = {""+word.charAt(0),""+word.charAt(1),""+word.charAt(2)};
        for(int i = 3; i< word.length(); i++){
            String ans = "" + word.charAt(i);
            if(!ans.equals(chars[0])&&!ans.equals(chars[1])&&!ans.equals(chars[2])){
                if(!chars[0].equals(chars[1])&&!chars[0].equals(chars[2])){
                    if(!chars[1].equals(chars[2])){
                        System.out.println(i);
                        return chars[0]+chars[1]+chars[2]+ans;
                    }
                }
                
            }
            chars[0] = chars[1];
            chars[1] = chars[2];
            chars[2] = ans;
        }
        return "none";
    }
}