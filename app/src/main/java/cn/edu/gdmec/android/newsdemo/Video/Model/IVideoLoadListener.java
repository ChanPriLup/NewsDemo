package cn.edu.gdmec.android.newsdemo.Video.Model;

import java.util.List;

import cn.edu.gdmec.android.newsdemo.Bean.TodayContentBean;
import cn.edu.gdmec.android.newsdemo.Bean.VideoUrlBean;

/**
 * Created by apple on 18/6/19.
 */

public interface IVideoLoadListener {
    void videoUrlSuccess(List<VideoUrlBean> videoUrlBeans, List<TodayContentBean> contentBeans);
    void fail(Throwable throwable);
}
