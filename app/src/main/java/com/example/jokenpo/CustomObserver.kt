package com.example.jokenpo

import android.util.Log
import androidx.lifecycle.*

/*
DefaultLifeCycleObserver:
    É uma interface que permite a uma classe
    escutar os eventos do ciclo de vida de um
    outro componente

LifeCycleEventObserver:
    Está interface possui somente um método
    onStateChanged, que é invocado sempre que o
    estado de um componte que estamos escutando
    for alterado
 */

class CustomObserver: DefaultLifecycleObserver, LifecycleEventObserver {
    /*
    Neste método, conseguiremos oberservar o estado de "onResume" da fragmente ou activity
    em que essa classe for instanciada
     */
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        Log.d("Lifecycle", "Observer ${owner.toString()} - onResume")
    }

    //Neste método, recebemos o dono do evento e qual o novo estado
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d("Lifecycle", "${source.toString()} event: ${event.toString()}")
    }

}