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
    public void loadNews( String total, final IOnLoadListener iOnLoadListener) {
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
                        iOnLoadListener.fail(e.getMessage());
                    }

                    @Override
                    public void onNext(MoviesBean moviesBean) {
                        iOnLoadListener.success(moviesBean);
                    }
                });
        /*retrofitHelper.getMovies(total).enqueue(new Callback<MoviesBean>() {
            @Override
            public void onResponse(Call<MoviesBean> call, Response<MoviesBean> response) {
                iOnLoadListener.success(response.body());
                Log.i("response", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<MoviesBean> call, Throwable t) {
                iOnLoadListener.fail(t);
            }
        });*/
    }

}