package com.example.e_commerce_store_fancy_pants.ui.producto

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.e_commerce_store_fancy_pants.R
import com.example.e_commerce_store_fancy_pants.databinding.FragmentUpdateProductoBinding
import com.example.e_commerce_store_fancy_pants.model.Producto
import com.example.e_commerce_store_fancy_pants.viewmodel.ProductoViewModel

class UpdateProductoFragment : Fragment() {

    private var _binding: FragmentUpdateProductoBinding? = null
    private val binding get() = _binding!!

    private lateinit var productoViewModel: ProductoViewModel

    private val args by navArgs<UpdateProductoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateProductoBinding.inflate(inflater, container, false)

        productoViewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)

        binding.txtNombreProducto.setText(args.producto.nombre)
        binding.txtPrecio.setText(args.producto.precio)
        binding.txtCantidad.setText(args.producto.cantidad)
        binding.txtColor.setText(args.producto.color)
        binding.txtDescuento.setText(args.producto.descuento)

        binding.btnAdd.setOnClickListener{ updateProducto() }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Si es eliminar
        if (item.itemId == R.id.menu_delete){
            deleteProducto()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateProducto() {
        val nombre = binding.txtNombreProducto.text.toString()
        val precio = binding.txtPrecio.text.toString()
        val cantidad = binding.txtCantidad.text.toString()
        val color = binding.txtColor.text.toString()
        val descuento = binding.txtDescuento.text.toString()

        if (validos(nombre, precio, cantidad, color, descuento)) {
            val producto = Producto(args.producto.id, nombre, precio, cantidad, color, descuento)
            productoViewModel.updateProducto(producto)
            Toast.makeText(requireContext(),"Producto Actualizado", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_updateProductoFragment_to_nav_producto)
        } else {
            Toast.makeText(requireContext(),"Error al actualizar el producto", Toast.LENGTH_LONG).show()
        }
    }

    private fun deleteProducto() {
        val builder = AlertDialog.Builder(requireContext())

        builder.setPositiveButton(getString(R.string.Si)) {_,_ ->
            productoViewModel.deleteProducto(args.producto)
            Toast.makeText(requireContext(),"Se elimino el producto: "+args.producto.nombre, Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateProductoFragment_to_nav_producto)
        }

        builder.setNegativeButton(getString(R.string.No)) {_,_ ->}
        builder.setTitle(R.string.Delete)
        builder.setMessage(getString(R.string.msg_Delete) + "${args.producto.nombre}?")
        builder.create().show()
    }

    private fun validos(nombre: String, precio: String, cantidad: String, color: String, descuento: String): Boolean {
        return !(nombre.isEmpty() || precio.isEmpty() || cantidad.isEmpty() || color.isEmpty() || descuento.isEmpty())
    }
}