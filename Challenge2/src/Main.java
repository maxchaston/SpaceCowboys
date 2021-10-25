public class Main {
  public static void main(String[] args) {
    Intepreter.run(Parser.parse()).forEach((key, value) -> System.out.println(key + ":" + value));
  }
}
