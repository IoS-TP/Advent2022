import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Part2 {
    public static int total = 0;
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        readFile(list);
        for(int i = 0; i < list.size(); i+=3){
            packWorker(list.get(i), list.get(i+1), list.get(i+2));
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
    public static void packWorker(String word, String word2, String word3){
        for(int i = 0; i < word.length(); i++){
            if (word2.contains(""+ word.charAt(i))){
                if(word3.contains(""+word.charAt(i))){
                    numConverter(word.charAt(i));
                    break;
                }
                
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