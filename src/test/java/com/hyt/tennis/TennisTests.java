package com.hyt.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TennisTests {

    private Tennis tennis = new Tennis("tom", "jerry");

    @Test
    void love_all() {
        scoreShouldBe("love all");
    }

    @Test
    void fifteen_love() {
        givenFirstPlayerScore(1);
        scoreShouldBe("fifteen love");
    }

    @Test
    void thirty_love() {
        givenFirstPlayerScore(2);
        scoreShouldBe("thirty love");
    }

    @Test
    void forty_love() {
        givenFirstPlayerScore(3);
        scoreShouldBe("forty love");
    }

    @Test
    void love_fifteen() {
        givenSecondPlayerScore(1);
        scoreShouldBe("love fifteen");
    }

    @Test
    void love_thirty() {
        givenSecondPlayerScore(2);
        scoreShouldBe("love thirty");
    }

    @Test
    void fifteen_all() {
        givenFirstPlayerScore(1);
        givenSecondPlayerScore(1);
        scoreShouldBe("fifteen all");
    }

    @Test
    void thirty_all() {
        givenFirstPlayerScore(2);
        givenSecondPlayerScore(2);
        scoreShouldBe("thirty all");
    }

    @Test
    void deuce() {
        givenDeuce();
        scoreShouldBe("deuce");
    }

    @Test
    void firstPlayer_adv() {
        givenDeuce();
        givenFirstPlayerScore(1);
        scoreShouldBe("tom adv");
    }

    @Test
    void secondPlayer_adv() {
        givenDeuce();
        givenSecondPlayerScore(1);
        scoreShouldBe("jerry adv");
    }

    @Test
    void secondPlayer_win() {
        givenDeuce();
        givenSecondPlayerScore(2);
        scoreShouldBe("jerry win");
    }

    @Test
    void firstPlayer_win_without_deuce() {
        givenFirstPlayerScore(4);
        scoreShouldBe("tom win");
    }

    private void givenDeuce() {
        givenFirstPlayerScore(3);
        givenSecondPlayerScore(3);
    }

    private void givenSecondPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            tennis.secondPlayerScore();
        }
    }

    private void givenFirstPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            tennis.firstPlayerScore();
        }
    }

    private void scoreShouldBe(String expected) {
        Assertions.assertEquals(expected, tennis.score());
    }
}
