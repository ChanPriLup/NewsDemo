package cn.edu.gdmec.android.newsdemo.Video.View;

import java.util.List;

import cn.edu.gdmec.android.newsdemo.Bean.TodayContentBean;

/**
 * Created by apple on 18/6/19.
 */

public interface IVideoView {
    void showVideo(List<TodayContentBean> todayContentBeans, List<String> videoList);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
