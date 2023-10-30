package com.example.artecles.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.artecles.databinding.ArticlesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ArticlesFragment : Fragment() {

    private val viewModel: ArticlesViewModel by viewModels()

    private var _binding: ArticlesFragmentBinding? = null
    private val binding get() = _binding!!

    private val adapter: ArticlesAdapter by lazy {
        ArticlesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ArticlesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvArticles.adapter = adapter
        collectState()
    }

    private fun collectState() {
        viewLifecycleOwner.apply {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    launch {
                        viewModel.resultsState.collect { state ->
                            when (state) {
                                is ArticlesUiState.Loading -> {
                                    binding.progressBar.visibility = View.VISIBLE
                                }

                                is ArticlesUiState.ArticlesLoaded -> {
                                    adapter.submitList(state.data)
                                }

                                else -> {
                                    binding.progressBar.visibility = View.GONE
                                }
                            }
                        }
                    }

                    launch {
                        viewModel.error.collect { state ->
                            when (state) {
                                is ArticlesUiState.Error -> {
                                    Toast.makeText(
                                        requireContext(),
                                        "$state.error",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                else -> {}
                            }
                        }
                    }
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvArticles.adapter = null
        _binding = null
    }


}