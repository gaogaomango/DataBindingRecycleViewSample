package com.nangokuman.databindingrecycleviewsample

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

fun addFragmentToActivity(fragmentManager: FragmentManager?, fragment: Fragment?, frameId: Int) {
    fragment?.also {
        val transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
        transaction?.add(frameId, fragment)
        transaction?.commit()
    }
}

fun addFragmentToActivity(fragmentManager: FragmentManager?, fragment: Fragment?, tag: String) {
    fragment?.also {
        val transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
        transaction?.add(it, tag)
        transaction?.commit()
    }
}