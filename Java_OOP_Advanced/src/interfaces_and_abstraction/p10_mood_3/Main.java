package interfaces_and_abstraction.p10_mood_3;

import interfaces_and_abstraction.p10_mood_3.interfaces.IGameObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        GameObjectFactory gameObjectFactory = new GameObjectFactory();

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] info = sc.readLine().split(" \\| ");

        IGameObject gameObject = gameObjectFactory.createGameObject(info);

        if(!(gameObject == null)){
            System.out.print(gameObject);
        }else{
            return;
        }
    }
}
