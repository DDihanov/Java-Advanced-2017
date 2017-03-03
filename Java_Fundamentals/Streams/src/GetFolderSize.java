import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Austin on 28/01/2017.
 */
public class GetFolderSize {
    private final static String path = "D:\\streams\\Files-And-Streams";

    public static void main(String[] args) {

        File file = new File(path);

        long size = 0;

        try {
            size = Files.walk(Paths.get(path)).mapToLong(p->p.toFile().length()).sum();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(size);

    }
}
