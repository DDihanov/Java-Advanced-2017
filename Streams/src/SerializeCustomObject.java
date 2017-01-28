import java.io.*;

/**
 * Created by Austin on 27/01/2017.
 */
public class SerializeCustomObject {
    private final static String path = "/src/resources/course.ser";
    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        String objectPath = projectPath + path;

        Course course = new Course();

        course.duration = 22;
        course.name = "Alchemy";
        course.participants = 220;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectPath))) {
            oos.writeObject(course);
        }catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectPath))) {
            Course readCourse = (Course) ois.readObject();


            System.out.println(readCourse.name);
            System.out.println(readCourse.participants);
            System.out.println(readCourse.duration);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
