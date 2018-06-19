package cn.edu.gdmec.android.newsdemo.Movie.Model;

import cn.edu.gdmec.android.newsdemo.Bean.MoviesBean;

/**
 * Created by apple on 18/6/5.
 */

public interface IOnLoadListener {
    void success(MoviesBean moviesBean);
    void fail(Throwable throwable);
}
