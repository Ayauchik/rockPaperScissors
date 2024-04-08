package jusan.hackathon.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import jusan.hackathon.R
import jusan.hackathon.ui.theme.paperColor
import jusan.hackathon.ui.theme.rockColor
import jusan.hackathon.ui.theme.scissorsColor

@Composable
fun RockButton(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable { onClick() },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .border(
                    BorderStroke(width = 10.dp, color = rockColor),
                    shape = CircleShape,
                )
                .shadow(
                    elevation = 7.dp,
                    shape = AbsoluteRoundedCornerShape(
                        topLeftPercent = 99,
                        topRightPercent = 100,
                        bottomLeftPercent = 100,
                        bottomRightPercent = 100
                    ),
                    clip = true,
                    ambientColor = Color.Black,
                    spotColor = Color.Red,
                )
                .size(120.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.rock),
                contentDescription = "rock button",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize(.4f)
            )
        }
    }
}


@Composable
fun PaperButton(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable { onClick() },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .border(
                    BorderStroke(width = 10.dp, color = paperColor),
                    shape = CircleShape,
                )
                .shadow(
                    elevation = 8.dp,
                    shape = AbsoluteRoundedCornerShape(
                        topLeftPercent = 99,
                        topRightPercent = 100,
                        bottomLeftPercent = 100,
                        bottomRightPercent = 100
                    ),
                    clip = true,
                    ambientColor = Color.Black,
                    spotColor = Color.Blue,
                )
                .size(120.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.paper),
                contentDescription = "paper button",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize(.4f)
            )
        }
    }
}


@Composable
fun ScissorsButton(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(120.dp)
            .clickable { onClick() },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier
                .border(
                    BorderStroke(width = 10.dp, color = scissorsColor),
                    shape = CircleShape,
                )
                .shadow(
                    elevation = 8.dp,
                    shape = AbsoluteRoundedCornerShape(
                        topLeftPercent = 99,
                        topRightPercent = 100,
                        bottomLeftPercent = 100,
                        bottomRightPercent = 100
                    ),
                    clip = true,
                    ambientColor = Color.Black,
                    spotColor = Color(0xFFCC7722),
                )
                .size(120.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.scissors),
                contentDescription = "rock button",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize(.4f)
            )
        }
    }
}