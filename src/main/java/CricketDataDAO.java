import java.util.Map;

public class CricketDataDAO {

   public String playerName;
   public double avgRun;
   public double strikeRate;
   public int sixers;
   public int fours;
   public double playerRuns;
   public double bowlingPerformance;
   public double ecoRate;
   public double fourWickets;
   public double fiveWickets;

   public CricketDataDAO(IPLRunsCSV iplRunsCSV) {
      playerName = iplRunsCSV.playerName;
      avgRun = iplRunsCSV.avgRun;
      strikeRate = iplRunsCSV.strikeRate;
      sixers = iplRunsCSV.sixers;
      fours = iplRunsCSV.fours;
      playerRuns = iplRunsCSV.playerRuns;
   }

   public CricketDataDAO(IPLWicketsCSV iplWicketsCSV) {
      playerName = iplWicketsCSV.playerName;
      bowlingPerformance = iplWicketsCSV.bowlingPerformance;
      strikeRate = iplWicketsCSV.strikeRate;
      ecoRate = iplWicketsCSV.ecoRate;
      fourWickets = iplWicketsCSV.fourWickets;
      fiveWickets = iplWicketsCSV.fiveWickets;

   }
}
