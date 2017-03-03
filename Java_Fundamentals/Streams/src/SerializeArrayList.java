import java.io.*;
import java.util.ArrayList;

/**
 * Created by Austin on 27/01/2017.
 */
public class SerializeArrayList {
    private final static String path = "/src/resources/list.ser";
    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");

        String filePath = projectPath + path;

        ArrayList<Double> doubles = new ArrayList<>();
        ArrayList<Double> doublesInput = new ArrayList<>();


        doubles.add(2.1);
        doubles.add(6.4);
        doubles.add(1.1);
        doubles.add(6.2);

        
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (double d :
                    doubles) {
                objectOutputStream.writeDouble(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            while(objectInputStream.available() > 0){
                double toRead = objectInputStream.readDouble();
                doublesInput.add(toRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (double d :
                doublesInput) {
            System.out.println(d);
        }
    }
    
}
