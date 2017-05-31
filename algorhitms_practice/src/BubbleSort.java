public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = UtilityFunctions.createArr(16);


        System.out.println("Before:");
        UtilityFunctions.printArr(arr);

        //bubble sort:
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("After:");
        UtilityFunctions.printArr(arr);

    }
}
