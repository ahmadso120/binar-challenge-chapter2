package com.binar.tokopediachallenge.ui.officialstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binar.tokopediachallenge.databinding.FragmentOfficialStoreBinding

class OfficialStoreFragment : Fragment() {
    private var _binding: FragmentOfficialStoreBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOfficialStoreBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}