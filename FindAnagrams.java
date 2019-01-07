// program to print group anagrams 
// together
import java.util.*; 
  
public class FindAnagrams { 
  
    private static void printAnagrams(String arr[]) 
    { 
        HashMap<String, List<String> > map = new HashMap<>(); 
  
        // loop over all words 
        for (int i = 0; i < arr.length; i++) { 
  
            // convert to char array. 
            String word = arr[i]; 
            char[] letters = word.toCharArray(); 
            //sort the char array
            Arrays.sort(letters); 
            //reconvert to string
            String newWord = new String(letters); 
  
             
            if (map.containsKey(newWord)) { 
  
                // Here, we already have 
                // the word
                List<String> words = map.get(newWord); 
                words.add(word); 
                map.put(newWord, words); 
            } 
            else { 
  
                // first time we are 
                // adding the word 
                List<String> words = new ArrayList<>(); 
                words.add(word); 
                map.put(newWord, words); 
            } 
        } 
  
        // print all the values where size is > 1 
        // If we want to print non-anagrams, 
        // just print the values having size = 1 
        for (String i : map.keySet()){ 
            List<String> values = map.get(i); 
            if (values.size() > 1) { 
                System.out.println(values); 
            } 

        } 
    } 
  
    public static void main(String[] args) 
    { 
  
        // word list
        String arr[] = {"vase","bat","gods","latte","name","apres","spit","joke","ham","dog","act","tale","parse","pits","asper","tab","table","mane","late","god","cat",
"table","save","spare"};
        printAnagrams(arr); 
    } 
} 