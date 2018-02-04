 

 


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
         FileResource fr = new FileResource(filename);
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
     
     public int countUniqueIps(){
         ArrayList<String> uniqueIps = new ArrayList<String>();
         for(LogEntry le : records){
             String ips = le.getIpAddress(); 
             if(!uniqueIps.contains(ips)){
                 uniqueIps.add(ips);
             }
         }
         return uniqueIps.size();
     }
     
     public void printAllHigherThanNum(int num){
         for(LogEntry le : records){
             int statusCode = le.getStatusCode();
             if(statusCode>num){
                 System.out.println(statusCode);
             }
         }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someDay){
         ArrayList<String> uniqueIps = new ArrayList<String>();
         for(LogEntry le : records){
             Date d = le.getAccessTime();
             String str = d.toString();
             if(str.contains(someDay)){
                 uniqueIps.add(le.getIpAddress());
             }
         }
         
         return uniqueIps;
     }
     
     public int countUniqueIPsInRange(int low,int high){
         ArrayList<String> noOfUniqueIPsInRange = new ArrayList<String>();
         int count=0;
         for(LogEntry le : records){
             int code = le.getStatusCode();
             if(code>=low && code<=high){
                String ips = le.getIpAddress();
                if(!noOfUniqueIPsInRange.contains(ips)){
                    noOfUniqueIPsInRange.add(ips);
                    count++;
                }
             }
         }
         return count;
     } 
     
     public HashMap<String,Integer> countVisitsPerIP(){
         HashMap<String,Integer> counts = new HashMap<String,Integer>();
         for(LogEntry le : records){
             String ip = le.getIpAddress();
             if(!counts.containsKey(ip)){
                 counts.put(ip,1);
             }
             else{
                 counts.put(ip,counts.get(ip)+1);
             }
         }
         return counts;
     }
     
     public int mostNumberVisitsByIP(HashMap<String,Integer> counts){
         int maxValue = 0;
         for(Integer noOfTimesVisit : counts.values()){
             if(noOfTimesVisit>maxValue){
                maxValue = noOfTimesVisit;
             }
         }
         return maxValue;
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String,Integer> counts){
         ArrayList<String> ipsOfMostVisits = new ArrayList<String>();
         int maxValue = mostNumberVisitsByIP(counts);
         for(String ips : counts.keySet()){
             int value = counts.get(ips);
             if(value==maxValue){
                 ipsOfMostVisits.add(ips);
             }
         }
         return ipsOfMostVisits;
     }
     
     public HashMap<String,ArrayList<String>> ipsForDays(){
        ArrayList<String> ips ;
        HashMap<String,ArrayList<String>> ipsMapsDays = new HashMap<String,ArrayList<String>>();
        for(LogEntry le: records){
            Date d = le.getAccessTime();
            String str = d.toString();
            str = str.substring(4,10);
            if(!ipsMapsDays.containsKey(str)){
                ips = uniqueIPVisitsOnDay(str);
                ipsMapsDays.put(str,ips);
            }
        }
        return ipsMapsDays;
    }
    
    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> ipsForDays){
        int maxValue = Integer.MIN_VALUE;
        String day="";
        for(String s : ipsForDays.keySet()){
             int value = ipsForDays.get(s).size();
             if(value > maxValue){
                 maxValue = value;
                 day=s;
             }
        }
        return day;
     }
     
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> ipsForDays,String day){
        ArrayList<String> ips;
        HashMap<String,Integer> ipMostVisits1 = new HashMap<String,Integer>();
        ips = ipsForDays.get(day);
        for(String ip : ips){
            if(!ipMostVisits1.containsKey(ip)){
                ipMostVisits1.put(ip,1);
            }
            else{
                ipMostVisits1.put(ip,ipMostVisits1.get(ip)+1);
            }
        }
        ips = iPsMostVisits(ipMostVisits1);
        return ips;
    }
    
}
