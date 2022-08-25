package com.example.jokenpo


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jokenpo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var bindingHome: FragmentHomeBinding
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("Lifecycle", "onCreate")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingHome = FragmentHomeBinding.inflate(inflater, container, false)
        editText = bindingHome.editText

        if(savedInstanceState?.containsKey("editTextValue") == true){
            val value = savedInstanceState.getString("editTextValue")
            editText.setText(value)
        }

//        Log.d("Lifecycle", "onCreateView")

        bindingHome.buttonstart.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToNavigation()
            findNavController().navigate(action)

        }

        //Observador do ciclo de vida dessa Fragment
        lifecycle.addObserver(CustomObserver())

        return bindingHome.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("editTextValue", editText.text.toString())
    }

//    override fun onResume() {
//        super.onResume()
//        Log.d("Lifecycle", "onResume")
//    }

//    override fun onPause() {
//        super.onPause()
//        Log.d("Lifecycle", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("Lifecycle", "onStop")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("Lifecycle", "onDestroy")
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        Log.d("Lifecycle", "onDetach")
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        Log.d("Lifecycle", "onAttach")
//    }
}