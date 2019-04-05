package tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by SeEun Kim.
 * Date: 2019-04-02
 * Time: 15:39
 */
public class MainTest {
    @Test
    public void nomatch() {
        // 정답인 479인 게임에서
        Game game = new Game(497);

        assertNoMatch(game.guess(123));
        assertNoMatch(game.guess(568));
        assertNoMatch(game.guess(321));
    }

    public void assertNoMatch(Score s) {
        assertThat(s.strikes()).isEqualTo(0);
        assertThat(s.balls()).isEqualTo(0);
    }

    @Test
    public void allstrikes() {
        Game game = new Game(479);
        assertAllStrikes(game.guess(479));

        Game game2 = new Game(123);
        assertAllStrikes(game2.guess(123));
    }

    public void assertAllStrikes(Score s) {
        assertThat(s.strikes()).isEqualTo(3);
        assertThat(s.balls()).isEqualTo(0);
    }

    @Test
    public void somestrikes() {
        Game game = new Game(479);
        assertMatch(game.guess(359), 1, 0);
        assertMatch(game.guess(372), 1, 0);
        assertMatch(game.guess(486), 1, 0);

        assertMatch(game.guess(478), 2, 0);
        assertMatch(game.guess(429), 2, 0);
        assertMatch(game.guess(379), 2, 0);
        assertMatch(game.guess(489), 2, 0);
    }

    public void assertMatch(Score score, int s, int b) {
        assertThat(score.strikes()).isEqualTo(s);
        assertThat(score.balls()).isEqualTo(b);
    }

    @Test
    public void allballs() {
        Game game = new Game(123);
        assertMatch(game.guess(231), 0, 3);
        assertMatch(game.guess(312), 0, 3);
    }

    @Test
    public void someballs() {
        Game game = new Game(123);
        assertMatch(game.guess(345), 0, 1);
        assertMatch(game.guess(736), 0, 1);
        assertMatch(game.guess(561), 0, 1);

        assertMatch(game.guess(235), 0, 2);
        assertMatch(game.guess(316), 0, 2);
    }

    @Test
    public void someStrikesAndBalls() {
        Game game = new Game(357);
        assertMatch(game.guess(375), 1, 2);
        assertMatch(game.guess(753), 1, 2);
        assertMatch(game.guess(537), 1, 2);
    }


}
