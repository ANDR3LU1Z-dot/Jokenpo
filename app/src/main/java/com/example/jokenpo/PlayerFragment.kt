package com.example.jokenpo

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.jokenpo.databinding.FragmentPlayerBinding


class PlayerFragment : Fragment() {
    private lateinit var root: View
    private lateinit var playerBinding: FragmentPlayerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        playerBinding = FragmentPlayerBinding.inflate(inflater, container, false)
        root = playerBinding.root
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                val menuSpinner = playerBinding.spinner
        val listaJogadas = arrayOf("Pedra", "Papel", "Tesoura")
        menuSpinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, listaJogadas)

        menuSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(requireContext(), listaJogadas[menuSpinner.selectedItemPosition], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu_toolbar, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.homeFragment ->{
                findNavController().navigate(R.id.homeFragment)
                true
            }
            else -> false
        }
    }






}