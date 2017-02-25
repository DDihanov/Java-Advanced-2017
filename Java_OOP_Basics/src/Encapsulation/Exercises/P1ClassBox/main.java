package Encapsulation.Exercises.P1ClassBox;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

//        Class boxClass = Box.class;
//        Field[] fields = boxClass.getDeclaredFields();
//        System.out.println(Arrays.asList(fields)
//                .stream()
//                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());


       Scanner sc = new Scanner(System.in);
        
        double[] dims = new double[3];

        for (int i = 0; i < 3; i++) {
            dims[i] = sc.nextDouble();
        }
        
        Box box = new Box(dims[0], dims[1], dims[2]);
        
        System.out.printf("Surface Area - %.2f\n", box.getSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f\n", box.getLateralSurfaceArea());
        System.out.printf("Volume - %.2f\n", box.getVolume());
    }

}
