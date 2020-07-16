package razerdp.demo.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.Gravity;

import razerdp.demo.popup.DemoPopup;
import razerdp.util.animation.AlphaConfig;
import razerdp.util.animation.AnimationHelper;

/**
 * Created by 大灯泡 on 2019/5/16
 * <p>
 * Description：
 */
public class DemoService extends Service {
    private static final String TAG = "DemoService";
    DemoPopup demoPopup;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (demoPopup == null) {
            demoPopup = new DemoPopup(getApplicationContext());
            demoPopup.setPopupGravity(Gravity.CENTER)
                    .setBlurBackgroundEnable(true)
                    .setShowAnimation(AnimationHelper.asAnimation()
                                              .withAlpha(AlphaConfig.IN)
                                              .toShow())
                    .setDismissAnimation(AnimationHelper.asAnimation()
                                                 .withAlpha(AlphaConfig.OUT)
                                                 .toDismiss());
            demoPopup.setText("在Service弹出Popup，创建该Popup的context：" + getApplicationContext());
        }
        demoPopup.showPopupWindow();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
