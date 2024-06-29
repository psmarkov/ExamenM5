package com.example.examen_m5_paulamarkov.View

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal
import com.example.examen_m5_paulamarkov.Model.Local.TransaccionItem
import com.example.examen_m5_paulamarkov.databinding.ItemRecyclerBinding

/**
 * Adaptador para mostrar la lista de transacciones en un RecyclerView.
 */
class MiAdapter: RecyclerView.Adapter<MiAdapter.ListaTransaccionesVH>() {

    private var listaTransaccion = listOf<SendMoneyLocal>()
    private val transaccionSelected = MutableLiveData<SendMoneyLocal>() //Cambiar a local


    //Actualiza la lista de transacciones mostradas en el RecyclerView.
    fun update(transaccion: List<SendMoneyLocal>){
        listaTransaccion = transaccion
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaTransaccionesVH {
        return ListaTransaccionesVH(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = listaTransaccion.size

    override fun onBindViewHolder(holder: ListaTransaccionesVH, position: Int) {
        val transaccion = listaTransaccion[position]
        holder.bind(transaccion)
    }


    //Clase interna
    inner class ListaTransaccionesVH(private val binding: ItemRecyclerBinding):
        RecyclerView.ViewHolder(binding.root), View.OnClickListener{

        //Vincular los datos de la transacción al ViewHolder.

            fun bind(transaccion: SendMoneyLocal){
                binding.itNombre.text = transaccion.id.toString()
                binding.itFecha.text = transaccion.userId.toString()
                binding.itValor.text = transaccion.amount.toString()

           /* Glide.with(binding.imgUsuario).load(R.drawable.userp).centerCrop().into(binding.imgUsuario)
            binding.nombreUsuario.text = transaccion.concept
            binding.fecha.text = transaccion.createdAt
            binding.monto.text = transaccion.amount

            //Flecha según el tipo de transacción
            val imgFlecha = when(transaccion.type){
                "topup" -> R.drawable.arrow_greenp
                "payment" -> R.drawable.arrow_redp
                else -> null
            }

            Glide.with(binding.flecha).load(imgFlecha).centerCrop().into(binding.flecha)
            */

            itemView.setOnClickListener(this)
        }



        override fun onClick(v: View?) {
            transaccionSelected.value = listaTransaccion[adapterPosition]
        }
    }
}

/*
//class MiAdapter(var Lista:MutableList<TransaccionItem>):
//RecyclerView.Adapter<MiAdapter.MiViewHolder>() {
class MiAdapter : RecyclerView.Adapter<MiAdapter.viewholder>() {

    private var listWallet = listOf<SendMoneyLocal>()
    private val selectedWallet = MutableLiveData<SendMoneyLocal>()

    fun selectedWallet(): LiveData<SendMoneyLocal> = selectedWallet

    inner class viewholder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(wine3: SendMoneyLocal) {
    /*
            binding.imgWine.setImageResource(0) // Para poner una imagen en blanco

            Glide.with(binding.imgWine)
                .load(wine3.image)
                .centerCrop()
                .into(binding.imgWine)
*/

            binding.itNombre.text = wine3.id.toString()
            binding.itFecha.text = wine3.userId.toString()
            binding.itValor.text = wine3.amount.toString()
           // binding.itImg.setImageResource(item.ti_foto)

            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View) {

            selectedWallet.value = listWallet[adapterPosition]

            Log.d("ONCLICK", adapterPosition.toString())
        }

    }

    fun update(list: List<SendMoneyLocal>) {
        listWallet = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = listWallet.size

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.bind(listWallet[position])
    }









    /*
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
    */

}
*/
