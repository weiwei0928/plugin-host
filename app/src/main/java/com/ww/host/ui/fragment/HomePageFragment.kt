package com.ww.host.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ww.host.R
import com.ww.host.extension.logD
import com.ww.host.ui.TestPluginActivity
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * time：2022/10/19 下午3:38
 * author： WeiWei
 * description：
 **/
class HomePageFragment: Fragment() {
    companion object {
        private const val TAG = "HomePageFragment"
        fun newInstance() = HomePageFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    private fun testPlugin() {
        val intent = Intent(context, TestPluginActivity::class.java)
        startActivity(intent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logD(TAG, "onViewCreated: ")
        btn_plugin_test.setOnClickListener {
            testPlugin()
        }
    }
}