package com.example.jokenpo

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.jokenpo.databinding.FragmentPlayerBinding
import com.example.jokenpo.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var root: View
    private lateinit var resultBinding: FragmentResultBinding
    private lateinit var engine: JokenpoEngine
    private lateinit var resultText: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resultBinding = FragmentResultBinding.inflate(inflater, container, false)
        engine = JokenpoEngine(resources.getStringArray(R.array.available_plays_array))

        val currentPlay = arguments?.getString("currentPlay")
        resultText = resultBinding.txtJogadorVencedor


        currentPlay?.let {
            updateResultText(currentPlay)
        }


        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        root = resultBinding.root

        //Observador do ciclo de vida dessa Fragment
        lifecycle.addObserver(CustomObserver())
        return root
    }

    private fun updateResultText(currentPlay: String){
        val resultGame = engine.calculateResult(currentPlay)

        resultText.text = when(resultGame){
            Result.WIN -> "Você Ganhou! :)"
            Result.LOSS -> "Você Perdeu :("
            else -> "Você Empatou."
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