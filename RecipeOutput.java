import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RecipeOutput {
  public static void main (String[] args) {
    try{
      File file = new File("./RecipeData.txt");

      if (checkReadFileComplete(file)){
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        while((str = br.readLine()) != null){
          System.out.println(str);
        }

        br.close();
      }else{
        System.out.println("ファイルが見つからないか開けません");
      }
    }catch(FileNotFoundException e){
      System.out.println(e);
    }catch(IOException e){
      System.out.println(e);
    }
  }

  private static boolean checkReadFileComplete(File file){
    // ファイルが無い
    if (!file.exists()) {
      return false;
    }

    // ファイルじゃない
    if (!file.isFile()) {
      return false;
    }
    
    // ファイルが読めない
    if (!file.canRead()) {
      return false;
    }

    return true;
  }

}
