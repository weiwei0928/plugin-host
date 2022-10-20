package com.ww.host.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ww.easyplugin.extension.setOnClickListener
import com.ww.host.R
import com.ww.host.ui.fragment.CommunityFragment
import com.ww.host.ui.fragment.HomePageFragment
import com.ww.host.ui.fragment.MineFragment
import com.ww.host.ui.fragment.NotificationFragment
import kotlinx.android.synthetic.main.layout_bottom_navigation_bar.*

/**
 * time：2022/10/19 下午3:21
 * author： weiwei
 * description：
 **/
class MainActivity : AppCompatActivity() {

    private var homePageFragment: HomePageFragment? = null

    private var communityFragment: CommunityFragment? = null

    private var notificationFragment: NotificationFragment? = null

    private var mineFragment: MineFragment? = null

    private val fragmentManager: FragmentManager by lazy { supportFragmentManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        setOnClickListener(btnHomePage, btnCommunity, btnNotification, btnMine) {
            when (this) {
                btnHomePage -> {
                    setTabSelection(0)
                }
                btnCommunity -> {
                    setTabSelection(1)
                }
                btnNotification -> {
                    setTabSelection(2)
                }
                btnMine -> {
                    setTabSelection(3)
                }
            }
        }
        setTabSelection(0)
    }

    private fun setTabSelection(index: Int) {
        clearAllSelected()
        fragmentManager.beginTransaction().apply {
            hideFragments(this)
            when (index) {
                0 -> {
                    ivHomePage.isSelected = true
                    tvHomePage.isSelected = true
                    if (homePageFragment == null) {
                        homePageFragment = HomePageFragment.newInstance()
                        add(R.id.homeActivityFragContainer, homePageFragment!!)
                    } else {
                        show(homePageFragment!!)
                    }
                }
                1 -> {
                    ivCommunity.isSelected = true
                    tvCommunity.isSelected = true
                    if (communityFragment == null) {
                        communityFragment = CommunityFragment.newInstance()
                        add(R.id.homeActivityFragContainer, communityFragment!!)
                    } else {
                        show(communityFragment!!)
                    }
                }
                2 -> {
                    ivNotification.isSelected = true
                    tvNotification.isSelected = true
                    if (notificationFragment == null) {
                        notificationFragment = NotificationFragment.newInstance()
                        add(R.id.homeActivityFragContainer, notificationFragment!!)
                    } else {
                        show(notificationFragment!!)
                    }
                }
                3 -> {
                    ivMine.isSelected = true
                    tvMine.isSelected = true
                    if (mineFragment == null) {
                        mineFragment = MineFragment.newInstance()
                        add(R.id.homeActivityFragContainer, mineFragment!!)
                    } else {
                        show(mineFragment!!)
                    }
                }
                else -> {
                    ivHomePage.isSelected = true
                    tvHomePage.isSelected = true
                    if (homePageFragment == null) {
                        homePageFragment = HomePageFragment.newInstance()
                        add(R.id.homeActivityFragContainer, homePageFragment!!)
                    } else {
                        show(homePageFragment!!)
                    }
                }
            }
        }.commitAllowingStateLoss()
    }

    private fun clearAllSelected() {
        ivHomePage.isSelected = false
        tvHomePage.isSelected = false
        ivCommunity.isSelected = false
        tvCommunity.isSelected = false
        ivNotification.isSelected = false
        tvNotification.isSelected = false
        ivMine.isSelected = false
        tvMine.isSelected = false
    }

    private fun hideFragments(transaction: FragmentTransaction) {
        transaction.run {
            if (homePageFragment != null) hide(homePageFragment!!)
            if (communityFragment != null) hide(communityFragment!!)
            if (notificationFragment != null) hide(notificationFragment!!)
            if (mineFragment != null) hide(mineFragment!!)
        }
    }
}