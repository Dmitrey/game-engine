package hey.btk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ResourceLoader {
    public static String loadShader(String filename){
        StringBuilder shaderSource = new StringBuilder();
        File file = new File("res/shaders/"+filename);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                shaderSource.append(line).append("\n");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("-------------------------");
        System.out.println(shaderSource.toString());
        System.out.println("-------------------------");
        return shaderSource.toString();
    }
}
