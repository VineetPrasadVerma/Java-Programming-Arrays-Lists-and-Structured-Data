
/**
 * Write a description of CaesarCipher here.
 * 
 * @author VINEET VERMA
 * @version 30 Oct 2017
 */
import edu.duke.*;
public class CaesarCipher {
    
    public String encrypt(String input, int key){
    
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet= alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++){
            
            char currentChar= encrypted.charAt(i);
            char currChar=Character.toUpperCase(currentChar);
            int idx= alphabet.indexOf(currChar);
            if(idx!= -1){
                char newChar= shiftedAlphabet.charAt(idx);
                if(Character.isUpperCase(currentChar)==true){
                    encrypted.setCharAt(i,newChar);
                }
                else{
                    char smallChar = Character.toLowerCase(newChar);
                    encrypted.setCharAt(i,smallChar);
                }
            }
        }
            
        return encrypted.toString();
    }
    
    public void testEncrypt(){
        int key = 23;
        String encrypted = encrypt("First Legion",key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted,26-key);
        System.out.println(decrypted);
    
    }
    
    public void testCaesar(){
        int key = 23; 
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);  
    }
    
    public String encryptTwoKeys(String input, int key1,int key2 ){
    
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1= alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet2= alphabet.substring(key2)+alphabet.substring(0,key2);
        for(int i=0;i<encrypted.length();i++){
            if(i%2==0){
                char currentChar= encrypted.charAt(i);
                char currChar=Character.toUpperCase(currentChar);
                int idx= alphabet.indexOf(currChar);
                if(idx!= -1){
                    char newChar= shiftedAlphabet1.charAt(idx);
                    if(Character.isUpperCase(currentChar)==true){
                        encrypted.setCharAt(i,newChar);
                    }
                    else{
                        char smallChar = Character.toLowerCase(newChar);
                        encrypted.setCharAt(i,smallChar);
                    }
                }
            }
            else{
                char currentChar= encrypted.charAt(i);
                char currChar=Character.toUpperCase(currentChar);
                int idx= alphabet.indexOf(currChar);
                if(idx!= -1){
                    char newChar= shiftedAlphabet2.charAt(idx);
                    if(Character.isUpperCase(currentChar)==true){
                        encrypted.setCharAt(i,newChar);
                    }
                    else{
                        char smallChar = Character.toLowerCase(newChar);
                        encrypted.setCharAt(i,smallChar);
                    }
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys(){
        int key1 =23;
        int Key2= 17;
        String encrypted = encryptTwoKeys("First Legion",key1,Key2);
        System.out.println(encrypted);
    
    }

}
