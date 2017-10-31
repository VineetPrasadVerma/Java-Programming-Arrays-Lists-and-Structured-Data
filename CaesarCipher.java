
/**
 * Write a description of CaesarCipher here.
 * 
 * @author VINEET VERMA
 * @version 30 Oct 2017
 */
public class CaesarCipher {
    
    public String encrypt(String input, int key){
    
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet= alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++){
        
            char currChar= encrypted.charAt(i);
            int idx= alphabet.indexOf(currChar);
            if(idx!= -1){
            
                char newChar= shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
            
        return encrypted.toString();
    }
    
    public void testEncrypt(){
        int key = 23;
        String encrypted = encrypt("FIRST LEGION ATTACK EAST FLANK !",key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted,26-key);
        System.out.println(decrypted);
    
    }

}
