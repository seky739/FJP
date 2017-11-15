import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {

    private static FileLoader instance;

    private FileLoader(){}
    public static FileLoader getInstance() {
        if(instance == null){
            instance = new FileLoader();
        }
        return instance;
    }


    public String readFile(String fileName){
        StringBuilder str = new StringBuilder();

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null){
                str.append(line + " ");
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();
    }
}
