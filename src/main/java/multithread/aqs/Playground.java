package multithread.aqs;

import java.util.concurrent.Semaphore;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Playground
 * 操场，有5个跑道
 *
 * @author xMustang
 * @since 1.0
 */
public class Playground {
    /**
     * 跑道类
     */
    @ToString
    @AllArgsConstructor
    static class Track {
        private int num;
    }

    private Track[] tracks = {
            new Track(1), new Track(2), new Track(3), new Track(4), new Track(5)};
    private volatile boolean[] used = new boolean[5];

    private Semaphore semaphore = new Semaphore(5, true);

    /**
     * 获取一个跑道
     */
    public Track getTrack() throws InterruptedException {
        semaphore.acquire(1);
        return getNextAvailableTrack();
    }

    /**
     * 返回一个跑道
     */
    public void releaseTrack(Track track) {
        if (makeAsUnused(track))
            semaphore.release(1);
    }

    /**
     * 遍历，找到一个没人用的跑道
     */
    private Track getNextAvailableTrack() {
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                return tracks[i];
            }
        }
        return null;
    }

    private boolean makeAsUnused(Track track) {
        for (int i = 0; i < used.length; i++) {
            if (tracks[i] == track) {
                if (used[i]) {
                    used[i] = false;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
