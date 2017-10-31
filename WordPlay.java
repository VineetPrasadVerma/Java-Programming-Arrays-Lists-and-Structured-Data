
/**
 * Write a description of WordPlay here.
 * 
 * @author VINEET VERMA
 * @version 30 Oct 2017
 */
public class WordPlay {
    public boolean isVowel(char ch){
        boolean test = false;  
        String vowels = "aeiou";
        ch =Character.toLowerCase(ch);
        /*int currIndex = vowels.indexOf(ch);
        if(currIndex != -1){
        
            return true;
        }
        return false;*/
        for(int i=0; i<vowels.length(); i++){
        
            char message = vowels.charAt(i);
            if(ch == message){
                test = true;
                break;
            }
        }
        if(test == true){
            return true;
        }
        else{
           return false;
        }
    }
    
    public void tester(){
    
        boolean result = isVowel('f');
        System.out.println("ANS IS = "+result);
        
        result = isVowel('a');
        System.out.println("ANS IS = "+result);
        
        result = isVowel('F');
        System.out.println("ANS IS = "+result);
        
        result = isVowel('A');
        System.out.println("ANS IS = "+result);
        
    }
    
    public String replaceVowels(String phrases, char ch ){
        StringBuilder phrase = new StringBuilder(phrases);
        for(int i =0; i<phrases.length(); i++){
            char word = phrases.charAt(i);
            boolean result = isVowel(word);
            if(result == true){
                phrase.setCharAt(i,ch);
            }
        }
        return phrase.toString();    
    } 
     
    public void testReplaceVowels(){
    
        String upgradedPhrase = replaceVowels("Hello world" , '*');
        System.out.println(upgradedPhrase);
    }
    
    public String emphasize(String phrases, char ch){
    
         StringBuilder phrase = new StringBuilder(phrases);
         for(int i =0; i<phrase.length(); i++){
            char word = phrase.charAt(i);
            if(word == ch){
            
                if(i%2==0){
                    phrase.setCharAt(i,'*');
                }
                else{
                    phrase.setCharAt(i,'+');
                }
            }
         }
         return phrase.toString();
    }  
    
    public void testEmphasize(){
    
        String result = emphasize("Mary Bella Abracadabra", 'a');
        System.out.println("EMPHASIZED RESULT IS = "+result);
    }

}
