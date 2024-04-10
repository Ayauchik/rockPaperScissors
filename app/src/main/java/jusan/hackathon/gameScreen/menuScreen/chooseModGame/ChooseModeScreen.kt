package jusan.hackathon.gameScreen.menuScreen.chooseModGame

import android.graphics.Shader
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import jusan.hackathon.R
import jusan.hackathon.largeRadialGradient
import jusan.hackathon.ui.theme.BackgroundGradient1
import jusan.hackathon.ui.theme.BackgroundGradient2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseModeScreen(
    onPlayOnline: () -> Unit,
    onPlayBot: () -> Unit,
){
    Scaffold(
        modifier = Modifier
        .fillMaxSize()
        .background(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name))},
                actions = {

                },
                )
        },
    ){
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(24.dp)
            ){
                PlayOnlineButton(onClick = onPlayOnline)
                Spacer(modifier = Modifier.height(24.dp))
                PlayComputerButton(onClick = onPlayBot)
            }
        }
    }
}
@Composable
private fun PlayComputerButton(
    onClick: () -> Unit,
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                painter = painterResource(id = R.drawable.icon_comp),
                contentDescription = "Play Computer"
            )
            Spacer(modifier = Modifier.width(24.dp))
            Text(
                text = "Play Computer",
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }

}





@Composable
fun PlayOnlineButton(
    onClick: () -> Unit,
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(vertical = 16.dp)
                .padding(start = 16.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.size(42.dp),
                painter = painterResource(id = R.drawable.icon_online),
                contentDescription = null)
            Spacer(modifier = Modifier.width(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Play Online",
                    style = MaterialTheme.typography.titleMedium,
                )
//                if (inLobby != null) {
//                    Spacer(modifier = Modifier.width(40.dp))
//                    Text(
//                        text = stringResource(R.string.waiting, inLobby),
//                        style = MaterialTheme.typography.bodySmall,
//                    )
 //               }
            }
        }
    }
}


val argeRadialGradient = object : ShaderBrush() {
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
