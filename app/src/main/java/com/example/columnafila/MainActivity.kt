package com.example.columnafila

import PantallaLazyVerticalGrid
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.columnafila.ui.pantalles.PantallaDetall
import com.example.columnafila.ui.pantalles.PantallaLazyColumn
import com.example.columnafila.ui.pantalles.PantallaLazyHorizontalGrid
import com.example.columnafila.ui.theme.ColumnaFilaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColumnaFilaTheme {
                //PantallaLazyVerticalGrid()
                //PantallaLazyColumn()
                //PantallaLazyHorizontalGrid()
                PantallaDetall()
            }
        }
    }
}
