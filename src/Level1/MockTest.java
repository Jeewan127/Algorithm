package Level1;

import java.util.*;

/**
 * 프로그머스
 * 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class MockTest {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};

        int[] result = solution(answers);

        System.out.println("결과: " + Arrays.toString(result));
    }

    private static int[] solution(int[] answers) {
        int[] answerPerson = {};

        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};

        int firstPerson = 1;
        int secondPerson = 1;
        int thirdPerson = 1;

        HashMap<Integer, Integer> scoreMap = new HashMap<>();

        if (answers.length <= 10000) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == person1[i % 5]) {
                    scoreMap.put(1, firstPerson);
                    firstPerson++;
                }

                if (answers[i] == person2[i % 8]) {
                    scoreMap.put(2, secondPerson);
                    secondPerson++;
                }

                if (answers[i] == person3[i % 10]) {
                    scoreMap.put(3, thirdPerson);
                    thirdPerson++;
                }
            }

            if (firstPerson == secondPerson && firstPerson == thirdPerson) {
                // 정답을 맞춘사람이 없거나 똑같이 맞추었을 때
                answerPerson = new int[]{1, 2, 3};
                System.out.println("solution, is all same or no answer");
            } else {
                int key = 0;
                int max = Math.max(firstPerson, Math.max(secondPerson, thirdPerson)) - 1;
                System.out.println("solution max | " + max);
                for (Integer o : scoreMap.keySet()) {
                    if (scoreMap.get(o) == max) {
                        if (key == 0) {
                            answerPerson = new int[]{o};
                            key = o;
                            System.out.println("solution | " + o);
                        } else {
                            answerPerson = new int[]{key, o};
                            System.out.println("solution | " + key + " | " + o);
                        }
                    }
                }
            }

        }

        return answerPerson;
    }
}
