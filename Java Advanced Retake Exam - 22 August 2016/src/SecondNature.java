import java.util.*;
import java.util.stream.Collectors;

public class SecondNature {
    public static void main(String[] args) {
        LinkedList<Long> flowers = new LinkedList<>();
        LinkedList<Long> buckets = new LinkedList<>();
        LinkedList<Long>secondNature = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        List<Long> flowersArr = Arrays.stream(sc.nextLine().split("\\s+"))
                            .map(Long::parseLong)
                            .collect(Collectors.toList());

        List<Long> bucketsArr = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        flowers.addAll(flowersArr);

        buckets.addAll(bucketsArr);

        while(!buckets.isEmpty() && !flowers.isEmpty()){
            long flower = flowers.peek();
            long bucket = buckets.peekLast();

            if(bucket - flower == 0){
                secondNature.add(flower);
                flowers.pollFirst();
                buckets.pollLast();
            } else if(flower > bucket){
                flowers.pollFirst();
                long temp = flowers.pollFirst();
                flowers.push(temp + Math.abs(flower - bucket));
                buckets.pollLast();
            } else if(bucket > flower){
                flowers.pollFirst();
                if(buckets.size() == 1){
                    if(buckets.peekFirst() - flower <= 0){
                        buckets.poll();
                        break;
                    }
                    buckets.add(buckets.poll() - flower);
                } else{
                    long temp = buckets.pollLast();
                    buckets.add(buckets.pollLast() + Math.abs(flower - bucket));
                }
            }
        }

        if(buckets.isEmpty()){
            print(flowers, "flowers");
            if(secondNature.isEmpty()){
                System.out.println("None");
            }else{
                print(secondNature, "default");
            }
        } else{
            print(buckets, "buckets");
            if(secondNature.isEmpty()){
                System.out.println("None");
            }else{
                print(secondNature, "default");
            }
        }
    }

    public static void print(LinkedList<Long> arrayDeque, String type){
        switch(type) {
            case "buckets":
                while(!arrayDeque.isEmpty()){
                    System.out.print(arrayDeque.pollLast() + " ");
                }
                System.out.print("\n");
                return;
            case"flowers":
                while(!arrayDeque.isEmpty()){
                    System.out.print(arrayDeque.pop() + " ");
                }
                System.out.print("\n");
                return;
            default:
                while(!arrayDeque.isEmpty()){
                    System.out.print(arrayDeque.poll() + " ");
                    return;
                }
        }
    }
}
