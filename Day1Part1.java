import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Day1Part1 {
    ArrayList<String> input = new ArrayList<String>();
    public void readFile(){
        try{
            File file1 = new File("input.txt");
            Scanner sc1 = new Scanner(file1);
            while(sc1.hasNext()){
                input.add(sc1.next());
            }
        }
        catch (Exception e){
            System.err.println("File not found");
        }
    }

    public void count(){
        int sum = 0;
        for(String temp : input){
            char[] characters = temp.toCharArray();
            ArrayList<Integer> charInt = new ArrayList<Integer>();
            for(char character : characters){
                try{
                    charInt.add(Integer.parseInt(String.valueOf(character)));
                }
                catch (Exception e){}
            }

            String value = "";
            value += String.valueOf(charInt.get(0));
            if(charInt.size() == 1){
                value += String.valueOf(charInt.get(0));
            }
            else{
                value += String.valueOf(charInt.get(charInt.size()-1));
            }

            sum += Integer.parseInt(value);
        }
        System.out.println(sum);
    }
}