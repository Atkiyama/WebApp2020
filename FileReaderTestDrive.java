import java.io.FileReader;
import java.io.IOException;
public class FileReaderTestDrive {
  public static void main(final String[] args) throws IOException {
    final FileReader in = new FileReader("hello.txt");
    int ch;
    while ((ch = in.read()) != -1) {
      System.out.print(Integer.toHexString(ch) + " ");
    }
    in.close();
    System.out.println();
  }
}
