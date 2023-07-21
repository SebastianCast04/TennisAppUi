package com.example.tennisui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tennisui.ui.theme.TennisUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TennisUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {

    val clubs = listOf(
        Club(
            "Woman's Club",
            colorResource(id = R.color.women),
            painterResource(id = R.drawable.serena3)
        ),
        Club(
            "Men's Club",
            colorResource(id = R.color.men),
            painterResource(id = R.drawable.rafa2)
        )
    )
    TennisUiTheme() {

        Scaffold(
            backgroundColor = Color.White,
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Transparent,
                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
                    elevation = 0.dp
                ) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .clip(RoundedCornerShape(25))
                            .background(Color.Black),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu Botton",
                            tint = Color.White
                        )

                    }

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search Button",
                            tint = Color.Black,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(start = 24.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.clubs),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(clubs) {

                        ClubItem(it)
                    }
                }

                Spacer(Modifier.size(12.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp, bottom = 18.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Train",
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.h5.fontSize,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Alles",
                        color = colorResource(id = R.color.green),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column {
                    for (i in 1..2) {
                        TrainItem()
                    }
                }


            }
        }

    }

}

@Composable
fun TrainItem() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color.LightGray)
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.lotus),
                contentDescription = "ball"
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Column {

            Text(
                text = "Yoga and Tennis",
                color = Color.Black,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Feb 27 | 10:00 am - 11:00 am",
                color = Color.LightGray,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 5.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "10$",
                color = Color.White,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(7.dp)
            )
        }
    }

}

// Generate elements for the lazy row
@Composable
fun ClubItem(club: Club) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .background(club.color),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp)
                .padding(top = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(modifier = Modifier.width(150.dp)) {

                Text(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = club.title,
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h4.fontSize,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(backgroundColor = Color.White),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.all_levels),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(180.dp))

                Text(
                    text = stringResource(id = R.string.events),
                    color = Color.Black,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    modifier = Modifier.padding(bottom = 50.dp)
                )


            }

            Image(
                painter = club.image,
                contentDescription = "woman's club image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(end = 15.dp)
                    .padding(bottom = 25.dp)

            )


        }
    }

}

data class Club(
    var title: String,
    var color: Color,
    var image: Painter
)

