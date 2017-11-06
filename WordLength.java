
/**
 * Write a description of WordLength here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLength {
    public void countWordLength(FileResource resource, int[] counts){
        for(String word : resource.words()){
            char firstLetter = word.charAt(0);
            int length = word.length();
            char lastLetter = word.charAt(length-1);
            if(!Character.isLetter(firstLetter)){
                length = length-1;
            }
            if(!Character.isLetter(lastLetter)){
                length = length-1;
            }
            if(length >= counts.length){
                counts[30] +=1;
            }
            counts[length] += 1;
        }
        for(int i=0; i<counts.length; i++){
            System.out.println("word of length "+i+" is "+counts[i]);
        }
    }
    
    public void testCountWordLength(){
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLength(resource,counts);
    }

}
