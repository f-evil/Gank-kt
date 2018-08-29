package com.easy.gankkt.mvp;

import com.easy.gankkt.mvp.base.BaseMVPModel;
import com.lzy.okgo.OkGo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuyujie
 * @package: com.easy.gankkt.mvp.base;
 * @filrNmae BaseMVPModel
 * @date 2017/8/31 12:00
 * @describe
 * @org easylinking
 * @email f279259625@gmail.com
 */
public abstract class BaseModel extends BaseMVPModel {

    /**
     * 请求任务列表
     */
    private List<String> mTask;


    public BaseModel() {
        if (mTask != null) {
            mTask = new ArrayList<>();
        }
    }

    @Override
    public void onDetach() {
        if (mTask != null) {
            for (String tag : mTask) {
                OkGo.cancelTag(OkGo.getInstance().getOkHttpClient(), tag);
            }
        }
    }

    protected void addNetTag(String tag) {
        if (mTask == null) {
            mTask = new ArrayList<>();
        }
        mTask.add(tag);
    }
}
