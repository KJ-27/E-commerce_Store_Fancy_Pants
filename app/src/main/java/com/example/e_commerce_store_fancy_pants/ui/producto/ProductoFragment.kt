package com.example.e_commerce_store_fancy_pants.ui.producto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.e_commerce_store_fancy_pants.databinding.FragmentProductoBinding
import com.example.e_commerce_store_fancy_pants.viewmodel.ProductoViewModel

class ProductoFragment : Fragment() {

    private var _binding: FragmentProductoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val productoViewModel =
            ViewModelProvider(this).get(ProductoViewModel::class.java)

        _binding = FragmentProductoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        productoViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}