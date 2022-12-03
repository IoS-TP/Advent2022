import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Part1 {
    public static int total = 0;
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        readFile(list);
        for(String pack : list){
            packWorker(pack);
        }
        System.out.println(total);
    }
    public static void readFile(ArrayList<String> list){
        File file = new File("input.txt");
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNext()){
                list.add(reader.next());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cant find file");
            System.exit(0);
        }
    }
    public static void packWorker(String word){
        String half1 = word.substring(0, word.length()/2);
        String half2 = word.substring(word.length()/2, word.length());
        for(int i = 0; i < half1.length(); i++){
            if (half2.contains(""+ half1.charAt(i))){
                numConverter(half1.charAt(i));
                break;
            }
        }
    }
    public static void numConverter(char letter){
        if(Character.isUpperCase(letter)){
            total += 26;
            int val = Character.toLowerCase(letter);
            total += val-96;
        }
        else{
            int val = Character.toLowerCase(letter);
            total += val-96;
        }
        System.out.println(letter);
    }
}