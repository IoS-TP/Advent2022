import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Part1 {
    public static void main(String[] args){
        ArrayList<String> inputs = new ArrayList<>();
        Directories folders = new Directories("/", "");
        readFile(inputs);
        useInput(inputs, folders);
        /*folders.addDir(new Directories("a"), "/");
        folders.addFile(25, "a");
        folders.addFile(17, "/");
        folders.addDir(new Directories("b"), "/");
        folders.addFile(3, "b");*/
        System.out.println(folders);
        //System.out.println("PRev of e");
        //System.out.println(folders.getPrevLoc(folders, "e"));
        System.out.println(folders.summing());
    }
    public static void readFile(ArrayList<String> list){
        File file = new File("input.txt");
        try{
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                list.add(reader.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cant find file");
            System.exit(0);
        }
    }
    public static void useInput(ArrayList<String> inputs, Directories folders){
        String currentLoc = "/";
        for(String line : inputs){
            String[] parts = line.split(" ");
            if(parts[0].equals("$")){
                if (parts[1].equals("cd")){
                    if(parts[2].equals("..")){
                        currentLoc = folders.getPrevLoc(folders, currentLoc);
                        //System.out.println(currentLoc);
                    }
                    else{
                        currentLoc = parts[2];
                    }
                    /*if(parts[2].equals("d")){
                        System.out.println("hi");
                        System.out.println(folders.getPrevLoc(folders, currentLoc));
                    }*/
                    
                }
            }
            else if (parts[0].equals("dir")){
                folders.addDir(new Directories(parts[1], currentLoc), currentLoc);
            }
            else{
                folders.addFile(Integer.parseInt(parts[0]), currentLoc);
                if(parts[0].equals("4060174")){
                    System.out.println(currentLoc);

                }
            }
        }
    }
}