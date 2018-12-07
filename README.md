[1.x版本](./README_OLD.md) | 2.x版本

<p align="center"><img src="./img/logo.png" alt="Logo图片似乎加载不出来" height="360"/></p>
<h2 align="center">BasePopup - Android下打造通用便捷的PopupWindow</h2>

| **Release** | **Candy** | **License** | **Api** | **Author** |
| ---- | ---- | ---- | ---- | ---- |
| [![Download](https://api.bintray.com/packages/razerdp/maven/BasePopup/images/download.svg) ](https://bintray.com/razerdp/maven/BasePopup/_latestVersion) | [![Download](https://api.bintray.com/packages/razerdp/maven/BasePopup_Candy/images/download.svg) ](https://bintray.com/razerdp/maven/BasePopup_Candy/_latestVersion)| [![license](https://img.shields.io/badge/license-Apache--2.0-blue.svg )](https://github.com/razerdp/BasePopup/blob/master/LICENSE) | [![Api](https://img.shields.io/badge/Api-16%2B-green.svg)](https://img.shields.io/badge/Api-14%2B-green.svg) | [![Author](https://img.shields.io/badge/Author-razerdp-blue.svg)](https://github.com/razerdp) |

---

### 导航
 
 - [特性](#特性)
 - [注意事项](#注意事项)
 - [快速入门](#快速入门)
   - [依赖](#依赖)
   - 普通使用
     - 编写您的xml文件
     - 创建您的Popup类并继承BasePopupWindow
     - 补充对应方法
     - show！
   - QuickPopupBuilder链式调用
     - 示例代码
     - Api
   - Api（请看Wiki）
   - 更新日志[历史更新](./UpdateLog.md)
   - 例子预览
   - 打赏
   - 交流群
   - 常见问题
   - 贡献者们
   - 感谢
   - LICENSE
   
<br>
<br>

### 特性

 - 更简单更精准的控制显示位置，通过Gravity和offset来控制您的PopupWindow
 - 本库为抽象类，对子类几乎没有约束，您完全可以像定制Activity一样来定制您的PopupWindow
 - 支持Animation、Animator，随意控制您的PopupWindow的动画，再也不用去写蛋疼的xml了
 - 背景变暗、背景换色甚至背景给个Drawable都是一句话的事情
 - 背景模糊亦或是模糊背景某个具体的View也仅仅需要您一句话的配置
 - 返回键、点击外部是否Dismiss，外部是否可以响应事情三者分离，再也不用担心我的PopupWindow各种按键响应问题
   - 如果不满足默认的事件，没问题，我们还提供了事件传递，您的事件您来把握
 - 系统的坑？不，我们来把控，通过hook掉系统的windowmanager来由我们把握PopupWindow的各种事情，防止不同版本出现的各种适配问题
 - 支持链式调用，还在为简单的PopupWindow使用不得不继承库的抽象类而感到烦躁？不妨来试试QuickPopupBuilder，想必您会爱上它的

<br>
<br>

### 注意事项

**WARN：**
 
  - **请务必仔细阅读本README,每个版本升级请务必查阅更新日志，这可以为您减少不必要弯路**
  - **请注意引用版本的问题，Release版本是稳定版，Candy是预览版。**
    - Release版本：一般在Candy版本反复验证修复后发布到Release，如果您对稳定性要求较高，请使用Release版本。
    - Candy版本：一般新功能、issue修复都会发布到Candy版本，Candy版本发布比较频繁，但通常会拥有新的功能，如果您喜欢试验新功能同时对稳定性要求不高，请使用Candy版本。
    - **Release和Candy两个版本互相切换可能会导致Build失败，这时候您Clean一下Project即可**
  - **如果您是以前1.x版本的用户，现在想更新到2.x，请在更新前查阅：[1.x迁移到2.x帮助文档](https://github.com/razerdp/BasePopup/blob/master/1.x%E8%BF%81%E7%A7%BB2.x%E5%B8%AE%E5%8A%A9%E6%96%87%E6%A1%A3.md)**


>Android P已经适配，感谢[@Guolei1130](https://github.com/Guolei1130)收集的方法。<br><br>文章地址：[android_p_no_sdkapi_support](https://github.com/Guolei1130/android_p_no_sdkapi_support)<br><br>本库一开始采用360的方法，但不得不走Native，为了个Popup不得不引入so感觉很不值得，在看到这篇文章后，才想起UnSafe类，因此本库采用方法5。<br><br>如果以后UnSafe类移除掉的话，再考虑Native方法。<br><br><b>最后再一次感谢大牛提供的方法~</b>

<br>
<br>

### 快速入门
---
#### 依赖

| **Release** | **Candy** |
| ---- | ---- |
| [![Download](https://api.bintray.com/packages/razerdp/maven/BasePopup/images/download.svg) ](https://bintray.com/razerdp/maven/BasePopup/_latestVersion) | [![Download](https://api.bintray.com/packages/razerdp/maven/BasePopup_Candy/images/download.svg) ](https://bintray.com/razerdp/maven/BasePopup_Candy/_latestVersion) |


添加依赖到Gradle（请把<b>{$latestVersion}</b>替换成上面的Jcenter标签所示版本）

```xml
	dependencies {
	        implementation 'com.github.razerdp:BasePopup:{$latestVersion}'
	        
	        //candy版本
	        //implementation 'com.github.razerdp:BasePopup_Candy:{$latestVersion}'
	}
```
<br>

### 普通使用

#### 编写您的xml文件

像您平时定制View布局文件一样定制您的PopupWindow布局

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:layout_marginLeft="50dp"
    android:layout_marginRight="50dp"
    android:background="@android:color/holo_blue_dark"
    android:orientation="vertical"
    >

    <TextView
        android:id="@+id/tx_1"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:gravity="center"
        android:text="test1"
        android:textColor="@color/color_black1"/>

</LinearLayout>
```
<p align="left"><img src="https://github.com/razerdp/Pics/blob/59a2d5047eeb617d9d7a9a042c0d436b3103f0bb/BasePopup/%E7%BC%96%E5%86%99xml.png" height="360"/></p>

<br>

#### 创建您的Popup类并继承BasePopupWindow

```java
public class DemoPopup extends BasePopupWindow {
    public DemoPopup(Context context) {
        super(context);
    }

    @Override
    public View onCreateContentView() {
        return null;
    }
}
```

<br>

#### 补充对应方法

**强烈建议在`onCreateContentView()`里使用`createPopupById()`来进行inflate，这样本库才能正确的做出对应的解析和适配**

```java
public class DemoPopup extends BasePopupWindow {
    public DemoPopup(Context context) {
        super(context);
    }

    // 必须实现，这里返回您的contentView
    // 为了让库更加准确的做出适配，强烈建议使用createPopupById()进行inflate
    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_normal);
    }
    
    // 以下为可选代码（非必须实现）
    // 返回作用于PopupWindow的show和dismiss动画，本库提供了默认的几款动画，这里可以自由实现
    @Override
    protected Animation onCreateShowAnimation() {
        return getDefaultScaleAnimation(true);
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return getDefaultScaleAnimation(false);
    }
}
```

<br>

#### show！

展示PopupWindow的方法有两种，分别是`showPopupWindow()`和`showPopupWindow(View anchor)`：

```java
new DemoPopup(getContext()).showPopupWindow();
//new DemoPopup(getContext()).showPopupWindow(v);
```
<br>
这两个方法有不同的含义：
 - `showPopupWindow()`：无参传入，此时PopupWindow参考对象为屏幕（或者说整个DecorView），Gravity的表现就像在FrameLayout里面的Gravity表现一样，表示其处于屏幕的哪个方位
 - `showPopupWindow(View anchor)`：传入AnchorView，此时PopupWindow参考对象为传入的anchorView，Gravity的表现则意味着这个PopupWindow应该处于目标AnchorView的哪个方位
 
>建议：如果PopupWindow需要重复展示或者保留状态，建议作为成员变量使用，而不要作为局部变量每次都创建

例子展示：

 - `showPopupWindow()无参传入`

| gravity = CENTER<br>上述例子中xml写明了layout_gravity=center | gravity = BOTTOM | CENTER_HORIZONTAL | 
| - | - |
| ![](https://github.com/razerdp/Pics/blob/master/BasePopup/show_1.gif) | ![](https://github.com/razerdp/Pics/blob/master/BasePopup/show_2.gif) |

### 方法一
----

* **Step 1:**

像您平时定制activity布局文件一样定制您的popup布局

etc.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:layout_marginLeft="50dp"
    android:layout_marginRight="50dp"
    android:background="@android:color/holo_blue_dark"
    android:orientation="vertical"
    >

    <TextView
        android:id="@+id/tx_1"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:gravity="center"
        android:text="test1"
        android:textColor="@color/color_black1"/>

</LinearLayout>
```  
![image](https://github.com/razerdp/BasePopup/blob/master/img/etc.png) 


* **Step 2:**

新建一个类继承BasePopupWindow

* **Step 3:**

实现必要的几个方法：

**该方法从2.0.6开始不再抽象强制实现，但建议实现入场和退场动画** `onCreateShowAnimation()`/`onCreateDismissAnimation()`:初始化一个显示/退出动画，该动画将会用到`onCreatePopupView()`所返回的view,可以为空。

`onCreatePopupView()`:初始化您的popupwindow界面，建议直接使用`createPopupById()`


例如

```java
public class DialogPopup extends BasePopupWindow implements View.OnClickListener{

    private TextView ok;
    private TextView cancel;

    public DialogPopup(Activity context) {
        super(context);

        ok= (TextView) findViewById(R.id.ok);
        cancel= (TextView) findViewById(R.id.cancel);

        setViewClickListener(this,ok,cancel);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        AnimationSet set=new AnimationSet(false);
        Animation shakeAnima=new RotateAnimation(0,15,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        shakeAnima.setInterpolator(new CycleInterpolator(5));
        shakeAnima.setDuration(400);
        set.addAnimation(getDefaultAlphaAnimation());
        set.addAnimation(shakeAnima);
        return set;
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return null;
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_dialog);
    }

    @Override
    public void onClick(View v) {
        //... click event
    }
}
```

* **Step 4:**

把您刚才实现的popup给new出来并调用show方法

例如

```java
    DialogPopup popup = new DialogPopup(context);
    popup.showPopupWindow();
```

----

### 方法二
----
如果您并不需要很详细的定义一个PopupWindow，您也可以选择`QuickPopupBuilder`采取链式写法快速编写出一个Popup以使用。

```java
    QuickPopupBuilder.with(getContext())
                     .contentView(R.layout.popup_menu_small)
                     .wrapContentMode()
                     .config(new QuickPopupConfig()
                                .withShowAnimation(enterAnimation)
                                .withDismissAnimation(dismissAnimation)
                                .offsetX(offsetX, offsetRatioOfPopupWidth)
                                .offsetY(offsetY, offsetRatioOfPopupHeight)
                                .blurBackground(true, new BasePopupWindow.OnBlurOptionInitListener() {
                                    @Override
                                    public void onCreateBlurOption(PopupBlurOption option) {
                                        option.setBlurRadius(6)
                                                .setBlurPreScaleRatio(0.9f);
                                    }
                                })
                                .withClick(R.id.tx_1, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        ToastUtils.ToastMessage(getContext(), "tx1");
                                    }
                                }))
                     .show(v);
````





**ps:从1.9.0-alpha开始支持背景模糊（只需要一个方法：`setBlurBackgroundEnable()`）**

**RenderScript最低支持api 17（更低的情况将会使用fastblur），您需要在gradle配置一下代码**

```xml
defaultConfig {
        renderscriptTargetApi 25
        renderscriptSupportModeEnabled true
    }
```

方法介绍：
---

请看wiki（陆续完善中）

**Link👉**[WIKI](https://github.com/razerdp/BasePopup/wiki)

交流群：590777418
---

因为目前还有朋友圈项目，建立了一个交流群，出于懒得管理那么多，所以如果有想法或者优化建议或者其他问题，欢迎加入“朋友圈交流群”

![](https://github.com/razerdp/FriendCircle/blob/master/qqgroup.png)

打赏（看在我那么努力维护的份上。。。给个零食呗~）
---

| 微信 |支付宝 | 
| ---- | ---- | 
| ![](https://github.com/razerdp/FriendCircle/blob/master/wechat.png)      | ![](https://github.com/razerdp/FriendCircle/blob/master/alipay.png) |




更新日志([历史更新](https://github.com/razerdp/BasePopup/blob/master/UpdateLog.md))
----------------------------------------

* **【Release】2.0.8.1**(2018/10/29)
  * **建议更新到这个版本！**
  * fixed [#94](https://github.com/razerdp/BasePopup/issues/94)
  * 紧急修复一个严重的bug[#95](https://github.com/razerdp/BasePopup/issues/95)，感谢[@tpnet](https://github.com/tpnet)
  * 优化代码

* **【Release】2.0.8**(2018/10/29)
  * fixed [#93](https://github.com/razerdp/BasePopup/issues/93)
  * 修复部分崩溃问题，发布release

* **【Candy】2.0.8-alpha3**(2018/10/25)
  * fixed [#87](https://github.com/razerdp/BasePopup/issues/87)、[#89](https://github.com/razerdp/BasePopup/issues/89)、[#90](https://github.com/razerdp/BasePopup/issues/90)

* **【Candy】2.0.8-alpha2**(2018/10/19)
  * 修复QuickPopupBuilder的click事件无响应问题，增加background方法
  * 修复设置background(0)时无法找到资源而崩溃的问题

* **【Release】2.0.7**(2018/10/15)
  * 绕开Android P的非公开api方法反射
    * 思路参考&&感谢[android_p_no_sdkapi_support](https://github.com/Guolei1130/android_p_no_sdkapi_support)
  * 发布2.0.7 release
    
  
* **【Release】2.0.6**(2018/10/09)
  * 不再抽象强制实现入场和退场动画
  * 针对自动弹出输入法的Popup，在dismiss()中默认关闭输入法


一些例子
---

| 对应popup | 预览 |
| :---- | ---- |
| [LocatePopupFrag.java](https://github.com/razerdp/BasePopup/blob/master/app/src/main/java/razerdp/demo/fragment/LocatePopupFrag.java)     | ![image](https://github.com/razerdp/BasePopup/blob/master/img/locate_popup.gif) |
| [BlurSlideFromBottomPopup.java](https://github.com/razerdp/BasePopup/blob/master/app/src/main/java/razerdp/demo/popup/BlurSlideFromBottomPopup.java)     | ![image](https://github.com/razerdp/BasePopup/blob/master/img/blur_popup.gif) |
| [CommentPopup.java](https://github.com/razerdp/BasePopup/blob/master/app/src/main/java/razerdp/demo/popup/CommentPopup.java)     | ![image](https://github.com/razerdp/BasePopup/blob/master/img/comment_popup_with_exitAnima.gif) |
| [ScalePopup.java](https://github.com/razerdp/BasePopup/blob/master/app/src/main/java/razerdp/demo/popup/ScalePopup.java)     | ![image](https://github.com/razerdp/BasePopup/blob/master/img/scale_popup.gif) |
| [SlideFromBottomPopup.java](https://github.com/razerdp/BasePopup/blob/master/app/src/main/java/razerdp/demo/popup/SlideFromBottomPopup.java)     | ![image](https://github.com/razerdp/BasePopup/blob/master/img/slide_from_bottom_popup.gif) |
| [InputPopup.java](https://github.com/razerdp/BasePopup/blob/master/app/src/main/java/razerdp/demo/popup/InputPopup.java)     | ![image](https://github.com/razerdp/BasePopup/blob/master/img/input_popup.gif) |
| [ListPopup.java](https://github.com/razerdp/BasePopup/blob/master/app/src/main/java/razerdp/demo/popup/ListPopup.java)     | ![image](https://github.com/razerdp/BasePopup/blob/master/img/list_popup.gif) |
| [MenuPopup.java](https://github.com/razerdp/BasePopup/blob/master/app/src/main/java/razerdp/demo/popup/MenuPopup.java)     | ![image](https://github.com/razerdp/BasePopup/blob/master/img/menu_popup.gif) |


License
---

Apache-2.0
