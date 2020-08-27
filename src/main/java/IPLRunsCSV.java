import com.opencsv.bean.CsvBindByName;

public class IPLRunsCSV {
   @CsvBindByName(column = "PLAYER", required = true)
   public String playerName;

   @CsvBindByName(column = "Avg", required = true)
   public double avgRun;

   @CsvBindByName(column = "SR", required = true)
   public double strikeRate;

   @CsvBindByName(column = "6s", required = true)
   public int sixers;

   @Override
   public String toString() {
      return "IPLRunsCSV{" +
              "PLAYER='" + playerName + '\'' +
              ", Avg='" + avgRun + '\'' +
              ", SR='" + strikeRate + '\'' +
              '}';
   }
}
