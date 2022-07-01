package com.example.e_commerce_store_fancy_pants.ui.producto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.e_commerce_store_fancy_pants.R
import com.example.e_commerce_store_fancy_pants.databinding.FragmentAddProductoBinding
import com.example.e_commerce_store_fancy_pants.model.Producto
import com.example.e_commerce_store_fancy_pants.viewmodel.ProductoViewModel

class AddProductoFragment : Fragment() {

    private var _binding: FragmentAddProductoBinding? = null
    private val binding get() = _binding!!

    private lateinit var productoViewModel: ProductoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddProductoBinding.inflate(inflater, container, false)

        productoViewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)

        binding.btnAdd.setOnClickListener{ insertProducto() }

        return binding.root
    }

    private fun insertProducto() {
        val nombre = binding.txtNombreProducto.text.toString()
        val precio = binding.txtPrecio.text.toString()
        val cantidad = binding.txtCantidad.text.toString()
        val color = binding.txtColor.text.toString()
        val descuento = binding.txtDescuento.text.toString()

        if (validos(nombre, precio, cantidad, color, descuento)) {
            val producto = Producto(0, nombre, precio, cantidad, color, descuento)
            productoViewModel.addProducto(producto)
            Toast.makeText(requireContext(),"Producto Agregado", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addProductoFragment_to_nav_producto)
        } else {
            Toast.makeText(requireContext(),"Error al agregar el producto", Toast.LENGTH_LONG).show()
        }
    }

    private fun validos(nombre: String, precio: String, cantidad: String, color: String, descuento: String): Boolean {
        return !(nombre.isEmpty() || precio.isEmpty() || cantidad.isEmpty() || color.isEmpty() || descuento.isEmpty())
    }
}