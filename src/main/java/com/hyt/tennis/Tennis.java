package com.hyt.tennis;

import java.util.HashMap;
import java.util.Map;

public class Tennis {


    HashMap<Integer, String> scoreStringMap = new HashMap<Integer, String>();

    int firstPlayerScore;
    int secondPlayerScore;
    String firstPlayerName;
    String secondPlayerName;

    public Tennis(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
        scoreStringMap.put(0, "love");
        scoreStringMap.put(1, "fifteen");
        scoreStringMap.put(2, "thirty");
        scoreStringMap.put(3, "forty");

    }

    public String score() {
        if (firstPlayerScore == secondPlayerScore) {

            if (firstPlayerScore < 3) {
                return scoreStringMap.get(firstPlayerScore) + " all";
            } else {
                return "deuce";
            }

        } else {

            if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {

                if (firstPlayerScore - secondPlayerScore == 1) {
                    return firstPlayerName + " adv";
                } else if (secondPlayerScore - firstPlayerScore == 1) {
                    return secondPlayerName + " adv";
                } else if (firstPlayerScore - firstPlayerScore == 2) {
                    return firstPlayerScore + " win";
                } else if (secondPlayerScore - firstPlayerScore == 2) {
                    return secondPlayerName + " win";
                } else {
                    return "error";
                }

            } else {
                return scoreStringMap.get(firstPlayerScore) + " " + scoreStringMap.get(secondPlayerScore);
            }
        }


    }

    public void firstPlayerScore() {
        firstPlayerScore++;
    }

    public void secondPlayerScore() {
        secondPlayerScore++;
    }
}
