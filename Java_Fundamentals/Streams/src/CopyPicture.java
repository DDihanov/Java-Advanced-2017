import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Austin on 28/01/2017.
 */
public class CopyPicture {
    private final static String path = "/src/resources/pic.png";
    private final static String picOutputPath = "/src/resources/pic-copy.png";

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;
        String outputPath = projectPath + picOutputPath;

        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            FileOutputStream fileOutputStream = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];

            int size = fileInputStream.read(buffer);

            while(size>0){
                fileOutputStream.write(buffer, 0, size);
                size = fileInputStream.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        Alternative method to copy picture
//        try {
//            Files.copy(Paths.get(filePath), Paths.get(outputPath), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
