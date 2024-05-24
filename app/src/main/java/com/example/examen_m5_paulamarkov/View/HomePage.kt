package com.example.examen_m5_paulamarkov.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.examen_m5_paulamarkov.Model.TransaccionItem
import com.example.examen_m5_paulamarkov.R
import com.example.examen_m5_paulamarkov.databinding.FragmentHomePageBinding


class HomePage : Fragment() {

    private lateinit var hpBinding: FragmentHomePageBinding

    private lateinit var adp:MiAdapter
    private lateinit var rcv : RecyclerView

    private var miLista : MutableList<TransaccionItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        llenaTransaccion()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_home_page, container, false)
        hpBinding = FragmentHomePageBinding.inflate(layoutInflater)

        //llenaTransaccion()
        //Inicializo y prendo el Recicler


        adp = MiAdapter(miLista)
        hpBinding.mirecycler.setHasFixedSize(true)
        hpBinding.mirecycler.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        hpBinding.mirecycler.adapter = adp



        hpBinding.btnEnvia.setOnClickListener {
            it.findNavController().navigate(R.id.action_homePage_to_sendMoney)
        }

        hpBinding.btnIngresa.setOnClickListener {
            it.findNavController().navigate(R.id.action_homePage_to_requestMoney)
        }

        hpBinding.imgProfile.setOnClickListener {
            it.findNavController().navigate(R.id.action_homePage_to_profilePage)
        }
        return hpBinding.root
    }


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
}
