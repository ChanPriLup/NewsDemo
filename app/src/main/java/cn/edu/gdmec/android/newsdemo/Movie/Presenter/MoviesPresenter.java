package cn.edu.gdmec.android.newsdemo.Movie.Presenter;


import cn.edu.gdmec.android.newsdemo.Bean.MoviesBean;
import cn.edu.gdmec.android.newsdemo.Movie.Model.IMoviesModel;
import cn.edu.gdmec.android.newsdemo.Movie.Model.IOnLoadListener;
import cn.edu.gdmec.android.newsdemo.Movie.Model.MoviesModel;
import cn.edu.gdmec.android.newsdemo.Movie.View.IMoviesView;

/**
 * Created by apple on 18/6/5.
 */

public class MoviesPresenter implements IMoviesPresenter,IOnLoadListener {

    private IMoviesModel iMoviesModel;
    private IMoviesView iMoviesView;

    public MoviesPresenter(IMoviesView iMoviesView) {
        this.iMoviesView = iMoviesView;
        this.iMoviesModel =new MoviesModel();
    }


    @Override
    public void success(MoviesBean moviesBean) {
        iMoviesView.hideDialog();
        iMoviesView.showNews(moviesBean);
    }

    @Override
    public void fail(String throwable) {

    }

    /*@Override
    public void fail(Throwable throwable) {
        iMoviesView.hideDialog();
        iMoviesView.showErrorMsg(throwable);
    }*/


    @Override
    public void loadNews(String total) {
        iMoviesView.showDialog();
        iMoviesModel.loadNews(total,this);
    }
}
