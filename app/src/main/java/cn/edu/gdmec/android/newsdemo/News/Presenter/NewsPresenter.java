package cn.edu.gdmec.android.newsdemo.News.Presenter;

import cn.edu.gdmec.android.newsdemo.Bean.NewsBean;
import cn.edu.gdmec.android.newsdemo.Http.Api;
import cn.edu.gdmec.android.newsdemo.News.Model.INewsModel;
import cn.edu.gdmec.android.newsdemo.News.Model.IOnLoadListener;
import cn.edu.gdmec.android.newsdemo.News.Model.NewsModel;
import cn.edu.gdmec.android.newsdemo.News.NewsFragment;
import cn.edu.gdmec.android.newsdemo.News.View.INewsView;

/**
 * Created by apple on 18/5/22.
 */

public class NewsPresenter implements INewsPresenter,IOnLoadListener {

    private INewsModel iNewsModel;
    private INewsView iNewsView;

    public NewsPresenter(INewsView iNewsView) {
        this.iNewsView = iNewsView;
        this.iNewsModel =new NewsModel();
    }

    @Override
    public void loadNews(int type, int startPage) {
        if (startPage==0){
            iNewsView.showDialog();
        }

        switch (type){
            case NewsFragment.NEWS_TYPE_TOP:
                iNewsModel.loadNews("headline",startPage, Api.HEADLINE_ID,
                        this);
                break;
            case NewsFragment.NEWS_TYPE_NBA:
                iNewsModel.loadNews("list",startPage, Api.NBA_ID,
                        this);
                break;
            case NewsFragment.NEWS_TYPE_JOKES:
                iNewsModel.loadNews("list",startPage, Api.JOKE_ID,
                        this);
                break;
        }

    }
    @Override
    public void success(NewsBean newsBean) {
        iNewsView.hideDialog();
        if (newsBean!=null){
            iNewsView.showNews(newsBean);
        }

    }

    @Override
    public void fail(Throwable throwable) {
        iNewsView.hideDialog();
        iNewsView.showErrorMsg(throwable);
    }

    @Override
    public void loadMoreSuccess(NewsBean newsBean) {
        iNewsView.hideDialog();
        iNewsView.showMoreNews(newsBean);
    }
}
