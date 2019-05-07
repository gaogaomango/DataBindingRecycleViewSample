package com.nangokuman.databindingrecycleviewsample

import android.os.Bundle
import android.support.v4.app.Fragment

class ViewModelHolder<VM>: Fragment() {

    companion object {
        fun <M> createContainer(viewModel: M): ViewModelHolder<M> {
            val viewModelContainer = ViewModelHolder<M>()
            viewModelContainer.viewModel = viewModel
            return viewModelContainer
        }
    }
    var viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
}