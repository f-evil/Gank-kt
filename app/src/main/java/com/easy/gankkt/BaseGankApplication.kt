package com.easy.gankkt

import android.content.Context
import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatActivity
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheEntity
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.cookie.CookieJarImpl
import com.lzy.okgo.cookie.store.DBCookieStore
import com.lzy.okgo.https.HttpsUtils
import com.lzy.okgo.interceptor.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import java.lang.ref.SoftReference
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * @package: com.easy.gankkt
 * @fileNmae BaseGankApplication
 * @date 2018/8/29 10:29
 * @author fuyujie
 * @describe
 * @org easylinking
 * @email f279259625@gmail.com
 */
class BaseGankApplication : MultiDexApplication() {

    public val sActivitys: Stack<AppCompatActivity> = Stack();

    companion object {
        lateinit var sContext: SoftReference<Context>;
    }

    override fun onCreate() {
        super.onCreate()
        sContext = SoftReference<Context>(applicationContext);
        initHttp();
    }

    private fun initHttp() {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder();
        val loggingInterceptor = HttpLoggingInterceptor("Gank");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        loggingInterceptor.setColorLevel(Level.WARNING);

        builder.addInterceptor(loggingInterceptor);
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.cookieJar(CookieJarImpl(DBCookieStore(this)));

        val sslParams = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);

        OkGo.getInstance().init(this)
                .setOkHttpClient(builder.build())
                .setCacheMode(CacheMode.NO_CACHE)
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .setRetryCount(3);

    }


}