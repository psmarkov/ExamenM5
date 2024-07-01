package com.example.examen_m5_paulamarkov.View


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal
import com.example.examen_m5_paulamarkov.Model.Local.TransaccionItem
import com.example.examen_m5_paulamarkov.databinding.ItemRecyclerBinding

class MiAdapter(var Lista:MutableList<TransaccionItem>):
    RecyclerView.Adapter<MiAdapter.MiViewHolder>() {

    lateinit var onItemClickListener: (TransaccionItem) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiAdapter.MiViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MiAdapter.MiViewHolder, position: Int) {
        val v_transaccion: TransaccionItem = Lista[position]
        holder.bind(v_transaccion)
    }

    override fun getItemCount(): Int {
        return Lista.size
    }

    inner class MiViewHolder(private var binding: ItemRecyclerBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(item: TransaccionItem){
            binding.itNombre.text = item.ti_nombre
            binding.itFecha.text = item.ti_fecha
            binding.itValor.text = item.ti_cantidad
            binding.itImg.setImageResource(item.ti_foto)

            // binding.root.setOnClickListener {
            //    onItemClickListener(item)
            // }
        }
    }

}