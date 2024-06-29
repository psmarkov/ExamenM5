package com.example.examen_m5_paulamarkov.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_m5_paulamarkov.Model.Local.TransaccionItem
import com.example.examen_m5_paulamarkov.R
import com.example.examen_m5_paulamarkov.ViewModel.HomePage_vm
import com.example.examen_m5_paulamarkov.databinding.FragmentHomePageBinding


class HomePage : Fragment() {

    private lateinit var hpBinding: FragmentHomePageBinding
    private val viewModel: HomePage_vm by activityViewModels()

    private val binding get() = hpBinding!!

    //private lateinit var adp:MiAdapter
    //private lateinit var rcv : RecyclerView

    //private var miLista : MutableList<TransaccionItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // llenaTransaccion()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflar el fragmento
        var view = inflater.inflate(R.layout.fragment_home_page, container, false)
        hpBinding = FragmentHomePageBinding.inflate(layoutInflater)

        //llenaTransaccion()

        //Inicializo y prendo el Recicler Y ADAPTER
        //adp = MiAdapter(miLista)
        //hpBinding.mirecycler.setHasFixedSize(true)
        //hpBinding.mirecycler.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        //hpBinding.mirecycler.adapter = adp

        return hpBinding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //DEBEMOS ISNTANCIAR EL ADAPTER
        val adapter = MiAdapter()

        binding.mirecycler.adapter = adapter
        //binding.mirecycler.layoutManager= LinearLayoutManager(context)

        //INICIALIZO RECYCLER
        binding.mirecycler.setHasFixedSize(true)
        binding.mirecycler.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)



        viewModel.getWalletList().observe(viewLifecycleOwner, Observer {


            it?.let {

                Log.d("Listado", it.toString())
                adapter.update(it)
            }

        })

        //METODO PARA SELECCIONAR
        /*
        adapter.selectedWallet().observe(viewLifecycleOwner, Observer {
            it.let {
                Log.d("SELECCION", it.toString())
                viewModel.getWalletDetailByIdFromInternet(it.id.toString())
            }
            val bundle= Bundle().apply {
                putString("putFuturoId",it.id.toString())
            }

            // ++++++++ SLECCIONA UN ITEM VA A SEND MONEY CAMBIAR A MOSTRAR UN ITEM
            findNavController().navigate(R.id.action_homePage_to_sendMoney,bundle)
        })

    }
*/

       // override fun onDestroyView() {
       //     super.onDestroyView()
         //   hpBinding = null
       // }


        /*
        fun llenaTransaccion(){

            miLista.add(TransaccionItem("Yara Khalil", "Oct 14, 10:24 AM ", "-$15.00", R.drawable.group1))
            miLista.add(TransaccionItem("Sara Ibrahim", "Oct 12, 02:13 PM", "+$20.50",  R.drawable.group2))
            miLista.add(TransaccionItem("Ahmad Ibrahim", "Oct 11, 01:19 AM", "+$12.40", R.drawable.group3))
            miLista.add(TransaccionItem("Reem Khaled", "Oct 07, 09:10 PM", "-$21.30", R.drawable.group4))
            miLista.add(TransaccionItem("Hiba Saleh", "Oct 04, 05:45 AM", "+$09.00",  R.drawable.group5))
            miLista.add(TransaccionItem("Ahmad Ibrahim", "Oct 11, 01:19 AM", "+$12.40", R.drawable.group3))
            miLista.add(TransaccionItem("Reem Khaled", "Oct 07, 09:10 PM", "-$21.30", R.drawable.group4))
            miLista.add(TransaccionItem("Hiba Saleh", "Oct 04, 05:45 AM", "+$09.00",  R.drawable.group5))


        }

     */

        // NAVEGACION DE BOTONES A OTROS FRAGMENTOS DE LA APP
        hpBinding.btnEnvia.setOnClickListener {
            it.findNavController().navigate(R.id.action_homePage_to_sendMoney)
        }

        hpBinding.btnIngresa.setOnClickListener {
            it.findNavController().navigate(R.id.action_homePage_to_requestMoney)
        }

        hpBinding.imgProfile.setOnClickListener {
            it.findNavController().navigate(R.id.action_homePage_to_profilePage)
        }





    }

}
