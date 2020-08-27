public class CricketLeagueAnalyserException extends Throwable {


   public enum ExceptionType {
      CSV_FILE_PROBLEM, WRONG_HEADER_OR_WRONG_DELIMITER_OR_WRONG_FILE_TYPE
   }

   public ExceptionType type;

   public CricketLeagueAnalyserException(String message, String name) {
      super(message);
      this.type = ExceptionType.valueOf(name);
   }

   public CricketLeagueAnalyserException(String message, ExceptionType type) {
      super(message);
      this.type = type;
   }

   public CricketLeagueAnalyserException(String message, ExceptionType type, Throwable cause) {
      super(message, cause);
      this.type = type;
   }
}
