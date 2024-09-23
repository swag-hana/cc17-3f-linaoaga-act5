package com.example.testartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testartspace.ui.theme.TestArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TestArtSpaceMain()
                }
            }
        }
    }

    @Composable
    fun ArtWithTitle(
        ArtPicture: Int,
        ArtTitle: String,
        ArtistName: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = ArtPicture),
                contentDescription = null,
                modifier = Modifier
                    .padding(20.dp)
                    .height(300.dp)
                    .width(300.dp)
                    .shadow(elevation = 4.dp)
                    .padding(10.dp)
            )
            Card(
                modifier = Modifier
                    .padding(horizontal = 45.dp, vertical = 90.dp)

            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = ArtTitle,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Start,
                        lineHeight = 30.sp
                    )
                    Text(
                        text = ArtistName,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }

    @Composable
    fun TestArtSpaceMain() {
        var result by remember {
            mutableStateOf(0)
        }
        when (result) {
            1 -> ArtWithTitle(
                ArtPicture = R.drawable.artwork1,
                ArtTitle = stringResource(R.string.StarryNight),
                ArtistName = stringResource(id = R.string.VincentvanGogh)
            )

            2 -> ArtWithTitle(
                ArtPicture = R.drawable.artwork2,
                ArtTitle = stringResource(R.string.MonaLisa),
                ArtistName = stringResource(id = R.string.LeonardodaVinci)
            )

            3 -> ArtWithTitle(
                ArtPicture = R.drawable.artwork3,
                ArtTitle = stringResource(R.string.TPersistanceofMemory),
                ArtistName = stringResource(id = R.string.SalvadorDalí)
            )

            4 -> ArtWithTitle(
                ArtPicture = R.drawable.artwork4,
                ArtTitle = stringResource(R.string.TScream),
                ArtistName = stringResource(id = R.string.EdvardMunch)
            )

            5 -> ArtWithTitle(
                ArtPicture = R.drawable.artwork5,
                ArtTitle = stringResource(R.string.GirlPearlEarring),
                ArtistName = stringResource(id = R.string.JohannesVermeer)
            )

            else -> ArtWithTitle(
                ArtPicture = R.drawable.artwork6,
                ArtTitle = stringResource(R.string.TheBirthofVenus),
                ArtistName = stringResource(id = R.string.SandroBotticelli)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 700.dp)
        ) {
            Button(
                onClick = { result-- },
                shape = RoundedCornerShape(50.dp),
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = { result++ },
                shape = RoundedCornerShape(50.dp),
            ) {
                Text(text = "Next")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TestArtSpaceTheme {
            TestArtSpaceMain()
        }
    }
}