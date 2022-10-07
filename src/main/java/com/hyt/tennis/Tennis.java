package com.hyt.tennis;

import java.util.HashMap;

public class Tennis {
    private HashMap<Integer, String> lookupScore = new HashMap<>() {{
        put(0, "love");
        put(1, "fifteen");
        put(2, "thirty");
        put(3, "forty");
    }};

    private int firstPlayerScoreTimes;
    private int secondPlayerScoreTimes;
    private String firstPlayerName;
    private String secondPlayerName;

    public Tennis(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public String score() {
        if (isDifferentScore()) {
            if (isReadyForGamePoint()) {
                return isAdv() ? advScore() : winScore();
            }

            return lookupScore();
        }

        return isDeuce() ? deuceScore() : sameScore();

    }

    private boolean isDifferentScore() {
        return firstPlayerScoreTimes != secondPlayerScoreTimes;
    }

    private String sameScore() {
        return String.format("%s all", lookupScore.get(firstPlayerScoreTimes));
    }

    private String deuceScore() {
        return "deuce";
    }

    private boolean isDeuce() {
        return firstPlayerScoreTimes >= 3;
    }

    private String lookupScore() {
        return String.format("%s %s", lookupScore.get(firstPlayerScoreTimes), lookupScore.get(secondPlayerScoreTimes));
    }

    private String winScore() {
        return advPlayer() + " win";
    }

    private String advScore() {
        return advPlayer() + " adv";
    }

    private boolean isReadyForGamePoint() {
        return firstPlayerScoreTimes > 3 || secondPlayerScoreTimes > 3;
    }

    private boolean isAdv() {
        return Math.abs(firstPlayerScoreTimes - secondPlayerScoreTimes) == 1;
    }

    private String advPlayer() {
        return firstPlayerScoreTimes > secondPlayerScoreTimes
                                ? firstPlayerName
                                : secondPlayerName;
    }

    public void firstPlayerScore() {
        firstPlayerScoreTimes++;
    }

    public void secondPlayerScore() {
        secondPlayerScoreTimes++;
    }
}
