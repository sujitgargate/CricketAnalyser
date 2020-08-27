import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CricketLeagueAnalyserTest {

   private static final String CRICKET_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";

   @Test
   public void givenCricketData_When_Sorted_ShouldReturn_BattingAverage_SortedResult() throws CricketLeagueAnalyserException {
      try {
         CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
         cricketLeagueAnalyser.loadDataFromSheet(CRICKET_CSV_FILE_PATH);
         String sortedcricketData = cricketLeagueAnalyser.getBattingAvgSortedData();
         IPLRunsCSV[] iplRunsCSV = new Gson().fromJson(sortedcricketData, IPLRunsCSV[].class);
         double playerAvg = 0;
         for(int i = 0; i < iplRunsCSV.length; i ++){
            playerAvg += iplRunsCSV[i].avgRun;
         }
         Assert.assertEquals(2402.1, playerAvg, 0.2);
      } catch (CricketLeagueAnalyserException e) {
         Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.CSV_FILE_PROBLEM, e.type);
      }
   }

   @Test
   public void givenMostRunFactSheet_WhenShortedOnStrikingRates_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
      try {
         CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
         cricketLeagueAnalyser.loadDataFromSheet(CRICKET_CSV_FILE_PATH);
         String sortedcricketData = cricketLeagueAnalyser.getStrikingRateSortedData();
         IPLRunsCSV[] iplMostRunCSV = new Gson().fromJson(sortedcricketData, IPLRunsCSV[].class);
         Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].playerName);
      } catch (CricketLeagueAnalyserException e) {
         Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.CSV_FILE_PROBLEM, e.type);
      }
   }
}
