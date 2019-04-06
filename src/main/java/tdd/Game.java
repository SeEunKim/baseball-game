package tdd;

/**
 * Created by SeEun Kim.
 * Date: 2019-04-02
 * Time: 15:48
 */
public class Game {
    private int value;

    public Game(int value) {
        this.value = value;
    }

    public Score guess(int guess) {
        int scnt = 0;
        for (int v = 1; v <= 3; v++) {
            if (pos(value, v) == pos(guess, v)) {
                scnt += 1;
            }
        }

        int bcnt = 0;
        for (int v = 1; v <= 3; v++) {
            if (pos(value, 1) == pos(guess, v)) {
                bcnt += 1;
            }
            if (pos(value, 2) == pos(guess, v)) {
                bcnt += 1;
            }
            if (pos(value, 3) == pos(guess, v)) {
                bcnt += 1;
            }
        }
        return Score.create(scnt, bcnt - scnt);
    }

    private int pos(int value, int pos) {
        switch (pos) {
            case 1 : return value % 10;
            case 2 : return value / 10 % 10;
            case 3 : return value / 100;
        }
        throw new IllegalArgumentException();
    }
}
