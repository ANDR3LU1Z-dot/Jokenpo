package com.example.jokenpo

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jokenpo.databinding.FragmentPlayerBinding


class PlayerFragment : Fragment() {
    private lateinit var root: View
    private lateinit var playerBinding: FragmentPlayerBinding
    private lateinit var selectPlay: Spinner
    private lateinit var onItemSelectedListener: AdapterView.OnItemSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        onItemSelectedListener = context as AdapterView.OnItemSelectedListener
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        playerBinding = FragmentPlayerBinding.inflate(inflater, container, false)
        root = playerBinding.root
        selectPlay = playerBinding.spinner
        setHasOptionsMenu(true)
        setupSelectPlaySpinner()
        //Observador do ciclo de vida dessa Fragment
        lifecycle.addObserver(CustomObserver())

        // Inflate the layout for this fragment
        return root

    }

    private fun setupSelectPlaySpinner(){
        val adapter = ArrayAdapter.createFromResource(requireContext(),R.array.available_plays_array,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        selectPlay.adapter = adapter
        selectPlay.onItemSelectedListener = onItemSelectedListener


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//                val menuSpinner = playerBinding.spinner
//        val listaJogadas = arrayOf("Pedra", "Papel", "Tesoura")
//        menuSpinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, listaJogadas)
//
//        menuSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Toast.makeText(requireContext(), listaJogadas[menuSpinner.selectedItemPosition], Toast.LENGTH_SHORT).show()
//            }
//this
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//
//        }
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

//    override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        val plays = resources.getStringArray(R.array.available_plays_array)
//        val selectedPlay = plays[position]
//
//        Toast.makeText(requireContext(), "Jogada Selecionada: ${selectedPlay.toString()}", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onNothingSelected(p0: AdapterView<*>?) {
//
//    }


}