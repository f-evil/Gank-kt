package com.easy.gankkt.mvp;

import com.easy.gankkt.mvp.base.BaseMVPPresenter;

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
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> extends BaseMVPPresenter<V, M> {

    @Override
    public void attach(V view) {
        if (mVReference == null) {
            mVReference = new WeakReference<>(view);
        }
        if (mModel == null) {
            mModel = initModel();
        }
    }

    @Override
    public void detach() {
        if (mVReference != null) {
            mVReference.clear();
            mVReference = null;
        }
        if (getModel() != null) {
            getModel().onDetach();
        }
    }
}
