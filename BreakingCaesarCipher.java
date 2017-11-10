
/**
 * Write a description of BreakingCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class BreakingCaesarCipher {
    public String decryption(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] vals = countLetters(encrypted);
        int maxiIndex = maxIndex(vals);
        int dkey = maxiIndex-4;
        if(maxiIndex<4){
            dkey = 26-(4-maxiIndex);
        }
        return cc.encrypt(encrypted,26-dkey);
    }
    
    public int maxIndex(int[] vals){
        int maxiIndex = 0;
        for(int i=0; i<vals.length; i++){
            if(vals[i]>vals[maxiIndex]){
                maxiIndex=i;
            }
        }
        return maxiIndex;
    }
    
    public int[] countLetters(String message){
        String alph="abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i=0;i<message.length();i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int index = alph.indexOf(ch);
            if(index!=-1){
                counts[index] +=1;
            }
        }
        return counts;     
    }
    
    public void testDecryption(){
    String decryptedMessage = decryption("Qbkm Zgis");
    System.out.println("MESSAGE IS "+decryptedMessage);
    }
    
    public String halfOfString(String message, int start){
        StringBuilder newMessage = new StringBuilder("");
        for(int i=start; i<message.length(); i=(i+2)){
            newMessage.append(message.charAt(i));
           
        }
        return newMessage.toString();

    
    }
    public void testHalfOfString(){
        halfOfString("Qbkm Zgis",1);
    }
    
    public int getKey(String s){
        int[] freq = countLetters(s);
        int maxIndex = maxIndex(freq);
        return maxIndex;
    }
    
    public String decryptTwoKeys(String encrypted){
         CaesarCipher cc =new CaesarCipher();
         String half0 = halfOfString(encrypted,0);
         String half1 = halfOfString(encrypted,1);
         int maxIndex0 = getKey(half0);
         int maxIndex1 = getKey(half1);
         int dkey0 = maxIndex0-4;
         int dkey1 = maxIndex1-4;
         if(maxIndex0<4){
            dkey0 = 26-(4-maxIndex0);
         }
         if(maxIndex1<4){
            dkey1 = 26-(4-maxIndex1);
         }
         System.out.println("key for half starting 0 is "+dkey0);
         System.out.println("key for half starting 1 is "+dkey1);
         return cc.encryptTwoKeys(encrypted,26-dkey0,26-dkey1);
    }
    public void testDecryptTwoKeys(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        //String message = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String decrypted = decryptTwoKeys(message);
        System.out.println(decrypted);
    
    }
    
    
}
