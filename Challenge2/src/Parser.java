import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Parser {
  public static List<String[]> parse() {
    try {
      String fileContent = Files.readString(Path.of("src/example.bare"));
      String[] unParsedCode = fileContent.split(";\\n?\\r?");
      List<String[]> parsedCode = new ArrayList<>();
      for (String s : unParsedCode) {
        parsedCode.add(s.replaceAll("\r", "").replaceAll("\n", "").strip().split(" "));
      }
      return parsedCode;
    } catch (IOException error) {
      System.out.println(error);
    }
    return null;
  }
}
