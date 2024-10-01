package cl.bootcamp.ejercicioindividual7.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cl.bootcamp.ejercicioindividual7.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Ejercicio Individual 7", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }) {
        ContentHomeView(it)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues) {

    var showImage by remember { mutableStateOf(false) }
    var buttonText by remember { mutableStateOf("Mostrar Imagen") }


    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        //verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Bienvenido!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Sergio Dominguez",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = {
                showImage = !showImage
                buttonText = if (showImage) "Ocultar Imagen"
                else "Mostrar Imagen"
            }
        ) {
            Text(text = buttonText)
        }



        if (showImage) {
            Image(
                painter = painterResource(id = R.drawable.dog2),
                contentDescription = stringResource(id = R.string.dog_content_descripcion),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(400.dp)
                    .clip(CircleShape)
            )
        }

    }
}