
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (VINEET VERMA) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
    public void simpleTest(){
        FileResource fr = new FileResource();
        String read = fr.asString();
        OOCaesarCipher cc =new OOCaesarCipher(18);
        String encrypt = cc.encrypt(read);
        System.out.println("Encrpted Message"+encrypt);
        String decrypt = cc.decrypt(encrypt);
        System.out.println(decrypt);
        String breakdecrypt = breakCaesarCipher(read);
        System.out.println(breakdecrypt);
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
    
    public String breakCaesarCipher(String input){
        int[] vals = countLetters(input);
        int maxiIndex = maxIndex(vals);
        int dkey = maxiIndex-4;
        if(maxiIndex<4){
            dkey = 26-(4-maxiIndex);
        }
        OOCaesarCipher cc =new OOCaesarCipher(dkey);
        return cc.encrypt(input);
        
    }
}
