import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Austin on 28/01/2017.
 */
public class CreateZipArchive {
    private final static String zip = "\\src\\resources\\files.zip";
    private final static String input1 = "\\src\\resources\\input.txt";
    private final static String input2 = "\\src\\resources\\input1.txt";
    private final static String input3 = "\\src\\resources\\input2.txt";
    
    public static void main(String[] args) {
        //Get project path
        String projectPath = System.getProperty("user.dir");
        String zipPath = projectPath + zip;

        //Add all files that we will ZIP into a list
        ArrayList<String> files = new ArrayList<>();
        files.add(projectPath + input1);
        files.add(projectPath + input2);
        files.add(projectPath + input3);

        //Initialize ZIP file
        File zipName = Paths.get(zipPath).toFile();

        
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipName))) {
            
            //Traverse all files to add
            for (String file :
                    files) {
                byte[] buffer = new byte[2048];
                
                //create ZIP entry by getting the name of the file from the path
                ZipEntry zipEntry = new ZipEntry(Paths.get(file).toFile().getName());

                //Put it into the ZIP output stream
                zipOutputStream.putNextEntry(zipEntry);
                
                //Open file stream
                FileInputStream fileInputStream = new FileInputStream(file);
                
                //Read the contents of the file
                fileInputStream.read(buffer);
                
                //Write the contents of the file in the zip
                zipOutputStream.write(buffer);
                
                
                System.out.println(String.format("Added %s into ZIP archive %s", zipEntry.getName(), zipName.getName()));

                //Close the input stream
                fileInputStream.close();
            }

            //Close the ZIP entries
            zipOutputStream.closeEntry();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
