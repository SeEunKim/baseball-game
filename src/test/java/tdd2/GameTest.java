package tdd2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by SeEun Kim.
 * Date: 2019-04-06
 * Time: 23:53
 */
public class GameTest {
    @Test
    public void noMatch() {
        Game game = new Game(123);
        assertNoMatch(game.guess(456));
        assertNoMatch(game.guess(786));
    }

    private void assertNoMatch(Score score) {
        assertThat(score.strikes()).isEqualTo(0);
        assertThat(score.balls()).isEqualTo(0);
    }

    @Test
    public void allStrikes() {
        Game game = new Game(123);
        assertAllStrikes(game.guess(123));

        Game game1 = new Game(345);
        assertAllStrikes(game1.guess(345));
    }

    private void assertAllStrikes(Score s) {
        assertThat(s.strikes()).isEqualTo(3);
        assertThat(s.balls()).isEqualTo(0);
    }
}
