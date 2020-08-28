
import csvbuilder.CSVBuilderException;
import csvbuilder.CSVBuilderFactory;
import csvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class IPLDataLoader {

   //Loads Cricket Data From CSV File
   public <E> Map<String, CricketDataDAO> loadCricketData(Class<E> IPLRunsCSVClass, String csvFilePath) throws CricketLeagueAnalyserException {
      Map<String, CricketDataDAO> censusStateMap = new HashMap<>();
      try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
         ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
         Iterator csvFileIterator = csvBuilder.getCSVFileIterator(reader, IPLRunsCSVClass);
         Iterable<E> csvIterable = () -> csvFileIterator;
         if (IPLRunsCSVClass.getName().equals("IPLRunsCSV")) {
            StreamSupport.stream(csvIterable.spliterator(), false).map(IPLRunsCSV.class::cast)
                         .forEach(censusCSV -> censusStateMap.put(censusCSV.playerName, new CricketDataDAO(censusCSV)));
         } else if(IPLRunsCSVClass.getName().equals("IPLWicketsCSV"))
            StreamSupport.stream(csvIterable.spliterator(), false).map(IPLWicketsCSV.class::cast)
                    .forEach(censusCSV -> censusStateMap.put(censusCSV.playerName, new CricketDataDAO(censusCSV)));
         return censusStateMap;
      } catch (IOException e) {
         throw new CricketLeagueAnalyserException(e.getMessage(),CricketLeagueAnalyserException.ExceptionType.CSV_FILE_PROBLEM);
      } catch (CSVBuilderException e) {
         throw new CricketLeagueAnalyserException(e.getMessage(), e.type.name());
      }
   }

   //Chooses Between Batsman or Bowler
   public Map<String, CricketDataDAO> leagueLoaderCricketData(CricketLeagueAnalyser.CricketPlayer cricketPlayer, String csvFilePath) throws CricketLeagueAnalyserException {
      if (cricketPlayer.equals(CricketLeagueAnalyser.CricketPlayer.BATSMAN)) {
         return this.loadCricketData(IPLRunsCSV.class, csvFilePath);
      } else if (cricketPlayer.equals(CricketLeagueAnalyser.CricketPlayer.BOWLER)) {
         return this.loadCricketData(IPLWicketsCSV.class, csvFilePath);
      } else throw new CricketLeagueAnalyserException("Incorrect Player Type", CricketLeagueAnalyserException.ExceptionType.PlAYER_NOT_FOUND);
   }
}