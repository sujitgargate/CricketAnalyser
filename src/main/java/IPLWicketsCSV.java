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

   @Override
   public String toString() {
      return "IPLWicketsCSV{" +
              "PLAYER='" + playerName + '\'' +
              ", Avg='" + bowlingPerformance + '\'' +
              ", SR='" + strikeRate + '\'' +
              ", Econ='" + ecoRate + '\'' +
              '}';
   }
}
