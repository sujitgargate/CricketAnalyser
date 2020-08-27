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
      Comparator<CricketDataDAO> censusComparator = Comparator.comparing(leagueFact -> leagueFact.avgRun);
      List<CricketDataDAO> factSheetDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(factSheetDAO, censusComparator);
      return new Gson().toJson(factSheetDAO);
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
}