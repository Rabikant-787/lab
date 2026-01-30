import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Item {
    int weight;
    int value;
    double ratio;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack {

    public static double getMaxValue(Item[] items, double capacity) {

        // Sort by value/weight ratio (descending)
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return Double.compare(i2.ratio, i1.ratio);
            }
        });

        double totalProfit = 0.0;
        double remainingCapacity = capacity;

        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                totalProfit += item.value;
                remainingCapacity -= item.weight;
            } else {
                totalProfit += item.value * (remainingCapacity / item.weight);
                break;
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight and value of item " + (i + 1) + ":");
            int weight = sc.nextInt();
            int value = sc.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter knapsack capacity: ");
        double capacity = sc.nextDouble();

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in knapsack: " + maxValue);

        sc.close();
    }
}
