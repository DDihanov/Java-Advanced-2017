package lab;

import java.io.File;

/**
 * Created by Austin on 27/01/2017.
 */
public class PathListing {
    public static void main(String[] args) {

        File file = new File("D:\\streams\\Files-And-Streams");

        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f:
                    files){
                if(!f.isDirectory()){
                    System.out.println(String.format("%s: %d", f.getName(), f.length()));
                }
            }
        }


    }
}
