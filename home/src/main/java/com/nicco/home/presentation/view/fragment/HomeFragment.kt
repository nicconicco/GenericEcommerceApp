package com.nicco.home.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.nicco.home.databinding.FragmentHomeBinding
import com.nicco.home.di.module.homeDataSourcelModule
import com.nicco.home.di.module.homeRepositorylModule
import com.nicco.home.di.module.homeViewModelModule
import com.nicco.home.presentation.view.adapter.HomeCardAdapter
import com.nicco.home.presentation.viewmodel.HomeViewModel
import com.nicco.home.presentation.viewmodel.HomeViewAction
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class HomeFragment : Fragment() {

    private val loadFeatures by lazy {
        loadKoinModules(
            listOf(
                homeDataSourcelModule,
                homeRepositorylModule,
                homeViewModelModule
                )
        )
    }

    private fun injectFeatures() = loadFeatures

    @ExperimentalCoroutinesApi
    private val homeViewModel: HomeViewModel by viewModel()

    private val adapter by lazy {
        HomeCardAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeatures()
    }

    @ExperimentalCoroutinesApi
    @FlowPreview
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentHomeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            list.adapter = adapter
            subscribeUi(adapter)
        }.root
    }

    @FlowPreview
    @ExperimentalCoroutinesApi
    private fun subscribeUi(adapter: HomeCardAdapter) {
        homeViewModel.actionView.observe(viewLifecycleOwner) { state ->
            when (state) {
                is HomeViewAction.HomeLoading -> {
                    setProgress(state)
                }
                is HomeViewAction.HomeSuccess -> {
                    adapter.submitList(state.itens)
                }
                is HomeViewAction.HomeError -> {
                    Toast.makeText(context, state.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun setProgress(state: HomeViewAction.HomeLoading) {
        when (state.loading) {
            true -> {
                progress.visibility = View.VISIBLE
            }
            false -> {
                progress.visibility = View.GONE
            }
        }
    }

    override fun onPause() {
        super.onPause()
        unloadKoinModules(
            listOf(
                homeViewModelModule,
                homeRepositorylModule,
                homeDataSourcelModule
            )
        )
    }
}
