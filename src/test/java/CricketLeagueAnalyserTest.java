import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Target;

public class CricketLeagueAnalyserTest {

   private static final String CRICKET_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
   private static final String OUTPUT_JSON_FILE_PATH = "./src/test/resources/OUTPUT_JSON.json";

   @Test
   public void givenCricketData_When_Sorted_ShouldReturn_BattingAverage_SortedResult() {
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
   public void givenCricketData_WhenSortedOnStrikingRates_ShouldReturnSortedResult() {
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

   @Test
   public void givenCricketData_WhenSortedOnsixes_ShouldReturnSortedResult() {
      try {
         CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
         cricketLeagueAnalyser.loadDataFromSheet(CRICKET_CSV_FILE_PATH);
         String sortedcricketData = cricketLeagueAnalyser.getSixerOfPlayerSortedData();
         IPLRunsCSV[] iplRunsCSV = new Gson().fromJson(sortedcricketData, IPLRunsCSV[].class);
         Assert.assertEquals("Andre Russell", iplRunsCSV[0].playerName);
      } catch (CricketLeagueAnalyserException e) {
         Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.CSV_FILE_PROBLEM, e.type);
      }
   }

   @Test
   public void givenCricketData_WhenSortedOnFours_ShouldReturnSortedResult() {
      try {
         CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
         cricketLeagueAnalyser.loadDataFromSheet(CRICKET_CSV_FILE_PATH);
         String sortedcricketData = cricketLeagueAnalyser.getFoursOfPlayerSortedData();
         IPLRunsCSV[] iplRunsCSV = new Gson().fromJson(sortedcricketData, IPLRunsCSV[].class);
         Assert.assertEquals("Shikhar Dhawan", iplRunsCSV[0].playerName);
      } catch (CricketLeagueAnalyserException e) {
         Assert.assertEquals(CricketLeagueAnalyserException.ExceptionType.CSV_FILE_PROBLEM, e.type);
      }
   }

   @Test
   public void givenCricketData_WhenSortedOnFoursSixes_ShouldReturnSortedResult() throws CricketLeagueAnalyserException, IOException {
      CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
      cricketLeagueAnalyser.loadDataFromSheet(CRICKET_CSV_FILE_PATH);
      String sortedcricketData = cricketLeagueAnalyser.getMaxStrikeRateFoursSixesOfPlayerSortedData();
      IPLRunsCSV[] iplMostRunCSV = new Gson().fromJson(sortedcricketData, IPLRunsCSV[].class);
      FileWriter writer = new FileWriter(OUTPUT_JSON_FILE_PATH);
      writer.write(String.valueOf(iplMostRunCSV[0]));
      writer.close();
      Assert.assertEquals("Ishant Sharma", iplMostRunCSV[0].playerName);
   }

   @Test
   public void givenCricketData_WhenSortedOnGoodAverageWithBestStrikeRate_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
      CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
      cricketLeagueAnalyser.loadDataFromSheet(CRICKET_CSV_FILE_PATH);
      String sortedFactSheetData = cricketLeagueAnalyser.getGoodAverageWithStrikeRateSortedCricketData();
      IPLRunsCSV[] iplRunsCSV =  new Gson().fromJson(sortedFactSheetData, IPLRunsCSV[].class);
      Assert.assertEquals("Ishant Sharma", iplRunsCSV[0].playerName);
   }

   @Test
   public void givenCricketData_WhenSortedOnBestRunsWithAverageOfRuns_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
      CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
      cricketLeagueAnalyser.loadDataFromSheet(CRICKET_CSV_FILE_PATH);
      String sortedFactSheetData = cricketLeagueAnalyser.getBestRunsWithAverageSortedCricketData();
      IPLRunsCSV[] iplRunsCSV =  new Gson().fromJson(sortedFactSheetData, IPLRunsCSV[].class);
      Assert.assertEquals("David Warner", iplRunsCSV[0].playerName);
   }
}
