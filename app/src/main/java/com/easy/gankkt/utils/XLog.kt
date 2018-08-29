package com.easy.gankkt.utils

import android.util.Log
import java.io.PrintWriter
import java.io.StringWriter

/**
 * @package: com.easy.gankkt.utils
 * @fileNmae XLog
 * @date 2018/8/29 11:22
 * @author fuyujie
 * @describe
 * @org easylinking
 * @email f279259625@gmail.com
 */
object  XLog {
    private val TAG = "XLog"
    private var LEVEL = 6
    private val V = 1
    private val D = 2
    private val I = 3
    private val W = 4
    private val E = 5

    fun closeLog() {
        LEVEL = 0
    }

    fun openLog() {
        LEVEL = 6
    }

    fun v(msg: String) {
        v("XLog", msg)
    }

    fun v(TAG: String, msg: String?) {
        var msg = msg
        if (msg == null || msg.isEmpty()) {
            msg = "data is null"
        }

        if (LEVEL >= 1) {
            Log.v(TAG, msg)
        }

    }

    fun d(msg: String) {
        d("XLog", msg)
    }

    fun d(TAG: String, msg: String?) {
        var msg = msg
        if (msg == null || msg.isEmpty()) {
            msg = "data is null"
        }

        if (LEVEL >= 2) {
            Log.d(TAG, msg)
        }

    }

    fun i(msg: String) {
        i("XLog", msg)
    }

    fun i(TAG: String, msg: String?) {
        var msg = msg
        if (msg == null || msg.isEmpty()) {
            msg = "data is null"
        }

        if (LEVEL >= 3) {
            Log.i(TAG, msg)
        }

    }

    fun w(msg: String) {
        w("XLog", msg)
    }

    fun w(TAG: String, msg: String?) {
        var msg = msg
        if (msg == null || msg.isEmpty()) {
            msg = "data is null"
        }

        if (LEVEL >= 4) {
            Log.w(TAG, msg)
        }

    }

    fun e(msg: String) {
        e("XLog", msg)
    }

    fun e(msg: Int) {
        e("XLog", msg)
    }

    fun eLine() {
        e("XLog", "================================")
    }

    fun e(msg: Boolean) {
        e("XLog", msg)
    }

    fun e(TAG: String, msg: String?) {
        var msg = msg
        if (msg == null) {
            msg = "data is null"
        } else if (msg.isEmpty()) {
            msg = "data is \" \""
        }

        if (LEVEL >= 5) {
            Log.e(TAG, msg)
        }

    }

    fun e(TAG: String, msg: Int) {
        if (LEVEL >= 5) {
            Log.e(TAG, msg.toString() + "")
        }

    }

    fun e(TAG: String, msg: Boolean) {
        if (LEVEL >= 5) {
            Log.e(TAG, msg.toString() + "")
        }

    }

    fun e(TAG: String, msg: String, tr: Throwable) {
        if (LEVEL >= 5) {
            Log.e(TAG, msg, tr)
        }

    }

    fun e(TAG: String, msg: Float) {
        if (LEVEL >= 5) {
            Log.e(TAG, msg.toString() + "")
        }

    }

    fun e(e: Exception) {
        if (LEVEL >= 5) {
            val sw = StringWriter()
            val pw = PrintWriter(sw)
            e.printStackTrace(pw)
            e(sw.toString())
        }

    }

    fun e(e: Throwable) {
        if (LEVEL >= 5) {
            val var1 = e.stackTrace
            val var2 = var1.size

            for (var3 in 0 until var2) {
                val element = var1[var3]
                Log.e("XLog", "======>>>>>>>>>>>>ClassName:" + element.className + "\nMethodName:" + element.methodName + "\nLineNumber:" + element.lineNumber + "\n")
            }
        }

    }

    fun e(TAG: String, e: Exception) {
        if (LEVEL >= 5) {
            val stackTrace = e.stackTrace
            eLine()
            Log.e(TAG, e.localizedMessage)
            if (stackTrace.size > 3) {
                for (i in 0..2) {
                    val element = stackTrace[i]
                    Log.e(TAG, "-----name----->" + element.className)
                    Log.e(TAG, "-----medthod----->" + element.methodName)
                    Log.e(TAG, "-----num----->" + element.lineNumber)
                }
            }

            eLine()
        }

    }

    @JvmStatic
    fun e(params: Array<String>) {
        if (LEVEL >= 5 && params != null) {
            eLine()
            val var2 = params.size

            for (var3 in 0 until var2) {
                val s = params[var3]
                e(s)
            }

            eLine()
        }

    }
}