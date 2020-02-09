package Level1;

/**
 * 프로그래머스
 * 두 정수 사이의 합
 * https://programmers.co.kr/learn/courses/30/lessons/12912
 */
public class EssenceSum {
    public static void main(String[] args) {
        sumSolution(5, 3);
    }

    private static void sumSolution(int first, int second) {
        int result = 0;
        boolean isFirst = first >= -10000000 && first <= 10000000;
        boolean isSecond = second >= -10000000 && second <= 10000000;

        if (isFirst && isSecond) {
            if (first <= second) {
                for (int i = first; i <= second; i++) {
                    result = result + i;
                }
            } else {
                for (int i = second; i <= first; i++) {
                    result = result + i;
                }
            }
        }

        System.out.println("Result: " + result);
    }
}
