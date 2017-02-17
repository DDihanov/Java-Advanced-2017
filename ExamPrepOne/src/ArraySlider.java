//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class ArraySlider {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] arr = Arrays.stream(sc.readLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//
//        int index = 0;
//
//        String input;
//
//        while (!"stop".equals(input = sc.readLine())) {
//            String[] commands = input.split("\\s+");
//
//            int offset = Integer.parseInt(commands[0]);
//            int number = Integer.parseInt(commands[2]);
//
//            char command = commands[1].charAt(0);
//
//            index = (offset+index)%arr.length;
//
//            if(index<0){
//                index = arr.length + offset;
//            }
//
//            switch (command) {
//                case '&':
//                    arr[index] &= number;
//                    break;
//                case '|':
//                    arr[index] |= number;
//                    break;
//                case '^':
//                    arr[index] ^= number;
//                    break;
//                case '+':
//                    arr[index] += number;
//                    break;
//                case '-':
//                    arr[index] -= number;
//                    break;
//                case '*':
//                    arr[index] *= number;
//                    break;
//                case '/':
//                    arr[index] /= number;
//                    break;
//                default:
//                    break;
//            }
//
//            if (arr[index] < 0) {
//                arr[index] = 0;
//            }
//        }
//
//
//
//        System.out.println(Arrays.toString(arr));
//    }
//}
