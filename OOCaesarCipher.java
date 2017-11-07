
/**
 * Write a description of OOCaesarCipher here.
 * 
 * @author (VINEET VERMA) 
 * @version (a version number or a date)
 */
public class OOCaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public OOCaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        mainKey = key;
    }
    
    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        for(int i=0; i<sb.length(); i++){
        char c = sb.charAt(i);
        c = Character.toUpperCase(c);
        int idx = alphabet.indexOf(c);
            if(idx!=-1){
                c = shiftedAlphabet.charAt(idx);
                sb.setCharAt(i,c);
            }
        }
        return sb.toString();
    }
    public String decrypt(String input){
        OOCaesarCipher occ = new OOCaesarCipher(26 - mainKey);
        return occ.encrypt(input);
    }    
}
