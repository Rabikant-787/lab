import java.util.*;

public class MiniMaxSum {

    static void miniMaxSum(int[] arr) {
        long totalSum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
      
        for (int num : arr) {
            totalSum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        long minSum = totalSum - max;
        long maxSum = totalSum - min;

        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        miniMaxSum(arr);
        sc.close();
    }
}
