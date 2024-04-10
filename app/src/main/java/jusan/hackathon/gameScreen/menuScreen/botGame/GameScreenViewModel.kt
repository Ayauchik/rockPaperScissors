package jusan.hackathon.gameScreen.menuScreen.botGame

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
//import dagger.hilt.android.lifecycle.HiltViewModel
import jusan.hackathon.buttons.scorer
import kotlinx.coroutines.launch
//import javax.inject.Inject

//@HiltViewModel
class GameScreenViewModel(): ViewModel() {
    private val _gameState = mutableStateOf(GameState())
    val gameState: MutableState<GameState> = _gameState

    fun onPlayerMove(playerAction: String) {
        val gameStateCopy = gameState.value.copy(playerAction = playerAction)
        gameState.value = gameStateCopy
        viewModelScope.launch {
            val computerAction = generateActionForComputer()
            val result = scorer(playerAction, computerAction)
            val newGameState = GameState(
                playerAction = playerAction,
                computerAction = computerAction,
                playerScore = if (result == 1) gameStateCopy.playerScore + 1 else gameStateCopy.playerScore,
                computerScore = if (result == 0) gameStateCopy.computerScore + 1 else gameStateCopy.computerScore,
                totalScore = "${if (result == 1) gameStateCopy.playerScore + 1 else gameStateCopy.playerScore} / ${if (result == 0) gameStateCopy.computerScore + 1 else gameStateCopy.computerScore}",
                moveHistory = gameStateCopy.moveHistory.toMutableList().apply {
                    add(MoveState(playerAction, computerAction, getResultText(result)))
                }
            )
            _gameState.value = newGameState
        }
    }

    fun resetGame() {
        _gameState.value = GameState()
    }

    private fun getResultText(result: Int): String {
        return when (result) {
            1 -> "Player wins"
            0 -> "Computer wins"
            else -> "Draw"
        }
    }

}
