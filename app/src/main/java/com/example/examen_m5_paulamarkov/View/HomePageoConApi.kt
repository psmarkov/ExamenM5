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

import androidx.recyclerview.widget.LinearLayoutManager

import com.example.examen_m5_paulamarkov.R
import com.example.examen_m5_paulamarkov.ViewModel.HomePage_vm
import com.example.examen_m5_paulamarkov.databinding.FragmentHomePageBinding


class HomePageoConApi : Fragment() {
/*
    private lateinit var hpBinding: FragmentHomePageBinding
    private val viewModel: HomePage_vm by activityViewModels()

    private val binding get() = hpBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflar el fragmento
        var view = inflater.inflate(R.layout.fragment_home_page, container, false)
        hpBinding = FragmentHomePageBinding.inflate(layoutInflater)

        return hpBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //DEBEMOS ISNTANCIAR EL ADAPTER
        val adapter = MiAdapter()

        binding.mirecycler.adapter = adapter
        //binding.mirecycler.layoutManager= LinearLayoutManager(context)
       // binding.mirecycler.layoutManager= LinearLayoutManager(requireContext())

        // Configurar el adaptador para el RecyclerView que muestra el historial de transacciones



        //INICIALIZO RECYCLER
        binding.mirecycler.setHasFixedSize(true)
        binding.mirecycler.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)


        viewModel.getWalletList().observe(viewLifecycleOwner, Observer {


            it?.let {

                Log.d("Listado", it.toString())
                adapter.update(it)
            }

        })

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
*/
}
