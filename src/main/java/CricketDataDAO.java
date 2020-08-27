import java.util.Map;

public class CricketDataDAO {

   public String playerName;
   public double avgRun;
   public double strikeRate;

   public CricketDataDAO(IPLRunsCSV iplRunsCSV) {
      playerName = iplRunsCSV.playerName;
      avgRun = iplRunsCSV.avgRun;
      strikeRate = iplRunsCSV.strikeRate;
   }
}
