package jusan.hackathon.gameScreen.menuScreen.botGame

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import jusan.hackathon.buttons.PaperButton
import jusan.hackathon.buttons.RockButton
import jusan.hackathon.buttons.ScissorsButton
import org.koin.androidx.compose.get
import kotlin.math.max
import kotlin.random.Random

@Composable
fun GameScreen(
    gameScreenViewModel: GameScreenViewModel = get()
) {
    val gameState = gameScreenViewModel.gameState.value

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
        var index = 1
        Row(modifier = Modifier.padding(top = 70.dp)) {
            Column(
                Modifier
                    .fillMaxWidth(0.33f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                RockButton {
                    gameScreenViewModel.onPlayerMove(rock)
                    index++
                }
            }
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                PaperButton {
                    gameScreenViewModel.onPlayerMove(paper)
                    index++
                }
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                ScissorsButton {
                    gameScreenViewModel.onPlayerMove(scissors)
                    index++
                }
            }
        }

        Spacer(modifier = Modifier.size(60.dp))

        val maxDisplayedMoves = 3
        val startIndex = max(0, gameState.moveHistory.size - maxDisplayedMoves)
        val endIndex = gameState.moveHistory.size - 1
        val displayedMoves = gameState.moveHistory.subList(startIndex, endIndex + 1)
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Move History", fontSize = 24.sp, modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.size(8.dp))
            displayedMoves.forEachIndexed { index, move ->
                Text(
                    text = "${startIndex + index + 1}. Player: ${move.playerAction}, Computer: ${move.computerAction}, Result: ${move.result}",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }


        Spacer(modifier = Modifier.size(8.dp))
        Button(
            onClick = {
                gameScreenViewModel.resetGame()
            },
            modifier = Modifier
                .padding(start = 100.dp)
                .size(width = 200.dp, height = 100.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(text = "Restart", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            index = 0
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
    val list = listOf(rock, paper, scissors)
    val randomIndex = Random.nextInt(list.size)
    return list[randomIndex]
}

const val rock = "Rock"
const val paper = "Paper"
const val scissors = "Scissors"