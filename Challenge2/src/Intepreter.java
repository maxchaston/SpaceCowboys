import java.util.*;

public class Intepreter {
  // Variable hashmap
  static HashMap<String, Integer> variables = new HashMap<>();
  static int currentLine = 0;
  static List<String[]> parsedCode = new ArrayList<>();
  static Stack<Integer> whileLoopLine = new Stack<>();
  static Stack<Integer> stopValue = new Stack<>();
  static Stack<String> stopVariable = new Stack<>();

  public static HashMap<String, Integer> run(List<String[]> passedParsedCode) {
    parsedCode = passedParsedCode;
    // Main interpreter loop
    while (currentLine < parsedCode.size()) {
      String[] line = parsedCode.get(currentLine);
      runLine(line);
      currentLine++;
    }
    return variables;
  }

  public static void runLine(String[] line) {
    String command = line[0];
    switch (command) {
      case "clear":
        variables.put(line[1], 0);
        break;
      case "incr":
        variables.put(line[1], variables.getOrDefault(line[1], 0) + 1);
        break;
      case "decr":
        variables.put(line[1], variables.getOrDefault(line[1], 0) - 1);
        break;
      case "while":
        whileLoopLine.push(currentLine);
        stopVariable.push(line[1]);
        stopValue.push(Integer.valueOf(line[3]));
        break;
      case "end":
        if (!variables.get(stopVariable.peek()).equals(stopValue.peek())) {
          currentLine = whileLoopLine.peek();
        } else {
          whileLoopLine.pop();
          stopVariable.pop();
          stopValue.pop();
        }
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + command);
    }
  }
}
