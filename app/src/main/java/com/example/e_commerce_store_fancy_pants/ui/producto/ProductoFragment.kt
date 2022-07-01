package com.example.e_commerce_store_fancy_pants.ui.producto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce_store_fancy_pants.R
import com.example.e_commerce_store_fancy_pants.adapter.ProductoAdapter
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

        val productoAdapter = ProductoAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = productoAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        productoViewModel = ViewModelProvider(this)[ProductoViewModel::class.java]

        productoViewModel.getAllData.observe(viewLifecycleOwner) { producto ->
            productoAdapter.setData(producto)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}