package jusan.hackathon.gameScreen

data class GameState(
    var playerAction: String = "-",
    var computerAction: String = "-",
    var totalScore: String = "0 / 0",
    var playerScore: Int = 0,
    var computerScore: Int = 0
)
