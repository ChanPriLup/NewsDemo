package cn.edu.gdmec.android.newsdemo.News.Model;

import cn.edu.gdmec.android.newsdemo.Bean.NewsBean;
import cn.edu.gdmec.android.newsdemo.Http.Api;
import cn.edu.gdmec.android.newsdemo.Http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 18/5/22.
 */

public class NewsModel implements INewsModel {

    @Override
    public void loadNews(final String hostType, final int startPage, final String id,
                         final IOnLoadListener iNewsLoadListener) {
        RetrofitHelper retrofitHelper= new RetrofitHelper(Api.NEWS_HOST);
        retrofitHelper.getNews(hostType,id,startPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iNewsLoadListener.fail(e);
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        if (startPage!=0){
                            iNewsLoadListener.loadMoreSuccess(newsBean);
                        }else {
                            iNewsLoadListener.success(newsBean);
                        }

                    }
                });
    }
}
