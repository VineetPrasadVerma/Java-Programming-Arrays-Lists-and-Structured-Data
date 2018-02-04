package WebLogProgram;

 


/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     WebLogParser wlp = new WebLogParser();
     public LogAnalyzer() {
         records  = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr = new FileResource("WebLogProgramme\"+filename);
         for(String line : fr.lines()){
             LogEntry logRecord = wlp.parseEntry(line);
             records.add(logRecord);
            
         }
     } 
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
