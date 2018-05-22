package cn.edu.gdmec.android.newsdemo.News;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.edu.gdmec.android.newsdemo.R;

import static cn.edu.gdmec.android.newsdemo.News.NewsFragment.NEWS_TYPE_JOKES;
import static cn.edu.gdmec.android.newsdemo.News.NewsFragment.NEWS_TYPE_NBA;
import static cn.edu.gdmec.android.newsdemo.News.NewsFragment.NEWS_TYPE_TOP;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends Fragment {
    private int type;
    private TextView tv_name;

    public static NewsListFragment newsInstance(int type){
        Bundle args = new Bundle();
        NewsListFragment fragment = new NewsListFragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        type = getArguments().getInt("type");
        tv_name = view.findViewById(R.id.tv_news);
        switch (type){
            case NEWS_TYPE_TOP:
                tv_name.setText("TOP");
                break;
            case NEWS_TYPE_NBA:
                tv_name.setText("NBA");
                break;
            case NEWS_TYPE_JOKES:
                tv_name.setText("JOKES");
                break;
        }
    }
}
