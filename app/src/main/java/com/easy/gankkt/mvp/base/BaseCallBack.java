package com.easy.gankkt.mvp.base;


/**
 * @author fuyujie
 * @package: com.easy.gankkt.mvp.base;
 * @filrNmae BaseMVPModel
 * @date 2017/8/31 12:00
 * @describe
 * @org easylinking
 * @email f279259625@gmail.com
 */
public interface BaseCallBack<T> {

    void onSuccessed(T data);

    void onError(int code, String errorMsg);
}
