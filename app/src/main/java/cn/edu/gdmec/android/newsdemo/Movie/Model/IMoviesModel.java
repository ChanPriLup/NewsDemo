package cn.edu.gdmec.android.newsdemo.Movie.Model;

/**
 * Created by apple on 18/6/5.
 */

public interface IMoviesModel {
    void loadMovies(String total, IOnLoadListener iMoviesLoadListener);
}
