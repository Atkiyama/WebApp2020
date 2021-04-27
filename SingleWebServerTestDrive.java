import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
public class SingleWebServerTestDrive {
  public static void main(String[] args) throws UnknownHostException, IOException{
    System.out.println("* Start Server");
    ServerSocket serverSocket = new ServerSocket(8088);
    System.out.println("** Listening on 8088");
    Socket socket = serverSocket.accept();
    System.out.println("** Accept returned!");
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    String line = in.readLine();
    if( line.startsWith("GET")) {
      System.out.println("> "+line);
      writeHtml(out);
      while(in.ready()) {
        System.out.println("> "+in.readLine());
      }
    } else {
      System.out.println("** request: "+line);
      out.println("HTTP/1.1 400 Bad Request");
    }
    in.close();
    out.close();

    socket.close();
    serverSocket.close();
    System.out.println("* Exit Server");
  }

  private static void writeHtml(PrintWriter out) {
    out.println("HTTP/1.1 200 OK");
    out.println("");
    out.println("GET method");
  }
}
