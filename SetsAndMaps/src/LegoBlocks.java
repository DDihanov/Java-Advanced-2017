import java.util.stream.Collectors;
import java.util.*;

/**
 * Created by Austin on 25/01/2017.
 */
public class LegoBlocks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());

        List<List<Integer>> first = new ArrayList<>();

        boolean matches = false;

        for (int i = 0; i < rows; i++) {
            List<Integer> temp = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            first.add(temp);
        }

        for (int i = 0; i < rows; i++) {
            List<Integer> temp = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Collections.reverse(temp);

            first.get(i).addAll(temp);

        }


        for (int i = 1; i < first.size(); i++) {
            if(first.get(i).size() == first.get(i-1).size()){
                matches = true;
            } else {
                matches = false;
            }
        }
        
        if(matches){
            for (List<Integer> list :
                    first) {
                System.out.println(list);
            }
        } else{
            int count = 0;
            for (List<Integer> list :
                    first) {
                count += list.size();
            }
            System.out.println("The total number of cells is: " + count);
        }
    }

//    public static int[] reverse(int[] data) {
//
//        int[] tempArr = data;
//        for (int left = 0, right = tempArr.length - 1; left < right; left++, right--) {
//            // swap the values at the left and right indices
//            int temp = tempArr[left];
//            tempArr[left] = tempArr[right];
//            tempArr[right] = temp;
//        }
//        return tempArr;
//    }
}
