## 介绍

### 功能说明

## 如何集成

**步骤1**

在项目（最外层Project）的``build.gradle``中加入``maven("http://xxx")``，如下：
```gradle
allprojects {
    repositories {
        jcenter()
        maven("http://xxxx")
    }
}
```
**步骤2**

在Module的``build.gradle``引用
```gradle
compile 'com.rongpay:pay:{last version}'
```
## 如何使用

**初始化**

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

* 整个工程中包含了Sample，可以更好的了解如何集成，每个功能的使用。
* [使用说明.pdf](./使用说明.pdf)

## 联系我们