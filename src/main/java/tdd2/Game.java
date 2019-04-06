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
        int bcnt = 0;
        for (int i = 1; i <= 3; i++) {
            if (pos(value, i) == pos(guess, i)) {
                scnt += 1;
            }
        }

        for (int i = 1; i <= 3 ; i++) {
            for (int j = 1; j <=3 ; j++) {
                if (pos(value, i) == pos(guess, j)) {
                    bcnt += 1;
                }
            }
        }
        return new Score(scnt, bcnt - scnt);
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
