 

 


/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAll();
        int uniqueIps = la.countUniqueIps();
        System.out.println(uniqueIps);
        la.printAllHigherThanNum(400);
        ArrayList<String> uniqueIpsOnDay = la.uniqueIPVisitsOnDay("Mar 24");
        System.out.println(uniqueIpsOnDay);
        System.out.println(" "+uniqueIpsOnDay.size());
        int range = la.countUniqueIPsInRange(200,299);
        System.out.println(range);
    }
    
    public void testCountingVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        HashMap<String,Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
        int maxValue = la.mostNumberVisitsByIP(counts);
        System.out.println(maxValue);
        ArrayList<String> ips = la.iPsMostVisits(counts);
        System.out.println(ips);
        
    }
    
    public void testIpsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        HashMap<String,ArrayList<String>> ips = la.ipsForDays();
        System.out.println(ips);
        String day = la.dayWithMostIPVisits(ips);
        System.out.println(day);
        ArrayList<String> ip = la.iPsWithMostVisitsOnDay(ips,"Sep 30");
        System.out.println(ip);
    }
}
