
/**
 * Write a description of CountingCommonWords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CountingCommonWords {
    public void countShakespeare(){
        String[] plays = {"caesar.txt","errors.txt","hamlet.txt","likeit.txt","macbeth.txt","romeo.txt"};
        String[] common = getCommon();
        int[] counts = new int[common.length];
        for(int i=0; i<plays.length; i++){
            FileResource resource = new FileResource(plays[i]);
            countWords(resource,common,counts);
            System.out.println("done with"+plays[i]);
        }
        for(int k=0; k<common.length; k++){
        System.out.println(common[k]+" = "+counts[k]);
        }
        
    
    }
    
    public String[] getCommon(){
        FileResource resource = new FileResource("common.txt");
        int index = 0;
        String[] common = new String[20];
        for(String words : resource.words()){
            common[index] = words;
            index +=1;
        }
        return common;
    }
    
    public void countWords(FileResource resource,String[] common,int[] counts){
        for(String word : resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if(index!=-1){
                counts[index] +=1;
            }
        }
    
    }
    
    public int indexOf(String[] list, String word){
        for(int i=0; i<list.length; i++){
            if(word.equals(list[i])){
                return i;
            }
        }
        return -1;
    }

}
