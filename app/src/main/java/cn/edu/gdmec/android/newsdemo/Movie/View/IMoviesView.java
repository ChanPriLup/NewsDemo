package cn.edu.gdmec.android.newsdemo.Movie.View;

import cn.edu.gdmec.android.newsdemo.Bean.MoviesBean;

/**
 * Created by apple on 18/6/5.
 */

public interface IMoviesView {
    void showNews(MoviesBean moviesBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(Throwable throwable);
}
