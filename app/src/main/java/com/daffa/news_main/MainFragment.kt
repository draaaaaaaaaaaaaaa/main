package com.daffa.news_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.news_main.componen.adapter.MainAdapter
import com.daffa.news_main.componen.viewmodel.MainViewModel
import com.daffa.news_main.databinding.FragmentMainBinding
import com.daffa.news_main.network.response.MainResponseItem


class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding as FragmentMainBinding

    private var _viewmodel : MainViewModel? = null
    private val viewModel get() = _viewmodel as MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _viewmodel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getMainModel()
        viewModel.getListMain().observe(viewLifecycleOwner){
            showData(it)
        }
    }

    private fun showData(data: List<MainResponseItem>?) {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = data?.let { MainAdapter(it) }
        }

    }


}