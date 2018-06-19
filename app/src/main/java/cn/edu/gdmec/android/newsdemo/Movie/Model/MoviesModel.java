package cn.edu.gdmec.android.newsdemo.Movie.Model;

import android.util.Log;

import cn.edu.gdmec.android.newsdemo.Bean.MoviesBean;
import cn.edu.gdmec.android.newsdemo.Http.Api;
import cn.edu.gdmec.android.newsdemo.Http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 18/6/5.
 */

public class MoviesModel implements IMoviesModel {

    @Override
    public void loadMovies( String total, final IOnLoadListener iMoviesLoadListener) {
        RetrofitHelper retrofitHelper= new RetrofitHelper(Api.MOVIE_HOST);
        retrofitHelper.getMovies(total)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MoviesBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iMoviesLoadListener.fail(e);
                    }

                    @Override
                    public void onNext(MoviesBean moviesBean) {
                        iMoviesLoadListener.success(moviesBean);
                    }
                });
    }

}
