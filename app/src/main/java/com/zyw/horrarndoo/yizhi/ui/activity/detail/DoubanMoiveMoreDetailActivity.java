package com.zyw.horrarndoo.yizhi.ui.activity.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.view.View;

import com.zyw.horrarndoo.sdk.base.BasePresenter;
import com.zyw.horrarndoo.sdk.utils.DisplayUtils;
import com.zyw.horrarndoo.sdk.utils.StatusBarUtils;
import com.zyw.horrarndoo.yizhi.constant.BundleKeyConstant;
import com.zyw.horrarndoo.yizhi.contract.detail.DoubanMovieMoreDetailConaract;
import com.zyw.horrarndoo.yizhi.presenter.detail.DoubanMovieMoreDetailPresenter;

/**
 * Created by Horrarndoo on 2017/10/20.
 * <p>
 */

public class DoubanMoiveMoreDetailActivity extends
        BaseDetailActivity<DoubanMovieMoreDetailConaract.DoubanMovieMoreDetailPresenter,
                DoubanMovieMoreDetailConaract.IDoubanMovieMoreDetailModel> implements
        DoubanMovieMoreDetailConaract.IDoubanMovieMoreDetailView {

    private String mTitle, mUrl;

    @Override
    protected void initData() {
        super.initData();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mUrl = bundle.getString(BundleKeyConstant.ARG_KEY_DOUBAN_MORE_DETAIL_URL);
            mTitle = bundle.getString(BundleKeyConstant.ARG_KEY_DOUBAN_MORE_DETAIL_TITLE);
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) appBar.getChildAt(0)
                .getLayoutParams();
        // 控件的高强制设成56dp+状态栏高度
        params.height = DisplayUtils.dp2px(56) + StatusBarUtils.getStatusBarHeight
                (mContext);
    }

    @Override
    public void showDoubanMovieMoreDetail(String url) {
        flNetView.setVisibility(View.GONE);
        nswvDetailContent.loadUrl(url);
    }

    @Override
    protected void loadDetail() {
        mPresenter.loadDoubanMovieMoreDetail(mUrl);
    }

    @Override
    protected String getToolbarTitle() {
        return mTitle;
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return DoubanMovieMoreDetailPresenter.newInstance();
    }
}
