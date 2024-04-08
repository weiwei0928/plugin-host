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
import zeus.plugin.PluginManager

/**
 * time：2022/10/19 下午3:38
 * author： WeiWei
 * description：
 **/
class HomePageFragment: Fragment() {
    companion object {
        private const val TAG = "HomePageFragment"
        const val PLUGIN_SO = "plugin_so" //插件1
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
        btn_plugin_test_so.setOnClickListener {
            startPlugin()
        }
    }

    private fun startPlugin() {
        PluginManager.loadLastVersionPlugin(PLUGIN_SO)
        try {

            var className = PluginManager.getPlugin(PLUGIN_SO).pluginMeta.mainClass
            Log.d(TAG, "startPlugin: $className")
            val cl: Class<*> = PluginManager.mNowClassLoader.loadClass(className)
            val intent = Intent(activity, cl)
//            startActivity(intent);
            //这种方式为通过欺骗android系统的activity存在性校验的方式实现
            PluginManager.startActivity(intent)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }
}