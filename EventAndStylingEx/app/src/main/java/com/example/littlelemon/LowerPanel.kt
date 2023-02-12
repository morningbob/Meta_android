package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LowerPanel() {
    Column {
        WeeklySpecial()
        MenuDish()
    }
}


@Composable
fun WeeklySpecial(){
    // to be defined
    val paddingModifier = Modifier
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Weekly Special", fontSize = 26.sp, modifier = Modifier.padding(8.dp))
    }
}


@Composable
fun MenuDish() {
    // to be defined
    Card() {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Column() {
                Text(text = "Green Salad", fontSize = 18.sp)
                Text(text = "The famous Greek salad of crispy lettuce, peppers, olives, our Chicago ...",
                color = Color.Gray, modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f))
                Text(text = "12.99", color = Color.Gray)
            }
            Image(painterResource(id = R.drawable.greeksalad), contentDescription = "Greek Salad Image")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    LowerPanel()
}
