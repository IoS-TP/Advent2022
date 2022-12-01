import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Part2 {
    public static void main(String[] args) {
        ArrayList<Integer> calories = new ArrayList<>(100);
        readFile("input.txt", calories);
        System.out.println(mostCalories(calories));
    }
    public static void readFile(String filename, ArrayList<Integer> list){
        File file = new File(filename);
        try{
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                String num = reader.nextLine();
                if (num.equals("")){
                    list.add(-1);
                }
                else{
                    list.add(Integer.parseInt(num));
                }

            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
    }
    public static int mostCalories(ArrayList<Integer> list){
        int sum = 0;
        int maxSum = 0;
        int maxSum2 = 0;
        int maxSum3 = 0;
        for(int num : list){
            if(num == -1){
                if (sum > maxSum){
                    maxSum3 = maxSum2;
                    maxSum2 = maxSum;
                    maxSum = sum;
                }
                else if(sum > maxSum2){
                    maxSum3 = maxSum2;
                    maxSum2 = sum;
                }
                else if(sum > maxSum3){
                    maxSum3 = sum;
                }
                sum = 0;
            }
            else{
                sum += num;
            }
        }
        return maxSum+maxSum2+maxSum3;
    }
}