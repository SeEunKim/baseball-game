package tdd2;

/**
 * Created by SeEun Kim.
 * Date: 2019-04-07
 * Time: 00:00
 */
public class Game {
    private int value;
    public Game(int value) {
        this.value = value;
    }

    public Score guess(int guess) {
        int scnt = 0;
        for (int i = 1; i <= 3; i++) {
            if (pos(value, i) == pos(guess, i)) {
                scnt += 1;
            }
        }
        return new Score(scnt, 0);
    }

    private int pos(int value, int pos) {
        switch (pos) {
            case 1 :
                return value % 10;
            case 2 :
                return value / 10 % 10;
            case 3 :
                return value / 100;
        }
        throw new IllegalArgumentException();
    }
}
