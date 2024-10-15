import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.columnafila.R
import com.example.columnafila.dades.dadesPilots
import com.example.columnafila.model.Pilot

@Preview(showSystemUi = true)
@Composable
fun PantallaLazyVerticalGrid(pilots: List<Pilot> = dadesPilots.getPilots()) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),  // Número de columnas en la cuadrícula
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(pilots) {
            ListItem(
                modifier = Modifier
                    .clickable {
                        //onClickGuerrer(it.id)
                    },
                colors = ListItemDefaults.colors(
                    containerColor = Color.DarkGray,
                    headlineColor = it.color,
                    supportingColor = Color.White,
                    trailingIconColor = Color.White
                ),
                headlineContent = {
                    Text(
                        text = "${it.nom} ${it.cognom}",
                        fontSize = 14.sp
                    )
                },
                supportingContent = {
                    Text(
                        text = it.nacionalitat,
                        fontSize = 12.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                trailingContent = {
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
                        contentDescription = null
                    )
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
