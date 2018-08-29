package com.easy.gankkt

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.easy.gankkt.utils.XLog

/**
 * @package: com.easy.gankkt
 * @fileNmae BaseGankActivity
 * @date 2018/8/29 10:23
 * @author fuyujie
 * @describe
 * @org easylinking
 * @email f279259625@gmail.com
 */
abstract class BaseGankActivity : AppCompatActivity() {

    /**
     * tag
     */
    private val TAG = this.javaClass.simpleName

    var sSavedInstanceState: Bundle? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sSavedInstanceState = savedInstanceState;
        setContentView(setLayout());
        if (getIntentData()) {
            if (initDate()) {
                if (initView()) {
                    if (initCustomFunction()) {
                        bindEvent();
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        XLog.eLine();
        XLog.e("showing Activity Name:${TAG}")
    }

    override fun onDestroy() {
        super.onDestroy()
        destoryPre();
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            val v = this.currentFocus
            if (this.isShouldHideInput(v, ev) && v != null) {
                v.clearFocus()
                val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm?.hideSoftInputFromWindow(v.windowToken, 0)
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    fun getSavedInstanceState(): Bundle? {
        return sSavedInstanceState;
    }

    fun getActivity(): AppCompatActivity {
        return this;
    }

    /**
     * 是否隐藏键盘
     *
     * @param v     view
     * @param event 时间
     * @return 是否
     */
    fun isShouldHideInput(v: View?, event: MotionEvent): Boolean {
        if (v != null && v is EditText) {
            val leftTop = intArrayOf(0, 0)
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop)
            val left = leftTop[0]
            val top = leftTop[1]
            val bottom = top + v.height
            val right = left + v.width
            return !(event.x > left && event.x < right
                    && event.y > top && event.y < bottom)
        }
        return false
    }

    /**
     * 设置layout
     */
    protected abstract fun setLayout(): Int;

    /**
     * 销毁p
     */
    protected abstract fun destoryPre();

    /**
     * 获取Intent中的数据
     * 返回true表示中断接下来的操作
     */
    protected abstract fun getIntentData(): Boolean;

    /**
     * 初始化数据
     * 返回true表示中断接下来的操作
     */
    protected abstract fun initDate(): Boolean;

    /**
     * 初始化view
     * 返回true表示中断接下来的操作
     */
    protected abstract fun initView(): Boolean;

    /**
     * 初始化事件
     * 返回true表示中断接下来的操作
     */
    protected abstract fun initCustomFunction(): Boolean;

    /**
     * 绑定事件
     * 返回true表示中断接下来的操作
     */
    protected abstract fun bindEvent(): Boolean;

}