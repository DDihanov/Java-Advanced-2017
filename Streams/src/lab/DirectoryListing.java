package lab;

import java.io.File;
import java.util.ArrayDeque;

/**
 * Created by Austin on 27/01/2017.
 */
public class DirectoryListing {
    public static void main(String[] args) {

        File file = new File("D:\\streams\\Files-And-Streams");

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);
        int counter = 1;


        while (!queue.isEmpty()) {
            File currentFile = queue.poll();

            File[] dirs = currentFile.listFiles();

            for (File dir :
                    dirs) {
                if (dir.isDirectory()) {
                    queue.offer(dir);
                    counter++;
                }
                
            }
            
            System.out.println(currentFile.getName());
        }

        System.out.println(counter + "folders");
    }
}
