import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Day1Part2 {
    ArrayList<String> input = new ArrayList<>();
    HashMap<String, Integer> words = new HashMap<>();

    public Day1Part2(){
        words.put("one", 1);
        words.put("two", 2);
        words.put("three", 3);
        words.put("four", 4);
        words.put("five", 5);
        words.put("six", 6);
        words.put("seven", 7);
        words.put("eight", 8);
        words.put("nine", 9);
        //words.put("zero", 0);
        readFile();
        count();
    }
    private void readFile(){
        try{
            File file1 = new File("test.txt");
            Scanner sc1 = new Scanner(file1);
            while(sc1.hasNext()){
                input.add(sc1.next());
            }
        }
        catch (Exception e){
            System.err.println("File not found");
        }
    }

    private void count(){
        int sum = 0;
        for(String row : input){
            char[] characters = row.toCharArray();
            ArrayList<Integer> charInt = new ArrayList<>();
            String charCount = "";
            for(char character : characters){

                //Number as string -> number
                charCount += String.valueOf(character);
                try{
                    charInt.add(Integer.parseInt(String.valueOf(character)));
                }
                catch (Exception ignored){}

                //String numbers -> number
                for(String hashVal : words.keySet()){
                    if(charCount.contains(hashVal)){
                        charInt.add(words.get(hashVal));
                        charCount = charCount.substring(charCount.length()-1);
                    }

                }


            }

            //Get 1st and last value
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