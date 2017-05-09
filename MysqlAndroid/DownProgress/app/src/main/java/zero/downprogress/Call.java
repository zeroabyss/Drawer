package zero.downprogress;

/**
 * Created by Aiy on 2017/3/27.
 */

public interface Call {
    void progress(int progress);
    void success();
    void pause();
    void failed();
}
