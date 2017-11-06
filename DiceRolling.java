
/**
 * Write a description of DiceRolling here.
 * 
 * @author (VINEET VERMA) 
 * @version (a version number or a date)
 */
import java.util.Random;
public class DiceRolling {
    public void simulate(int rolls){
        Random rand = new Random();
        int[] counts = new int[13];
        for(int i=0; i<rolls; i++){
            int d1 = rand.nextInt(6)+1;
            int d2 = rand.nextInt(6)+1;
            counts[d1+d2] +=1;
        }
        for(int k=2; k<=12; k++){
            System.out.println(k+"'s=\t"+counts[k]);
        }
    
    }

}
