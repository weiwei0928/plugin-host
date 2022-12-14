package com.ww.host

import android.app.Application
import android.content.Context
import com.ww.host.ui.TestPluginActivity.Companion.PLUGIN_SAMPLE1
import com.ww.host.ui.fragment.HomePageFragment.Companion.PLUGIN_SO
import zeus.plugin.PluginManager
import java.util.HashMap

/**
 * time：2022/10/21 上午10:21
 * author： WeiWei
 * description：
 **/
class HostApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        val defaultList = HashMap<String, Int>()


        defaultList[PLUGIN_SAMPLE1] = 1
        defaultList[PLUGIN_SO] = 2
        PluginManager.init(this, defaultList)
    }
}