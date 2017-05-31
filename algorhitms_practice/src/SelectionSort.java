public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = UtilityFunctions.createArr(3);

        System.out.println("Before:");
        UtilityFunctions.printArr(arr);

        //selection sort:
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }

            int smaller = arr[index];
            arr[index] = arr[i];
            arr[i] = smaller;
        }

        System.out.println("After:");
        UtilityFunctions.printArr(arr);
    }
}
