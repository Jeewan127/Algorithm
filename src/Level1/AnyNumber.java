package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 프로그래머스
 * k번째
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class AnyNumber {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        numberCut(array, commands);
    }

    private static void numberCut(int[] array, int[][] commands) {
        System.out.println("numberCut Start!");
        int arrayLength = array.length;
        int commandsLength = commands.length;
        if (arrayLength <= 100 && arrayLength >= 1 && commandsLength <= 50 && commandsLength >= 1) {
            int index = 0;
            ArrayList<Integer> resultList = new ArrayList<>();

            for (int k = 0; k < commandsLength; k++) {
                if (commands[k].length == 3) {
                    int startPoint = commands[k][0] - 1;
                    int endPoint = commands[k][1] - 1;
                    int targetPoint = commands[k][2] - 1;
                    ArrayList<Integer> arrayList = new ArrayList<>();

                    //_ 첫번째 단계: command[0]번쨰부터 command[1]번째 자르기
                    for (int i = 0; i < array.length; i++) {
                        if (i >= startPoint && i <= endPoint) {
                            if (array[i] >= 1 && array[i] <= 100) {
                                arrayList.add(array[i]);
                                System.out.println("First Step | " + arrayList.size() + " | " + arrayList.toString());
                            }
                        }
                    }

                    Collections.sort(arrayList); //_ 두번째 단계: 오름차순 정렬
                    System.out.println("Second Step | " + arrayList.toString());

                    resultList.add(arrayList.get(targetPoint)); //_ 세번째 단계: 결과값 저장
                    System.out.println("Third Step | " + resultList.toString());
                }
            }

            int[] result = new int[resultList.size()];
            for (int number : resultList) {
                result[index] = number;
                index++;
            }


            System.out.println("Final Result | " + Arrays.toString(result));
        }
    }
}
