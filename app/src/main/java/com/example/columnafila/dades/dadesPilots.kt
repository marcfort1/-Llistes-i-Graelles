package com.example.columnafila.dades

import androidx.compose.ui.graphics.Color
import com.example.columnafila.model.Pilot
import kotlin.random.Random

object dadesPilots{

    private val Noms = listOf(
        "Max",
        "Lewis",
        "Valtteri",
        "Charles",
        "Lando",
        "Daniel",
        "Carlos",
        "Sebastian",
        "Fernando",
        "Esteban",
        "Kimi",
        "Mick",
        "Nikita"
    )

    private val Cognoms = listOf(
        "Verstappen",
        "Hamilton",
        "Bottas",
        "Leclerc",
        "Norris",
        "Ricciardo",
        "Sainz",
        "Vettel",
        "Alonso",
        "Ocon",
        "Raikkonen",
        "Schumacher",
        "Mazepin"
    )

    private val Escuderies = listOf(
        "Red Bull Racing",
        "Mercedes",
        "Ferrari",
        "McLaren",
        "Aston Martin",
        "Alpine",
        "Alfa Romeo",
        "Haas",
        "Williams"
    )

    private val Nacionalitats = listOf(
        "Netherlands",
        "United Kingdom",
        "Finland",
        "Monaco",
        "United Kingdom",
        "Australia",
        "Spain",
        "Germany",
        "Spain",
        "France",
        "Finland",
        "Germany",
        "Russia"
    )

    private fun CreaPilots(num: Int) : Pilot {
        val posicioNom = Random.nextInt(0, Noms.size)
        val posicioAdjectiu = Random.nextInt(0, Cognoms.size)
        val posicioEscuderia = Random.nextInt(0, Escuderies.size)
        val posicioNacionalitat = Random.nextInt(0, Nacionalitats.size)

        return Pilot(
            id = num,
            nom = Noms[posicioNom],
            cognom = Cognoms[posicioAdjectiu],
            nacionalitat = Nacionalitats[posicioNacionalitat],
            escuderia = Escuderies[posicioEscuderia],
            haGuanyat = Random.nextBoolean(),
            podis = Random.nextInt(1, 100),
            foto = "https://loremflickr.com/320/240/driver?lock=$num",
            color = Color(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256),
                255
            )
        )
    }

    fun getPilots() =
        (1..100)
            .toList()
            .map { CreaPilots(it) }
}