import java.util.Map;

public class CricketDataDAO {

   public String playerName;
   public double avgRun;
   public double strikeRate;
   public int sixers;

   public CricketDataDAO(IPLRunsCSV iplRunsCSV) {
      playerName = iplRunsCSV.playerName;
      avgRun = iplRunsCSV.avgRun;
      strikeRate = iplRunsCSV.strikeRate;
      sixers = iplRunsCSV.sixers;
   }
}
