package com.example.e_commerce_store_fancy_pants.ui.producto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.e_commerce_store_fancy_pants.R
import com.example.e_commerce_store_fancy_pants.databinding.FragmentProductoBinding
import com.example.e_commerce_store_fancy_pants.viewmodel.ProductoViewModel

class ProductoFragment : Fragment() {

    private lateinit var productoViewModel: ProductoViewModel
    private var _binding: FragmentProductoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        productoViewModel = ViewModelProvider(this)[ProductoViewModel::class.java]
        _binding = FragmentProductoBinding.inflate(inflater, container, false)

        binding.addProductoFabButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_producto_to_addProductoFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}