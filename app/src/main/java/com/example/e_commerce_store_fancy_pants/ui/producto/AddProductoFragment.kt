package com.example.e_commerce_store_fancy_pants.ui.producto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.e_commerce_store_fancy_pants.databinding.FragmentAddProductoBinding

class AddProductoFragment : Fragment() {

    private var _binding: FragmentAddProductoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddProductoBinding.inflate(inflater, container, false)

        return binding.root
    }
}