import com.google.gson.Gson;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;;

public class CricketLeagueAnalyser {

   Map<String, CricketDataDAO> cricketDatatMap;

   public enum CricketPlayer {
      BATSMAN, BOWLER
   }

   //Loads Data From Sheet
   public <E> Map<String, CricketDataDAO> loadDataFromSheet(CricketPlayer cricketPlayer, String csvFilePath) throws CricketLeagueAnalyserException {
      cricketDatatMap = new IPLDataLoader().leagueLoaderCricketData(cricketPlayer, csvFilePath);
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

   //Finds Best Strike Rate With Good Average Of Batting
   public String getGoodAverageWithStrikeRateSortedCricketData() {
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      Comparator<CricketDataDAO> avgCompare = Comparator.comparing(leagueFact -> leagueFact.avgRun);
      Comparator<CricketDataDAO> strikeRateCompare = Comparator.comparing(leagueFact -> leagueFact.strikeRate);
      this.sortData(IPLDAO, strikeRateCompare.thenComparing(avgCompare));
      return new Gson().toJson(IPLDAO);
   }

   //Finds Best Runs With Average Runs
   public String getBestRunsWithAverageSortedCricketData() {
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      Comparator<CricketDataDAO> avgCompare = Comparator.comparing(leagueFact -> leagueFact.avgRun);
      Comparator<CricketDataDAO> runsCompare = Comparator.comparing(leagueFact -> leagueFact.playerRuns);
      this.sortData(IPLDAO, runsCompare.thenComparing(avgCompare));
      return new Gson().toJson(IPLDAO);
   }

   //Finds Best Bowler By Average Runs
   public String getBowlingAverageSortedCricketData() {
      Comparator<CricketDataDAO> bowlingCompare = Comparator.comparing(leagueFact -> leagueFact.avgRun);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, bowlingCompare);
      return new Gson().toJson(IPLDAO);
   }

   //Finds Best Bowler By Strike Rate
   public String getBowlerStrikeRateSortedCricketData() {
      Comparator<CricketDataDAO> bowlerStrikeRateCompare = Comparator.comparing(leagueFact -> leagueFact.strikeRate);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, bowlerStrikeRateCompare);
      return new Gson().toJson(IPLDAO);
   }

   //Finds Best Economy Rate For Bowler
   public String getEconomyRateSortedCricketData() {
      Comparator<CricketDataDAO> ecoRateComparator = Comparator.comparing(leagueFact -> leagueFact.ecoRate);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, ecoRateComparator);
      return new Gson().toJson(IPLDAO);
   }

   //Finds Best Strike Rate With 5 Wickets And 4 Wickets
   public String getStrikeRateWith4wAnd5wSortedCricketData() {
      Comparator<CricketDataDAO> bowlerStrikeRateCompare = Comparator.comparing(leagueFact -> leagueFact.strikeRate);
      Comparator<CricketDataDAO> wicketCompare = Comparator.comparing(leagueFact -> leagueFact.fourWickets + leagueFact.fiveWickets);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, wicketCompare.thenComparing(bowlerStrikeRateCompare));
      return new Gson().toJson(IPLDAO);
   }


   public String getStrikeRateWithBowlingSortedCricketData() {
      Comparator<CricketDataDAO> bowlerStrikeRateCompare = Comparator.comparing(leagueFact -> leagueFact.avgRun);
      Comparator<CricketDataDAO> wicketCompare = Comparator.comparing(leagueFact -> leagueFact.strikeRate);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, wicketCompare.thenComparing(bowlerStrikeRateCompare));
      return new Gson().toJson(IPLDAO);
   }

   public String getBowlingAverageWithMaxWicketSortedCricketData() {
      Comparator<CricketDataDAO> bowlingWicketsComparae = Comparator.comparing(leagueFact -> leagueFact.wickets);
      Comparator<CricketDataDAO> bowlerAvgRunsCompare = Comparator.comparing(leagueFact -> leagueFact.bowlingPerformance);
      List<CricketDataDAO> IPLDAO = cricketDatatMap.values().stream().collect(Collectors.toList());
      this.sortData(IPLDAO, bowlingWicketsComparae.thenComparing(bowlerAvgRunsCompare));
      return new Gson().toJson(IPLDAO);
   }
}