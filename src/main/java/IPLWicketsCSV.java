import com.opencsv.bean.CsvBindByName;

public class IPLWicketsCSV {

   @CsvBindByName(column = "PLAYER", required = true)
   public String playerName;

   @CsvBindByName(column = "Avg", required = true)
   public double bowlingPerformance;

   @Override
   public String toString() {
      return "IPLWicketsCSV{" +
              "PLAYER='" + playerName + '\'' +
              ", Avg='" + bowlingPerformance + '\'' +
              '}';
   }
}
