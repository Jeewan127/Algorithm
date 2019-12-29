package Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class SameNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,3,3,0,1,1};
        removeNumber(arr);
    }

    private static void removeNumber(int[] arr) {
        int index = 0;
        int number = -1;
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (number != arr[i]) {
                number = arr[i];
                resultList.add(arr[i]);
                System.out.println("First Step | " + arr[i]);
            }
        }

        int[] result = new int[resultList.size()];
        for (int target : resultList) {
            result[index] = target;
            index++;
        }

        System.out.println("Final Result | " + Arrays.toString(result));
    }
}
