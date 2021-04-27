import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class KeyboardStreamTestDrive {
  public static void main(String[] args) throws IOException {
    // System.in (ラップ)-> InputStreamReader (ラップ) -> BufferedReader
    // System.in: バイトストリームで読み込み
    // InputStreamReader: バイトストリームをテキストに変換してread()で1文字ずつ読める
    // BufferedReader: テキスト入力をバッファに格納しreadLine()で1行ずつ読める
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 入力された文字を変数に代入
    String st = br.readLine();
    // 入力された文字を表示
    System.out.println(st);
  }
}
