package jusan.hackathon.gameScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jusan.hackathon.buttons.PaperButton
import jusan.hackathon.buttons.RockButton
import jusan.hackathon.buttons.ScissorsButton
import jusan.hackathon.buttons.scorer
import kotlin.random.Random

@Composable
fun GameScreen() {
    val gameState by remember { mutableStateOf(GameState()) }

    Column {
        Text(
            text = "Score", fontSize = 30.sp, modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        )
        Text(
            text = gameState.totalScore, fontSize = 50.sp, modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )

        Row(modifier = Modifier.padding(top = 85.dp)) {
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                PlayerAction(player = "Your Choice", action = gameState.playerAction)
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                PlayerAction(player = "Computer Choice", action = gameState.computerAction)
            }

        }
        Row(modifier = Modifier.padding(top = 70.dp)) {
            Column(
                Modifier
                    .fillMaxWidth(0.33f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                RockButton{
                    gameState.playerAction = "Rock"
                    gameState.computerAction = generateActionForComputer()
                    val win = scorer(gameState.playerAction, gameState.computerAction)
                    if (win == 1)
                        gameState.playerScore++
                    else if (win == 0)
                        gameState.computerScore++
                    gameState.totalScore = "${gameState.playerScore} / ${gameState.computerScore}"
                }
            }
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                PaperButton {
                    gameState.playerAction = "Paper"
                    gameState.computerAction = generateActionForComputer()
                    val win = scorer(gameState.playerAction, gameState.computerAction)
                    if (win == 1)
                        gameState.playerScore++
                    else if (win == 0)
                        gameState.computerScore++
                    gameState.totalScore = "${gameState.playerScore} / ${gameState.computerScore}"
                }
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                ScissorsButton {
                    gameState.playerAction = "Scissors"
                    gameState.computerAction = generateActionForComputer()
                    val win = scorer(gameState.playerAction, gameState.computerAction)
                    if (win == 1)
                        gameState.playerScore++
                    else if (win == 0)
                        gameState.computerScore++
                    gameState.totalScore = "${gameState.playerScore} / ${gameState.computerScore}"
                }
            }
        }

        Spacer(modifier = Modifier.size(80.dp))
        Button(
            onClick = {
                gameState.playerScore = 0
                gameState.computerScore = 0
                gameState.totalScore = "0 / 0"
                gameState.playerAction = "-"
                gameState.computerAction = "-"
            },
            modifier = Modifier
                .padding(start = 100.dp)
                .size(width = 200.dp, height = 100.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(text = "Restart", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun PlayerAction(player: String, action: String) {
    Text(
        text = player,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
    Text(
        text = action,
        fontSize = 32.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally),
        fontWeight = FontWeight.Bold
    )
}

fun generateActionForComputer(): String {
    val list = listOf("Rock", "Paper", "Scissor")
    val randomIndex = Random.nextInt(list.size)
    return list[randomIndex]
}