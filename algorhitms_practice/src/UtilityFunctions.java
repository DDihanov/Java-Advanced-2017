import java.util.Random;

public class UtilityFunctions {
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] createArr(int bound){
        Random random = new Random();

        int[] arr = new int[bound];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bound);
        }

        return arr;
    }
}
