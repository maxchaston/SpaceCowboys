import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(2123);
      Socket clientSocket = serverSocket.accept();
      System.out.println("Client Connected");
      // Grabs serverSocket input stream and converts to a buffered reader
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      String str;
      // Message receiving loop
      while (true) {
        str = bufferedReader.readLine();
        System.out.println(str);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
