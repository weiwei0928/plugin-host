package com.ww.host.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ww.host.R

/**
 * time：2022/10/19 下午3:38
 * author： WeiWei
 * description：
 **/
class CommunityFragment: Fragment() {

    companion object {

        fun newInstance() = CommunityFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_community, container, false)
    }

}