package com.example.columnafila.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.columnafila.dades.dadesPilots
import com.example.columnafila.model.Pilot

@Composable
fun PantallaDetall(pilots: List<Pilot> = dadesPilots.getPilots()) {
    // Seleccionar un piloto aleatorio de la lista
    val randomPilot = remember { pilots.random() }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(Color.Gray), // Fondo gris
        horizontalAlignment = Alignment.CenterHorizontally, // Centrar el contenido
        verticalArrangement = Arrangement.Center // Centrar verticalmente
    ) {
        // Mostrar la foto del piloto
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(randomPilot.foto)
                .crossfade(durationMillis = 2000)
                .build(),
            contentDescription = "Foto del piloto",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )

        // Mostrar el nombre completo del piloto
        Text(
            text = "${randomPilot.nom} ${randomPilot.cognom}",
            style = MaterialTheme.typography.displaySmall.copy(fontSize = 24.sp), // Aumentar tamaño de letra
            modifier = Modifier.padding(vertical = 8.dp),
            textAlign = TextAlign.Center // Centrar texto
        )

        // Mostrar la nacionalidad
        Text(
            text = "Nacionalitat: ${randomPilot.nacionalitat}",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), // Aumentar tamaño de letra
            textAlign = TextAlign.Center // Centrar texto
        )

        // Mostrar el ID del piloto
        Text(
            text = "ID: ${randomPilot.id}",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), // Aumentar tamaño de letra
            modifier = Modifier.padding(vertical = 8.dp),
            textAlign = TextAlign.Center // Centrar texto
        )

        // Mostrar la escuderia
        Text(
            text = "Escuderia: ${randomPilot.escuderia}",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), // Aumentar tamaño de letra
            textAlign = TextAlign.Center // Centrar texto
        )

        // Mostrar si ha ganado
        Text(
            text = "Ha guanyat: ${if (randomPilot.haGuanyat) "Sí" else "No"}",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), // Aumentar tamaño de letra
            textAlign = TextAlign.Center // Centrar texto
        )

        // Mostrar el número de podios
        Text(
            text = "Podis: ${randomPilot.podis}",
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp), // Aumentar tamaño de letra
            textAlign = TextAlign.Center // Centrar texto
        )
    }
}

@Composable
fun PantallaRandomPiloto(pilots: List<Pilot>) {
    // Mostramos la pantalla de detalle del piloto aleatorio
    PantallaDetall(pilots = pilots)
}

@Preview(showSystemUi = true)
@Composable
fun PreviewPantallaRandomPiloto() {
    // Simulamos la lista de pilotos
    val samplePilots = dadesPilots.getPilots() // Suponiendo que esta función retorna una lista de pilotos
    PantallaRandomPiloto(pilots = samplePilots)
}
