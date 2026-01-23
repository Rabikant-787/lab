import java.util.Scanner;

class Sorting {
    public static void main(String[] args) {

        int[] arr = {11, 22, 44, 56, 47};
        int d;

        
        for (int i = 0; i < arr.length; i++) {        
            for (int j = i + 1; j < arr.length; j++) { 

                if (arr[i] > arr[j]) {
                    d = arr[i];
                    arr[i] = arr[j];
                    arr[j] = d;
                }
            }
        }

        
        System.out.println("Sorted Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
 