
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
     
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
    
    public String halfOfString(String message, int start){
        StringBuilder newMessage = new StringBuilder("");
        for(int i=start; i<message.length(); i=(i+2)){
            newMessage.append(message.charAt(i));
           
        }
        return newMessage.toString();

    }
    
    public int getKey(String s){
        int[] freq = countLetters(s);
        int maxIndex = maxIndex(freq);
        return maxIndex;
    }
    
    public void simpleTests(){
        
        FileResource fr = new FileResource();
        String read = fr.asString();
        CaesarCipherTwo cc =new CaesarCipherTwo(17,3);
        String encrypt = cc.encrypt(read);
        System.out.println("Encrpted Message "+encrypt);
        String decrypt = cc.decrypt(encrypt);
        System.out.println(decrypt);
        String decrypted = breakCaesarCipher(read);
        System.out.println(decrypted);
    }
    
    public String breakCaesarCipher(String read){
         String half0 = halfOfString(read,0);
         String half1 = halfOfString(read,1);
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
         CaesarCipherTwo cc = new CaesarCipherTwo(dkey0,dkey1);
         return cc.decrypt(read);
    }

}
