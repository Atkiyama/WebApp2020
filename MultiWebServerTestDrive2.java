import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
public class MultiWebServerTestDrive2 {
  public static void main(String[] args)

  throws UnknownHostException, IOException{

    int i=1, PORT=8088;
    ServerSocket serverSocket = null;
    try{
      System.out.println("* Start Server");
      serverSocket = new ServerSocket(PORT);
      System.out.println("** Listening on "+PORT);
      while(true){
        // wait connection
        Socket socket = serverSocket.accept();
        System.out.println("** Accept returned!");
        // thread for connection
        ClientThread2 ct = new ClientThread2(socket, i);
        ct.start();
        i++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(serverSocket!=null){
          serverSocket.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
