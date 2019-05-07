package com.nangokuman.databindingrecycleviewsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainListViewModel: MainListViewModel

    companion object {
        @JvmStatic
        val MAIN_LIST_VIEW_MODEL_TAG = "MAIN_LIST_VIEW_MODEL_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = findOrCreateViewFragment()
        mainListViewModel = findOrCreateViewModel()
        mainFragment.viewListViewModel = mainListViewModel
    }

    private fun findOrCreateViewModel(): MainListViewModel {
        val retainedViewModel: ViewModelHolder<MainListViewModel>? = supportFragmentManager.findFragmentByTag(MAIN_LIST_VIEW_MODEL_TAG) as? ViewModelHolder<MainListViewModel>

        var viewModel = retainedViewModel?.viewModel
        if(viewModel != null) {
            return viewModel
        } else {
            viewModel = MainListViewModel()
            addFragmentToActivity(supportFragmentManager, ViewModelHolder.createContainer(viewModel), MAIN_LIST_VIEW_MODEL_TAG)
            return viewModel
        }
    }

    private fun findOrCreateViewFragment(): MainFragment {
        var mainFragment = supportFragmentManager.findFragmentById(R.id.contentFrame) as? MainFragment
        if(mainFragment == null) {
            mainFragment = MainFragment.newInstance()
            addFragmentToActivity(supportFragmentManager, mainFragment, R.id.contentFrame)
        }
        return mainFragment
    }

}
