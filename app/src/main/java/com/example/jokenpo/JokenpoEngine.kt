package com.example.jokenpo

import kotlin.random.Random

//Classes Responsáveis pelas Regras de Negócio de nossa aplicação

enum class Result{
    WIN, DRAWN, LOSS
}

class JokenpoEngine(val availablePlays: Array<String>) {

    fun calculateResult(playerPlay: String): Result{
        val aiPlay = getAIPlay()

        return when{
            playerPlay == aiPlay -> Result.DRAWN
            playerPlay == "Pedra" && aiPlay == "Tesoura" -> Result.WIN
            playerPlay == "Pedra" && aiPlay == "Papel" -> Result.LOSS
            playerPlay == "Papel" && aiPlay == "Pedra" -> Result.WIN
            playerPlay == "Papel" && aiPlay == "Tesoura" -> Result.LOSS
            playerPlay == "Tesoura" && aiPlay == "Papel" -> Result.WIN
            else -> Result.LOSS
        }
    }
    //Simulando uma ia que ira retornar uma posição de 0 a 2 para a string
    private fun getAIPlay(): String {
        val playIndex = Random.nextInt(0, 2)
        return availablePlays[playIndex]
    }
}