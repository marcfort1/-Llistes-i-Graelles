package com.example.columnafila.ui.pantalles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.columnafila.R
import com.example.columnafila.dades.dadesPilots
import com.example.columnafila.model.Pilot

@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun PantallaLazyColumn(pilots : List<Pilot> = dadesPilots.getPilots())
{
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    )
    {
        stickyHeader() {
            Text("Llista de pilots",
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray))        }
        items(pilots){
            ListItem(
                modifier = Modifier
                    .clickable {
                        //onClickGuerrer(it.id)
                    },

                colors = ListItemDefaults.colors(
                    containerColor = Color.DarkGray,
                    headlineColor = it.color,
                    supportingColor = Color.White,
                    trailingIconColor = Color.White),
                headlineContent = {
                    Text(
                        text = "${it.nom} ${it.cognom}",
                        style = MaterialTheme.typography.displaySmall
                    )
                },
                supportingContent = { Text(text = it.nacionalitat, style = MaterialTheme.typography.bodyLarge,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis) },
                trailingContent =
                {
                    Text(text = "${it.id}")
                },
                leadingContent = {
                    AsyncImage(
                        model = ImageRequest
                            .Builder(LocalContext.current)
                            .data(it.foto)
                            .crossfade(durationMillis = 2000)
                            .build(),
                        placeholder = painterResource(R.drawable.ic_launcher_foreground),
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp),
                        contentDescription = null)
                }
            )

            HorizontalDivider(
                color = Color.White,
                thickness = 2.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}