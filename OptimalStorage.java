import java.util.*;

public class OptimalStorage {
    public static void acs(int a[]) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static float retrive(int a[]) {
        int total = 0, retrivel = 0;
        float average;
        for (int i = 0; i < a.length; i++) {
            retrivel += a[i];
            total += retrivel;
        }
        System.out.println("Total Retrieval Time : " + total);
        average = (float)total / a.length;
        return average;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Length of array : ");
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter Element " + (i + 1) + " : ");
            arr[i] = s.nextInt();
        }
        acs(arr);
        System.out.print("Optimal Order : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Average Retrievel Time : " + retrive(arr));
        s.close();
    }
}
