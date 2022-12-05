import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
public class Part1 {
    public static void main(String[] args){
        ArrayList<String[]> list = new ArrayList<>(600);
        Stack[] stacks = new Stack[9];
        readFile(list);
        createStacks(stacks);
        moveBoxes(stacks, list);
        for(int i =0; i< 9; i++){
            System.out.print("Stack "+i+": ");
            System.out.println(stacks[i]);
        }
        
        
    }
    public static void readFile(ArrayList<String[]> list){
        File file = new File("input.txt");
        try{
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                String[] parts = reader.nextLine().split(" ");
                list.add(parts);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cant find file");
            System.exit(0);
        }
    }
    public static void createStacks(Stack[] stacks){
        stacks[0] = new Stack<String>();
        stacks[0].push("F");
        stacks[0].push("D");
        stacks[0].push("B");
        stacks[0].push("Z");
        stacks[0].push("T");
        stacks[0].push("J");
        stacks[0].push("R");
        stacks[0].push("N");
        stacks[1] = new Stack<String>();
        stacks[1].push("R");
        stacks[1].push("S");
        stacks[1].push("N");
        stacks[1].push("J");
        stacks[1].push("H");
        stacks[2] = new Stack<String>();
        stacks[2].push("C");
        stacks[2].push("R");
        stacks[2].push("N");
        stacks[2].push("J");
        stacks[2].push("G");
        stacks[2].push("Z");
        stacks[2].push("F");
        stacks[2].push("Q");
        stacks[3] = new Stack<String>();
        stacks[3].push("F");
        stacks[3].push("V");
        stacks[3].push("N");
        stacks[3].push("G");
        stacks[3].push("R");
        stacks[3].push("T");
        stacks[3].push("Q");
        stacks[4] = new Stack<String>();
        stacks[4].push("L");
        stacks[4].push("T");
        stacks[4].push("Q");
        stacks[4].push("F");
        stacks[5] = new Stack<String>();
        stacks[5].push("Q");
        stacks[5].push("C");
        stacks[5].push("W");
        stacks[5].push("Z");
        stacks[5].push("B");
        stacks[5].push("R");
        stacks[5].push("G");
        stacks[5].push("N");
        stacks[6] = new Stack<String>();
        stacks[6].push("F");
        stacks[6].push("C");
        stacks[6].push("L");
        stacks[6].push("S");
        stacks[6].push("N");
        stacks[6].push("H");
        stacks[6].push("M");
        stacks[7] = new Stack<String>();
        stacks[7].push("D");
        stacks[7].push("N");
        stacks[7].push("Q");
        stacks[7].push("M");
        stacks[7].push("T");
        stacks[7].push("J");
        stacks[8] = new Stack<String>();
        stacks[8].push("P");
        stacks[8].push("G");
        stacks[8].push("S");
    }
    public static void moveBoxes(Stack[] stacks, ArrayList<String[]> list){
        for (String[] line : list){
            int amt = Integer.parseInt(line[1]);
            int from = Integer.parseInt(line[3])-1;
            int to = Integer.parseInt(line[5])-1;
            for(int i = 0 ; i < amt; i++){
                stacks[to].push(stacks[from].pop());
            }
        }
    }
}