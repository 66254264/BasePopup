 **中文** | [**English**](./README_V2_EN.md)

<p align="center"><img src="./img/logo.png" alt="Logo图片似乎加载不出来" height="360"/></p>
<h2 align="center">BasePopup - Android下打造通用便捷的PopupWindow</h2>
<div align="center">
<table>
        <tr>
            <th>Release</th>
            <th>Candy</th>
            <th>License</th>
			<th>Api</th>
			<th>Author</th>
        </tr>
        <tr>
            <td align="center">
				<a href ="https://bintray.com/razerdp/maven/BasePopup/_latestVersion">
					<img src="https://api.bintray.com/packages/razerdp/maven/BasePopup/images/download.svg"/>
				</a>
			</td>
			<td align="center">
				<a href = "https://bintray.com/razerdp/maven/BasePopup_Candy/_latestVersion">
					<img src="https://api.bintray.com/packages/razerdp/maven/BasePopup_Candy/images/download.svg"/>
				</a>
			</td>
			<td align="center">
				<a href = "https://github.com/razerdp/BasePopup/blob/master/LICENSE">
					<img src="https://img.shields.io/badge/license-Apache--2.0-blue.svg"/>		
				</a>
				<br></br>
				<a href = "https://github.com/razerdp/BasePopup/blob/master/LICENSE_996">
                	<img src="https://img.shields.io/badge/license-Anti%20996-blue.svg?style=flat-square"/>
                </a>
			</td>
			<td align="center">
				<a href="https://img.shields.io/badge/Api-14%2B-green.svg">
					<img src="https://img.shields.io/badge/Api-16%2B-green.svg"/>
				</a>
			</td>
			<td align="center">
				<a href = "https://github.com/razerdp">
					<img src="https://img.shields.io/badge/Author-razerdp-blue.svg"/>
				</a>
			</td>
		</tr>
		<tr>
			<td rowspan="3" align="center">Compat组件</td>
			<td align="center"></td>
			<td align="center">support（已终止迭代）</td>
			<td align="center">lifecycle（已终止迭代）</td>
			<td align="center">androidx</td>
			<tr>
			<td align="center">Release</td>
			<td align="center">
				<a href = "https://bintray.com/razerdp/maven/BasePopup-compat-support/_latestVersion">
                	<img src="https://api.bintray.com/packages/razerdp/maven/BasePopup-compat-support/images/download.svg"/>		
                </a>
            </td>
			<td align="center">
				<a href = "https://bintray.com/razerdp/maven/BasePopup-compat-lifecycle/_latestVersion">
                	<img src="https://api.bintray.com/packages/razerdp/maven/BasePopup-compat-lifecycle/images/download.svg"/>		
                </a>
			</td>
			<td align="center">
				<a href = "https://bintray.com/razerdp/maven/BasePopup-compat-androidx/_latestVersion">
                	<img src="https://api.bintray.com/packages/razerdp/maven/BasePopup-compat-androidx/images/download.svg"/>		
                </a>
			</td>
			</tr>
			<tr>
			<td align="center">Candy</td>
			<td align="center">
				<a href = "https://bintray.com/razerdp/maven/BasePopup_Candy-compat-support/_latestVersion">
                	<img src="https://api.bintray.com/packages/razerdp/maven/BasePopup_Candy-compat-support/images/download.svg"/>		
                </a>
			</td>
			<td align="center">
				<a href = "https://bintray.com/razerdp/maven/BasePopup_Candy-compat-lifecycle/_latestVersion">
                	<img src="https://api.bintray.com/packages/razerdp/maven/BasePopup_Candy-compat-lifecycle/images/download.svg"/>		
                </a>
			</td>
			<td align="center">
				<a href = "https://bintray.com/razerdp/maven/BasePopup_Candy-compat-androidx/_latestVersion">
                	<img src="https://api.bintray.com/packages/razerdp/maven/BasePopup_Candy-compat-androidx/images/download.svg"/>		
                </a>
			</td>
		</tr>
			
</table>



</div>

---

### 导航
 
 - [特性](#特性)
 - [文章分享](https://github.com/razerdp/Article/blob/master/%E4%BA%B2%EF%BC%8C%E8%BF%98%E5%9C%A8%E4%B8%BAPopupWindow%E7%83%A6%E6%81%BC%E5%90%97.md)
 - [注意事项](#注意事项)
 - [环境依赖](#环境依赖)
 - [快速入门](#快速入门)
 - [混淆](#混淆)
 - [Api（请看Wiki）](#api请看wiki)
 - [更新日志](#更新日志-历史更新)
   - [历史更新](./UpdateLog.md)
 - [例子预览](#例子预览)
 - [打赏](#打赏看在我那么努力维护的份上给个零食呗)
 - [交流群](#交流群)
 - [常见问题](#常见问题)
 - [LICENSE](#license)
   
<br>
<br>

### 特性

 - 更简单更精准的控制显示位置，通过[**Gravity**](https://github.com/razerdp/BasePopup/wiki/API#setpopupgravityint-popupgravity)和[**offset**](https://github.com/razerdp/BasePopup/wiki/API#setoffsetxint-offsetx)来控制您的PopupWindow
 - 本库为抽象类，对子类几乎没有约束，您完全可以像定制Activity一样来定制您的PopupWindow
 - 支持[**Animation**](https://github.com/razerdp/BasePopup/wiki/API#setshowanimationanimation-showanimation)、[**Animator**](https://github.com/razerdp/BasePopup/wiki/API#setshowanimatoranimator-showanimator)，随意控制您的PopupWindow的动画，再也不用去写蛋疼的xml了
 - 顺滑的背景定制，支持[**背景模糊**](https://github.com/razerdp/BasePopup/wiki/API#setblurbackgroundenableboolean-blurbackgroundenable)或[**局部模糊**](https://github.com/razerdp/BasePopup/wiki/API#setbluroptionpopupbluroption-option)，[**展开变暗**](https://github.com/razerdp/BasePopup/wiki/API#setbackgroundcolorint-color)或者修改颜色甚至是贴图，这一切仅仅需要您通过一句Api完成
 - 不再担心PopupWindow蛋疼的事件拦截，[**返回键控制**](https://github.com/razerdp/BasePopup/wiki/API#setbackpressenableboolean-backpressenable)、[**点击外部Dismiss控制**](https://github.com/razerdp/BasePopup/wiki/API#setallowdismisswhentouchoutsideboolean-dismisswhentouchoutside)、[**外部事件响应控制**](https://github.com/razerdp/BasePopup/wiki/API#setallowintercepttoucheventboolean-touchable)三者分离
 - PopupWindow自动锚定AnchorView，滑动到屏幕外自动跟随AnchorView消失，不需要复杂的逻辑设置，只需要通过[**Link**](https://github.com/razerdp/BasePopup/wiki/API#linktoview-anchorview)方法告诉BasePopup
 - 简单的PopupWindow不想新建一个类，希望拥有链式调用？没问题，[**QuickPopupBuilder**](https://github.com/razerdp/BasePopup/wiki/API#QuickPopupBuilder)为此而生，相信你会越用越爱~

<br>

### 注意事项

  - **请务必仔细阅读本README,每个版本升级请务必查阅更新日志，这可以为您减少不必要弯路**
  - **请注意引用版本的问题，Release版本是稳定版，Candy是预览版。**
    - Release版本：一般在Candy版本反复验证修复后发布到Release，如果您对稳定性要求较高，请使用Release版本。
    - Candy版本：一般新功能、issue修复都会发布到Candy版本，Candy版本发布比较频繁，但通常会拥有新的功能，如果您喜欢试验新功能同时对稳定性要求不高，请使用Candy版本。
    - **Release和Candy两个版本互相切换可能会导致Build失败，这时候您Clean一下Project即可**
  - **如果您是以前1.x版本的用户，现在想更新到2.x，请在更新前查阅：[1.x迁移到2.x帮助文档](https://github.com/razerdp/BasePopup/blob/master/1.x%E8%BF%81%E7%A7%BB2.x%E5%B8%AE%E5%8A%A9%E6%96%87%E6%A1%A3.md)**
  - 从16年[**第一次**](https://github.com/razerdp/BasePopup/commit/c92b7088270d5757269d9b79213627a4a0392d31)提交到现在，本人技术也一直在进步，BasePopup也会一直迭代更新，所以，请谨慎选择版本哦~一不小心就颠覆了之前的实现。

<br>

### 环境依赖

请把下述 **{$latestVersion}** 替换为上面表格中对应的版本。

**自2.2.2版本开始，BasePopup将不再支持support**，同时BasePopup建议您尽早迁移到AndroidX

 - **Release：**
   - 基础库（必选）：**`implementation 'com.github.razerdp:BasePopup:{$latestVersion}'`**
   - androidx支持库（可选）：**`implementation 'com.github.razerdp:BasePopup-compat-androidx:{$latestVersion}'`**

 - **Candy**
    - 基础库（必选）：**`implementation 'com.github.razerdp:BasePopup_Candy:{$latestVersion}'`**
    - androidx支持库（可选）：**`implementation 'com.github.razerdp:BasePopup_Candy-compat-androidx:{$latestVersion}'`**

<br>

### 快速入门

请参考文档：[**BasePopup手册**](https://www.kancloud.cn/razerdp/basepopup/content)


<br>

### 混淆

理论上库自带继承的混淆，如果发现组件不可用，可以自行添加以下混淆：

```xml
-keep class * implements razerdp.basepopup.BasePopupComponent
```
<br>

### Api（请看Wiki，后续迁移至文档）

**Link👉**[WIKI](https://github.com/razerdp/BasePopup/wiki)

<br>


### 更新日志 ([历史更新](https://github.com/razerdp/BasePopup/blob/master/UpdateLog.md))

* **近期正在重构BasePopup，旨在代码更容易读，因此近期更新可能较慢，新版本将会对issue统一处理**

* **【里程碑】2.2.2**
    * **【Candy】2.2.2.200203 ** 2020/02/03
      * 重构onCreate中弹出的方案
      * 解决一些检查到的内存泄漏
      * 去除`limitScreen()`方法
      * 重构DecorViewProxy，现在不再需要我来适配宽高了，由系统完成，以此解决各种蛋疼的适配问题
      * 优化Measure方法，当BasePopup显示跟Anchor关联时，如果宽或者高为match_parent，将会填满剩余可用空间
      * 解决Android 10黑/灰名单的问题
      * 即将发布正式版

* **【Candy】2.2.2**
    * **【Candy】190704**
      * 修复AnimatorSet的时间问题 fix [**#203**](https://github.com/razerdp/BasePopup/issues/203)
    * **【Candy】190722**
      * 回滚[#188](https://github.com/razerdp/BasePopup/issues/188)修复
      * 经检查，[#188](https://github.com/razerdp/BasePopup/issues/188)修复带来的问题比较严重，建议升级到该版本
    * **【Candy】190816**
      * 考虑到很多用户提出全面屏会有蒙层无法填充的问题，因此增加`setMaskLayoutWidth`和`setMaskLayoutHeight`方法，该方法允许您自定义蒙层的高度
      * 开始重构BasePopupWindow，本次重构将会解决遗留问题同时缩减冗余代码，并提高代码可读性
    * **【Candy】190904**
      * 重构屏幕宽高获取逻辑
      * 修改supporter名字为component
    * **【Candy】190912**
      * 重构键盘逻辑，现在键盘对齐支持选择模式了~
      * 相关文档请查阅文档 [**键盘（输入法）**](https://www.kancloud.cn/razerdp/basepopup/1277045)
    * **2019/09/20**
      * Demo大翻新
    * **2019/09/22**
      * 增加输入法Demo
      * Demo支持更新
      * Demo增加issue修复测试用例
    * **2019/09/26**
      * 取消对support的支持
    * **2019/09/27**
      * 增加手势导航栏支持
    * **2019/09/29**
      * 发布新版candy
    * **2019/10/09**
      * 添加issue #230测试用例
    * **2019/10/31**
      * 优化autoLocate
      * 优化超出屏幕的位移问题
      * 添加setResize()方法
      * 添加onAutoLocationChange()方法

* **【Release】2.2.1**(2019/06/24)
  * 支持Service或者非ActivityContext里弹窗
  * 优化PopupUiUtils，优化获取屏幕宽高算法
    * fixed [**#186**](https://github.com/razerdp/BasePopup/issues/186)、[**#167**](https://github.com/razerdp/BasePopup/issues/167)
    * fixed [**#188**](https://github.com/razerdp/BasePopup/issues/188)(not perfect)
  * 修改并优化键盘判断逻辑
  * 优化全屏状态下点击范围的判定，fixed [**#200**](https://github.com/razerdp/BasePopup/issues/200)

<br>

### 例子预览

<br>

#### 更多例子请下载Demo：[**apk体验下载**](https://fir.im/pfc9)

<br>

|  |  |
| - | - |
| ![](https://github.com/razerdp/Pics/blob/master/BasePopup/demo_1.gif) | ![](https://github.com/razerdp/Pics/blob/master/BasePopup/demo_2.gif) |
| ![](https://github.com/razerdp/Pics/blob/master/BasePopup/demo_3.gif) | ![](https://github.com/razerdp/Pics/blob/master/BasePopup/demo_4.gif) |
| ![](https://github.com/razerdp/Pics/blob/master/BasePopup/demo_5.gif) | Coming soon |

<br>


### 打赏（看在我那么努力维护的份上。。。给个零食呗~）

|支付宝 |
| ---- |
| ![](https://github.com/razerdp/BasePopup/blob/master/img/alipay.png) |

<br>

### 交流群

因QQ没时间管理，因此解散，同时开通微信群，主要用于交流和BasePopup的反馈，为了保证微信群的质量，因此只有打赏了之后才能进群~

<br>

### 常见问题

请查阅[**手册：常见问题**](https://www.kancloud.cn/razerdp/basepopup/1277047)

<br>

### License

[Apache-2.0](./LICENSE)
