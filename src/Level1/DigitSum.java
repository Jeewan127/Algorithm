package Level1;
/**
 * 프로그래머스
 * 자릿수 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/12931
 */
public class DigitSum {
    public static void main(String[] args) {
        sumSolution(10000001);
    }

    private static void sumSolution(int number) {
        if (number >= 0 && number <= 100000000) {
            int result = 0;
            String numberStr = String.valueOf(number);
            System.out.println("sumSolution | " + numberStr + " | " + numberStr.length());
            for (int i=0; i<numberStr.length(); i++) {
                int num = Integer.parseInt(numberStr.substring(i, i+1));
                result = result + num;
                System.out.println(i + "번째 숫자: " + num + " | " + result);
            }

            System.out.println("Result: " + result);
        }
    }
}
