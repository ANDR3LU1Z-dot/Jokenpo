package com.example.jokenpo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jokenpo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var bindingHome: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingHome = FragmentHomeBinding.inflate(inflater, container, false)

        bindingHome.buttonstart.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToNavigation()
            findNavController().navigate(action)

        }
        return bindingHome.root
    }
}