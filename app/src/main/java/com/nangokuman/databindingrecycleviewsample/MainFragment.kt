package com.nangokuman.databindingrecycleviewsample


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nangokuman.databindingrecycleviewsample.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    var viewListViewModel: MainListViewModel? = null

    var fragmentMainBinding: FragmentMainBinding? = null
    var mainListRecycleViewAdapter: MainListRecycleViewAdapter? = null

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)
        fragmentMainBinding?.viewModel = viewListViewModel

        return fragmentMainBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupRecycleAdapter()
    }

    private fun setupRecycleAdapter() {
        val recycleView = fragmentMainBinding?.recyclerView
        viewListViewModel?.listItems?.also {
            mainListRecycleViewAdapter = MainListRecycleViewAdapter(it)
            recycleView?.adapter = mainListRecycleViewAdapter
        }
    }
}
