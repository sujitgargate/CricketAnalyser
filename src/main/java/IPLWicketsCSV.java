import com.opencsv.bean.CsvBindByName;

public class IPLWicketsCSV {

   @CsvBindByName(column = "PLAYER", required = true)
   public String playerName;

   @CsvBindByName(column = "Avg", required = true)
   public double bowlingPerformance;

   @CsvBindByName(column = "SR", required = true)
   public double strikeRate;

   @CsvBindByName(column = "Econ", required = true)
   public double ecoRate;

   @CsvBindByName(column = "4w", required = true)
   public int fourWickets;

   @CsvBindByName(column = "5w", required = true)
   public int fiveWickets;

   @CsvBindByName(column = "Wkts", required = true)
   public double wickets;

   @Override
   public String toString() {
      return "IPLWicketsCSV{" +
              "PLAYER='" + playerName + '\'' +
              ", Avg='" + bowlingPerformance + '\'' +
              ", SR='" + strikeRate + '\'' +
              ", Econ='" + ecoRate + '\'' +
              ", 4w='" + fourWickets + '\'' +
              ", 5w='" + fiveWickets + '\'' +
              ", Wkts='" + wickets + '\'' +
              '}';
   }
}
