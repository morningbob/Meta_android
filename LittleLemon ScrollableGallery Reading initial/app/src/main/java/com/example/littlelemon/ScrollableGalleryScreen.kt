package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun scrollableGalleryScreen() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        repeat(2) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                repeat(2) {
                    galleryCell()
                }
            }

        }
    }
}

@Composable
fun galleryCell() {
    Card(elevation = 16.dp, modifier = Modifier.padding(8.dp)) {
        Box(modifier = Modifier
            .requiredSize(width = 180.dp, height = 180.dp)
            .padding(8.dp)) {
            Image(painter = painterResource(id = R.drawable.greeksalad), contentDescription = "Green Salad")
            Text(text = "12.99", fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.BottomEnd))
        }
    }
}