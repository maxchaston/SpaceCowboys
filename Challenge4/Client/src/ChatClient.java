import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
  public static void main(String[] args) {
    try {
      Socket clientSocket = new Socket("localhost", 2123);
      // Grabs clientSocket output stream
      PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
      Scanner in = new Scanner(System.in);

      String input;
      // Message sending loop
      while (true) {
        input = in.nextLine();
        printWriter.println(input);
        printWriter.flush();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
