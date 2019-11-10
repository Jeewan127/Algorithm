package Level1;

import java.util.Scanner;

/**
 * 프로그래머스
 * 가운데 글자 가져오기
 * https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class MiddleLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("글자를 입력하세요: ");

        String letter = scanner.nextLine();
        String middleLetter = getMiddleLetter(letter);

        System.out.print("result: " + middleLetter);
    }

    private static String getMiddleLetter(String letter) {
        String result = "";
        if (letter.length() >= 1 && letter.length() <= 100) {
            result = letter.substring((letter.length() - 1) / 2, (letter.length() / 2) + 1);
        }

        return result;
    }
}
