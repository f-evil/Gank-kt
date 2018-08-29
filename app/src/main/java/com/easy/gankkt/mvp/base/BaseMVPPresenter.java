package com.easy.gankkt.mvp.base;

import com.easy.gankkt.mvp.BaseModel;
import com.easy.gankkt.mvp.BaseView;

import java.lang.ref.WeakReference;

/**
 * @author fuyujie
 * @package: com.easy.gankkt.mvp.base;
 * @filrNmae BaseMVPModel
 * @date 2017/8/31 12:00
 * @describe
 * @org easylinking
 * @email f279259625@gmail.com
 */
public abstract class BaseMVPPresenter<V extends BaseView, M extends BaseModel> {

    /**
     * view弱引用
     */
    protected WeakReference<V> mVReference;

    /**
     * 数据层
     */
    protected M mModel;

    /**
     * 实例化数据层
     */
    protected abstract M initModel();

    /**
     * 依附界面
     */
    public abstract void attach(V view);

    /**
     * 解除界面
     */
    public abstract void detach();

    /**
     * 获取数据层
     */
    protected M getModel() {
        return mModel;
    }

    /**
     * 获取获取view
     *
     * @return
     */
    protected V getView() {
        if (mVReference == null || mVReference.get() == null) {
            return null;
        }
        return mVReference.get();
    }


}
