## 介绍
钱包收银台SDK
## SDK的集成及使用

### 集成

**步骤1**

在项目（最外层Project）的``build.gradle``中加入``maven { url "https://dl.bintray.com/rongwallet/maven/" }``，如下：
```gradle
allprojects {
    repositories {
        jcenter()
        maven { url "https://dl.bintray.com/rongwallet/maven/" }
    }
}
```
**步骤2**

在Module的``build.gradle``引用
```gradle
compile 'com.rongcapital:rongpay:0.0.1'
```
### 初始化

```java
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RongSdk.initial(this);
    }
}
```
> 需要在Application中初始化，不要在Activity中初始化。

### 日志
1. 在调用``RongSdk.initial(this);``后，会打印当前SDK的版本，如下：
```
D/RongSdk: RongSdk Version : 1.0
```
2. 涉及网络部分出错会有Error级别的Log输出。

## 功能说明
1.  收银台
### 使用收银台

**01:调用收银台**

```
RongSdk.receipt(MainActivity.this, "青橙科技订单", "健身房费用", DateUtils.getCurrentDataString(), 1L);
```

>参数说明：
```
    /**
     * @param context activity
     * @param title 订单标题
     * @param details 订单详情
     * @param orderId 订单ID
     * @param amount 订单金额，单位分
     */
```
**02:在``onActivityResult``中接收回调**
```
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == Constants.RECEIPT_ACTION) {
            Log.d("main/" + data.getStringExtra("data"));
        }
    }
```
> requestCode == Constants.RECEIPT_ACTION,不能修改，Constants.RECEIPT_ACTION=1001
> 返回data,getStringExtra("data")是Json格式的String（例如：{"orderId":"20170717094654",
"tradeFlowId":"20170717094707100001104961","amount":1,"payTime":"20170717094710",
"tradeType":5,"payType":20}）
```
    /**
     * @param orderId 外部传入的订单id
     * @param tradeFlowId 交易流水id
     * @param amount 订单金额，单位分
     * @param payTime 交易时间
     * @param tradeType 交易类型 5- 刷卡支付 10-扫码支付
     * @param payType 支付类型 10-微信 20-支付宝 30-QQ钱包
     */
```
## ProGuard
如果项目使用了混淆，请加入如下代码：
```
-dontwarn com.rongcapital.sdk.ui.view.**
-keep class com.rongcapital.sdk.ui.** { *; }

-dontwarn okio.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }
# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}
-keep class com.google.zxing.client.android.camera.open.**
-keep class com.google.zxing.client.android.common.executor.**
```



## 更多
> 下载整个工程了解更多
* 快速体验：下载[demo.apk](./demo.apk)
* 查看Sample，可以更好的了解如何集成，每个功能的使用。
* 离线版说明文档：[使用说明.pdf](./使用说明.pdf)

## 联系我们
QQ: 565451174

email: wangliangliang@rongcapital.cn