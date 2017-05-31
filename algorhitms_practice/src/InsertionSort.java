public class InsertionSort {
    public static void main(String[] args) {

        int[] arr = UtilityFunctions.createArr(20);

        System.out.println("Before:");
        UtilityFunctions.printArr(arr);

        //insertion sort:
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && key < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }

        System.out.println("After:");
        UtilityFunctions.printArr(arr);
    }
}
