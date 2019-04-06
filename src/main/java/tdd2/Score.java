package tdd2;

/**
 * Created by SeEun Kim.
 * Date: 2019-04-07
 * Time: 00:00
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
}
