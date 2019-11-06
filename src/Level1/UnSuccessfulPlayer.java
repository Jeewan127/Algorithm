package Level1;

import java.util.*;

/**
 * 프로그래머스
 * 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class UnSuccessfulPlayer {
    public static void main(String[] args) {

        System.out.println("UnSuccessful Player Start!");

        String[] participant = {"c", "a", "b", "c", "d", "a"};
        String[] completion = {"a", "c", "b", "d", "a"};

        String result = solution(participant, completion);

        System.out.println("UnSuccessful Player | result: " + result);
    }

    private static String solution(String[] participant, String[] completion) {
        String answer = "";
        int index = 0;

        Map<String, Integer> hashMap = new HashMap<>();

        // participant 이름 저
        for (String participantName : participant) {
            if (hashMap.get(participantName) == null) {
                // 해당 이름이 처음일 때
                hashMap.put(participantName, 1);
            } else {
                // 해당 이름이 처음이 아닐 때, 1증가
                index = hashMap.get(participantName) + 1;
                hashMap.put(participantName, index);
            }
        }

        // 저장한 값에서 -1
        for (String completionName : completion) {
            index = hashMap.get(completionName) - 1;
            hashMap.put(completionName, index);
        }

        // 1이 남은 이름 찾기
        for (String notCompletionName : participant) {
            if (hashMap.get(notCompletionName) == 1) {
                answer = notCompletionName;
            }
        }

        return answer;
    }
}
