package com.example.examen_m5_paulamarkov.View


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_m5_paulamarkov.Model.Local.Data.SendMoneyLocal
import com.example.examen_m5_paulamarkov.databinding.ItemRecyclerBinding

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

               /* //Flecha según el tipo de transacción
                val imgFlecha = when(transaccion.type){
                    "topup" -> R.drawable.send_icon
                    "payment" -> R.drawable.request_icon
                    else -> null
                }

                Glide.with(binding.itImg).load(imgFlecha).centerCrop().into(binding.itImg)
*/

                binding.itNombre.text = transaccion.id.toString()
                binding.itFecha.text = transaccion.userId.toString()
                binding.itValor.text = transaccion.amount

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
