import com.google.gson.Gson;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CricketLeagueAnalyser {

   Map<String, CricketDataDAO> cricketDatatMap;

   //Loads Data From Sheet
   public Map<String, CricketDataDAO> loadDataFromSheet(String csvFilePath) throws CricketLeagueAnalyserException {
      cricketDatatMap = new IPLDataLoader().loadCricketData(IPLRunsCSV.class, csvFilePath);
      return cricketDatatMap;
   }

   //Finds Avg Of Batting For Player
   public String getBattingAvgSortedData() {
      Comparator<CricketDataDAO> censusComparator = Comparator.comparing(dataCompare -> dataCompare.avgRun);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, censusComparator);
      return new Gson().toJson(IPLDAO);
   }

   //Finds Striking Rate Of Batting For Player
   public String getStrikingRateSortedData() {
      Comparator<CricketDataDAO> censusComparator = Comparator.comparing(dataCompare -> dataCompare.strikeRate);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, censusComparator);
      return new Gson().toJson(IPLDAO);
   }

   //Bubble Sorting For Data
   private void sortData(List<CricketDataDAO> CricketDataDAOList, Comparator<CricketDataDAO> censusComparator) {
      for (int i = 0; i < CricketDataDAOList.size() - 1; i++) {
         for (int j = 0; j < CricketDataDAOList.size() - i - 1; j++) {
            CricketDataDAO leagueFact1 = CricketDataDAOList.get(j);
            CricketDataDAO leagueFact2 = CricketDataDAOList.get(j + 1);
            if (censusComparator.compare(leagueFact1, leagueFact2) < 0) {
               CricketDataDAOList.set(j, leagueFact2);
               CricketDataDAOList.set(j + 1, leagueFact1);
            }
         }
      }
   }

   //Finds Max Sixes Hit By Player
   public String getSixerOfPlayerSortedData() {
      Comparator<CricketDataDAO> censusComparator = Comparator.comparing(dataCompare -> dataCompare.sixers);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, censusComparator);
      return new Gson().toJson(IPLDAO);
   }

   //Finds Max Fours Hit By Player
   public String getFoursOfPlayerSortedData() {
      Comparator<CricketDataDAO> censusComparator = Comparator.comparing(dataCompare -> dataCompare.fours);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, censusComparator);
      return new Gson().toJson(IPLDAO);
   }

   //Finds Max Fours And Sixes With High Strike Rate Hit By Playre
   public String getMaxStrikeRateFoursSixesOfPlayerSortedData() {
      Comparator<CricketDataDAO> censusComparator = Comparator.comparing(dataCompare -> dataCompare.strikeRate);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, censusComparator);
      return new Gson().toJson(IPLDAO);
   }
}