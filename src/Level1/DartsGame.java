package Level1;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartsGame {

    private static int mPreResult = 0;
    private static int mCurrentResult = 0;
    private static Stack<Integer> mResultStack = new Stack<>();

    private static final String BONUS = "BONUS";
    private static final String OPTION = "OPTION";

    public static void main(String[] args) {
        int result = 0;

        String dartScore = "1S2D*3T";
        Pattern pattern = Pattern.compile("^[0-9]*$");
        StringBuilder number = new StringBuilder();

        for (int i=0; i<dartScore.length(); i++) {
            String letter = dartScore.substring(i, i+1); //_ 한 글자씩 가져오기
            System.out.println("현재 글자: " + i + " | " + letter);
            Matcher matcher = pattern.matcher(letter);
            if (matcher.find()) { //_ 숫자 체
                number.append(letter);
            } else if (BONUS.equals(getIsOption(letter))) {
                bonusCalculation(setParseInt(number.toString()), letter);
                number.delete(0, number.length());
            } else if (OPTION.equals(getIsOption(letter))) {
                optionCalculation(letter);
            } else {
                // 해당 사항 없음
            }
        }

        for (int value : mResultStack) {
            result = result + value;
        }

        result = result + mPreResult + mCurrentResult;
        System.out.println("result: " + result + " | " + mPreResult + " | " + mCurrentResult);
    }

    private static void optionCalculation(String option) {
        System.out.println("optionCalculation() | " + option);
        switch (option) {
            case "*":
                mPreResult = mPreResult * 2;
                mCurrentResult = mCurrentResult * 2;
                break;
            case "#":
                mCurrentResult *= (-1);
                break;
            default:
                break;
        }
    }

    private static void bonusCalculation(int score, String bonus) {
        System.out.println("bonusCalculation() | " + score + " | " + bonus);
        int pow = 0;
        switch (bonus) {
            case "S":
                pow = 1;
                break;
            case "D":
                pow = 2;
                break;
            case "T":
                pow = 3;
                break;
            default:
                break;
        }

        mResultStack.push(mPreResult);
        mPreResult = mCurrentResult;

        mCurrentResult = (int) Math.pow(score, pow);
    }

    private static String getIsOption(String option) {
        String result = "";

        switch (option) {
            case "S":
            case "D":
            case "T":
                result = BONUS;
                break;
            case "*":
            case "#":
                result = OPTION;
            default:
                break;
        }
        System.out.println("getIsOption() | " + option + " | " + result);
        return result;
    }

    private static int setParseInt(String string) {
        int result = -1;
        if (string != null && string.length() > 0) {
            result = Integer.parseInt(string);
        }
        System.out.println("setParseInt() | " + string + " | " + result);
        return result;
    }
}
