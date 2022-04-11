package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static String randomCount  = String.valueOf(Randoms.pickNumberInRange(99, 999));
    private static int gameStatus = 1;
    private static int ball;
    private static int strike;

    public static void main(String[] args) {
        while (gameStatus == 1) {
            resetValue();
            System.out.println("randomCount = " + randomCount);
            System.out.println("숫자를 입력해주세요 : ");
            checkResult(Console.readLine());
            printConsole();
        }
    }

    public static void checkResult(String userValue) {
        if (userValue.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자만 입력해 주세요.");
        }
        for (int i = 0; i < randomCount.length(); i++) {
            String eachNumber = userValue.substring(i, i + 1);
            String eachRandomNumber = randomCount.substring(i, i + 1);
            checkEachNumber(eachRandomNumber, eachNumber);
        }
    }

    public static void checkEachNumber(String eachRandomNumber, String eachNumber) {
        if (hasNumber(eachNumber) && eachRandomNumber.equals(eachNumber)) {
            strike++;
        }

        if (hasNumber(eachNumber) && !eachRandomNumber.equals(eachNumber)) {
            ball++;
        }
    }

    public static boolean hasNumber(String value) {
        return randomCount.contains(String.valueOf(value));
    }

    public static void resetValue() {
        if (strike == 3) {
            randomCount = String.valueOf(Randoms.pickNumberInRange(99, 999));
        }
        strike = 0;
        ball = 0;
    }

    public static void printConsole() {
        if (strike == 3 && ball == 0) {
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임끝 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameStatus = Integer.parseInt(Console.readLine());
        }

        if (strike != 0 && ball != 0) {
            System.out.println(strike+"스트라이트 "+ball+"볼");
        }

        if (strike == 0 && ball != 0) {
            System.out.println(ball+"볼");
        }

        if (strike != 0 && ball == 0) {
            System.out.println(strike+"스트라이크");
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

    }
}
