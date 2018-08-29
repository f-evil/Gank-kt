package com.easy.gankkt

class MainActivity : BaseGankActivity() {
    override fun setLayout(): Int {
        return R.layout.activity_main;
    }

    override fun destoryPre() {

    }

    override fun getIntentData(): Boolean {

        return true;
    }

    override fun initDate(): Boolean {
        
        return true;
    }

    override fun initView(): Boolean {
        return true;
    }

    override fun initCustomFunction(): Boolean {
        return true;
    }

    override fun bindEvent(): Boolean {
        return true;
    }

}
