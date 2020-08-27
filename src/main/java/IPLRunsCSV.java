import com.opencsv.bean.CsvBindByName;

public class IPLRunsCSV {
   @CsvBindByName(column = "PLAYER", required = true)
   public String playerName;

   @CsvBindByName(column = "Avg", required = true)
   public double avgRun;

   @Override
   public String toString() {
      return "IPLRunsCSV{" +
              "PLAYER='" + playerName + '\'' +
              ", Avg='" + avgRun + '\'' +
              '}';
   }
}
