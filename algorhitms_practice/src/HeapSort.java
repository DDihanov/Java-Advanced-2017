public class HeapSort {
    public static void main(String[] args) {
        int[] arr = UtilityFunctions.createArr(10);
        int n = arr.length;


        System.out.println("Before:");
        UtilityFunctions.printArr(arr);

        //heap sort:
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }




        System.out.println("After:");
        UtilityFunctions.printArr(arr);

    }

    private static void heapify(int[] arr, int length, int root) {
        int largest = root;
        int l = 2 * root + 1;
        int r = 2 * root + 2;

        if(l < length && arr[l] > arr[largest]){
            largest = l;
        }
        if(r < length && arr[r] > arr[largest]){
            largest = r;
        }

        if(largest != root){
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;

            heapify(arr, length, largest);
        }
    }


}
