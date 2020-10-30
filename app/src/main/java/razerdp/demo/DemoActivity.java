package razerdp.demo;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pgyersdk.update.DownloadFileListener;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;
import com.pgyersdk.update.javabean.AppBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import razerdp.basepopup.BasePopupWindow;
import razerdp.basepopup.QuickPopupBuilder;
import razerdp.basepopup.QuickPopupConfig;
import razerdp.basepopup.R;
import razerdp.demo.base.baseactivity.BaseActivity;
import razerdp.demo.base.baseadapter.BaseSimpleRecyclerViewHolder;
import razerdp.demo.base.baseadapter.SimpleRecyclerViewAdapter;
import razerdp.demo.model.DemoMainItem;
import razerdp.demo.popup.DemoPopup;
import razerdp.demo.popup.update.PopupUpdate;
import razerdp.demo.ui.ActivityLauncher;
import razerdp.demo.ui.ApiListActivity;
import razerdp.demo.ui.CommonUsageActivity;
import razerdp.demo.ui.GuideActivity;
import razerdp.demo.ui.UpdateLogActivity;
import razerdp.demo.ui.issuestest.home.IssueHomeActivity;
import razerdp.demo.utils.ButterKnifeUtil;
import razerdp.demo.utils.UIHelper;
import razerdp.demo.utils.ViewUtil;
import razerdp.demo.widget.DPRecyclerView;
import razerdp.demo.widget.DPTextView;
import razerdp.util.animation.AnimationHelper;
import razerdp.util.animation.ScaleConfig;


public class DemoActivity extends BaseActivity {

    @BindView(R.id.rv_content)
    DPRecyclerView rvContent;

    SimpleRecyclerViewAdapter<DemoMainItem> mAdapter;

    PopupUpdate mPopupUpdate;
    DemoPopup d;

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public int contentViewLayoutId() {
        return R.layout.activity_demo;
    }

    @Override
    protected void onInitView(View decorView) {

        rvContent.setLayoutManager(new LinearLayoutManager(this));
        View header = ViewUtil.inflate(this, R.layout.item_main_demo_header, rvContent, false);
        header.setOnClickListener(v -> onHeaderClick());
        rvContent.addHeaderView(header);
        mAdapter = new SimpleRecyclerViewAdapter<>(this, generateItem());
        mAdapter.setHolder(InnerViewHolder.class);
        mAdapter.setOnItemClickListener((v, position, data) -> ActivityLauncher.start(self(),
                                                                                      data.toClass));
        rvContent.setAdapter(mAdapter);

        checkForUpdate();

        showWjPopup();
    }

    private List<DemoMainItem> generateItem() {
        List<DemoMainItem> result = new ArrayList<>();
        result.add(new DemoMainItem(GuideActivity.class, "简介", GuideActivity.DESC, null));
        result.add(new DemoMainItem(CommonUsageActivity.class,
                                    "快速入门",
                                    CommonUsageActivity.DESC,
                                    "入门推荐"));
        result.add(new DemoMainItem(ApiListActivity.class, "Api列表", ApiListActivity.DESC, "Api"));
        result.add(new DemoMainItem(IssueHomeActivity.class,
                                    "Issue测试Demo",
                                    IssueHomeActivity.DESC,
                                    "issue"));
        result.add(new DemoMainItem(UpdateLogActivity.class,
                                    "历史更新",
                                    UpdateLogActivity.DESC,
                                    "ChangeLog"));
        return result;
    }

    void showWjPopup() {
        QuickPopupBuilder.with(this)
                         .contentView(R.layout.popup_wj)
                         .config(new QuickPopupConfig()
                                         .withShowAnimation(AnimationHelper.asAnimation()
                                                                           .withScale(ScaleConfig.CENTER)
                                                                           .toShow())
                                         .withDismissAnimation(AnimationHelper.asAnimation()
                                                                              .withScale(ScaleConfig.CENTER)
                                                                              .toDismiss())
                                         .withClick(R.id.tv_go, null, true)
                                         .blurBackground(true)
                                         .outSideDismiss(false))
                         .show();
    }

    @Override
    public void onTitleRightClick(View view) {
        checkForUpdate();
    }

    private void checkForUpdate() {
        new PgyUpdateManager.Builder()
                .setUpdateManagerListener(new UpdateManagerListener() {
                    @Override
                    public void onNoUpdateAvailable() {
                        UIHelper.toast("已经是最新版");
                    }

                    @Override
                    public void onUpdateAvailable(AppBean appBean) {
                        if (appBean == null) {
                            UIHelper.toast("已经是最新版");
                            return;
                        }
                        if (mPopupUpdate == null) {
                            mPopupUpdate = new PopupUpdate(self());
                        }
                        mPopupUpdate.reset();
                        mPopupUpdate.showPopupWindow(appBean);
                    }

                    @Override
                    public void checkUpdateFailed(Exception e) {
                        UIHelper.toast("检查失败，请到issue反馈");
                    }
                })
                .setDownloadFileListener(new DownloadFileListener() {
                    @Override
                    public void downloadFailed() {
                        //下载失败
                        if (mPopupUpdate != null) {
                            mPopupUpdate.onError();
                        }
                    }

                    @Override
                    public void downloadSuccessful(File file) {
                        if (mPopupUpdate != null) {
                            mPopupUpdate.dismiss(false);
                        }
                        PgyUpdateManager.installApk(file);
                    }

                    @Override
                    public void onProgressUpdate(Integer... integers) {
                        if (mPopupUpdate != null) {
                            mPopupUpdate.onProgress(integers[0]);
                        }
                    }
                })
                .register();
    }

    void onHeaderClick() {
//        showWjPopup();
        if (d == null) {
            d = new DemoPopup(this);
            d.setWidth(BasePopupWindow.MATCH_PARENT);
            d.setHeight(BasePopupWindow.MATCH_PARENT);
            d.setOverlayStatusbar(false);
        }
        d.showPopupWindow();
    }


    static class InnerViewHolder extends BaseSimpleRecyclerViewHolder<DemoMainItem> {

        @BindView(R.id.tv_tag)
        TextView tvTag;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.divider)
        View divider;
        @BindView(R.id.tv_go)
        DPTextView tvGo;

        public InnerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnifeUtil.bind(this, itemView);
        }

        @Override
        public int inflateLayoutResourceId() {
            return R.layout.item_main_demo;
        }

        @Override
        public void onBindData(DemoMainItem data, int position) {
            tvTag.setVisibility(TextUtils.isEmpty(data.tag) ? View.INVISIBLE : View.VISIBLE);
            tvTag.setText(data.tag);
            tvTitle.setText(data.title);
            tvDesc.setText(data.desc);
        }

        @OnClick(R.id.tv_go)
        void toTarget() {
            ActivityLauncher.start(getContext(), getData().toClass);
        }
    }


    private long lastClickBackTime;

    @Override
    public boolean onBackPressedInternal() {
        if (System.currentTimeMillis() - lastClickBackTime > 2000) {
            UIHelper.toast("再点一次退出");
            lastClickBackTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }

}
