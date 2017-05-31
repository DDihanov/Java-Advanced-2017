public class QuickSort {
    public static void main(String[] args) {
        int[] arr = UtilityFunctions.createArr(10);

        System.out.println("Before:");
        UtilityFunctions.printArr(arr);

        //quick sort:
        //sort entire array from 0th elemnt to last element - arr.length - 1
        quickSort(arr, 0, arr.length - 1);

        System.out.println("After:");
        UtilityFunctions.printArr(arr);

    }

    private static void quickSort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[(low + high) / 2];

        while (i <= j){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }

            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        if(low < j){
            quickSort(arr, low, j);
        }
        if(high > i){
            quickSort(arr, i, high);
        }
    }
}
