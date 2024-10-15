package com.example.columnafila.model

import androidx.compose.ui.graphics.Color

data class Pilot (
    var id: Int,
    var nom: String,
    var cognom: String,
    var nacionalitat: String,
    var escuderia: String,
    var haGuanyat: Boolean,
    var podis: Int,
    var color: Color,
    var foto: String
)