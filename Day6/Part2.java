import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
public class Part2 {
    public static void main(String[] args){
        String word = readFile();
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
        String[] chars = new String[14];
        for(int i = 0; i < 13; i++){
            chars[i]= ""+word.charAt(i);
        }
        for(int i = 13; i< word.length(); i++){
            chars[13] = "" + word.charAt(i);
            if(containsDifferents(chars)){
                System.out.println(i+1);
                return "Found";
            }
            System.out.println(java.util.Arrays.toString(chars));
            for (int j = 0; j < 13; j++){
                chars[j]= chars[j+1];
            }
        }
        return "none";
    }
    public static boolean containsDifferents(String[] words){
        Set<String> chars = new HashSet<>();
        for(String word : words){
            if(!chars.add(word)){
                return false;
            }
        }
        return true;
    }
}