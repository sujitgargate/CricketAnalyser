import java.util.Map;

public class CricketDataDAO {

   public String playerName;
   public double avgRun;

   public CricketDataDAO(IPLRunsCSV iplRunsCSV) {
      playerName = iplRunsCSV.playerName;
      avgRun = iplRunsCSV.avgRun;
   }
}
