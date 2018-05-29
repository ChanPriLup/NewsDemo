package cn.edu.gdmec.android.newsdemo.News.Model;

import cn.edu.gdmec.android.newsdemo.Bean.NewsBean;

/**
 * Created by apple on 18/5/22.
 */

public interface IOnLoadListener {
    void success(NewsBean newsBean);
    void fail(String error);
}
