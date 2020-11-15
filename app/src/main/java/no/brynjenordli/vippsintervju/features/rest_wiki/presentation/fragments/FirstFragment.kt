package no.brynjenordli.vippsintervju.features.rest_wiki.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import no.brynjenordli.vippsintervju.databinding.FragmentFirstBinding
import no.brynjenordli.vippsintervju.features.rest_wiki.presentation.viewmodels.WikiViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class FirstFragment : Fragment() {
    private val viewModel by viewModel<WikiViewModel> { parametersOf() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFirstBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }
}