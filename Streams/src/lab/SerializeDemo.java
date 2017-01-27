package lab;

import java.io.*;

/**
 * Created by Austin on 27/01/2017.
 */
public class SerializeDemo {
    public static void main(String[] args) {

        final String objectPath = "D:\\streams\\object.ser";

        Cube cube = new Cube();

        cube.color = "red";
        cube.depth = 12;
        cube.width = 22;
        cube.height = 21;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectPath))) {
            oos.writeObject(cube);
        }catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectPath))) {
            Cube readCube = (Cube) ois.readObject();


            System.out.println(readCube.color);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
