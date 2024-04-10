package jusan.hackathon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import jusan.hackathon.ui.theme.BackgroundGradient1
import jusan.hackathon.ui.theme.BackgroundGradient2
import jusan.hackathon.ui.theme.RockPaperScissorsTheme
import jusan.hackathon.ui.theme.Routing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RockPaperScissorsTheme {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(largeRadialGradient),
                    contentAlignment = Alignment.TopStart
                ) {
                        Routing(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(largeRadialGradient),
                        )
                    //GameScreen()
//                    Column(
//                       // verticalArrangement = Arrangement.spacedBy(0.dp)
//                    ) {
//
//                        Text(
//                            text = "ROCK",
//                            style = MaterialTheme.typography.titleLarge,
//                        )
//                        Text(
//                            text = "PAPER",
//                            style = MaterialTheme.typography.titleLarge
//                        )
//                        Text(
//                            text = "SCISSORS",
//                            style = MaterialTheme.typography.titleLarge,
//                        )
//
//                        PaperButton {}
//                        ScissorsButton {}
//                        RockButton(onClick = {})
//
//                    }
                }
            }
        }
    }
}

val largeRadialGradient = object : ShaderBrush() {
    override fun createShader(size: androidx.compose.ui.geometry.Size): Shader {
        val biggerDimension = maxOf(size.height, size.width)
        return RadialGradientShader(
            colors = listOf(BackgroundGradient1, BackgroundGradient2),
            center = size.center,
            radius = biggerDimension / 2f,
            colorStops = listOf(0f, 0.95f)
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Thursdaytrivia2Theme {
//        Rockpaper()
//    }
//}

//val  fontName = GoogleFont("Barlow Semi Condensed")
//
//val fontFamily = FontFamily(
//    Font(
//        googleFont = fontName,
//        fontProvider = provider,
//        weight = FontWeight.Bold,
//        style = FontStyle.Italic
//    )
//)