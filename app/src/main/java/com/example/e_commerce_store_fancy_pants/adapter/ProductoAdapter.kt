package com.example.e_commerce_store_fancy_pants.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_store_fancy_pants.databinding.ProductoFilaBinding
import com.example.e_commerce_store_fancy_pants.model.Producto
import com.example.e_commerce_store_fancy_pants.ui.producto.ProductoFragmentDirections

class ProductoAdapter : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    //Lista para guardar la data de productos
    private var listaProductos = emptyList<Producto>()

    inner class ProductoViewHolder(private val itemBinding: ProductoFilaBinding) :
    RecyclerView.ViewHolder(itemBinding.root){
        fun bind(producto: Producto) {
            itemBinding.tvNombreProducto.text = "Nombre del Producto: "+producto.nombre
            itemBinding.tvCantidad.text = "Cantidad: "+producto.cantidad
            itemBinding.tvColor.text = "Color: "+producto.color
            itemBinding.tvDescuento.text = "Descuento: "+producto.descuento
            itemBinding.tvPrecio.text = "Precio: "+producto.precio

            //Navegar al update
            itemBinding.vistaFila.setOnClickListener{
                val action = ProductoFragmentDirections.actionNavProductoToUpdateProductoFragment(producto)
                itemView.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val itemBinding = ProductoFilaBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ProductoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val productoActual = listaProductos[position]
        holder.bind(productoActual)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    fun setData(producto: List<Producto>){
        this.listaProductos = producto
        notifyDataSetChanged() // Hace que se redibuje la lista
    }
}