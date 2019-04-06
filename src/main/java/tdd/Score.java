package tdd;

/**
 * Created by SeEun Kim.
 * Date: 2019-04-02
 * Time: 15:48
 */
public class Score {
    private int scnt;
    private int bcnt;

    public Score(int scnt, int bcnt) {
        this.scnt = scnt;
        this.bcnt = bcnt;
    }

    public int strikes() {
        return scnt;
    }

    public int balls() {
        return bcnt;
    }

    public static Score create(int scnt, int bcnt) {
        return new Score(scnt, bcnt);
    }
}
