package com.ww.host.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment

/**
 * time：2022/10/19 下午3:43
 * author： WeiWei
 * description：
 **/
class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


    fun closeKeyBoard(c: Context, et: EditText) {
        try {
            val e = c.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            e.hideSoftInputFromWindow(et.windowToken, 0)
        } catch (var3: Exception) {
            Log.e("e:", var3.message!!)
        }
    }

    fun showKeyBoard(c: Context, et: EditText?) {
        try {
            val e = c.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            e.showSoftInput(et, 2)
        } catch (var3: Exception) {
            Log.e("e:", var3.message!!)
        }
    }

}