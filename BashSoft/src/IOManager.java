import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

public class IOManager {
    public static void main(String[] args) {
        traverseDirectory("D:\\");
    }

    public static void traverseDirectory(String path) {
        LinkedList<File> subFolders = new LinkedList<File>();
        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0) {
            File currentFolder = subFolders.removeFirst();

            try {
                if (currentFolder.listFiles() != null) {
                    for (File file : currentFolder.listFiles()) {
                        if (file.isDirectory() && file.listFiles() != null) {
                            subFolders.addAll(Arrays.asList(file.listFiles()));
                        }
                    }
                }
                System.out.println(currentFolder.toString());
            } catch (Exception e) {
                System.out.print("Access denied");
            }
        }
    }
}

