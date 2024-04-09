package jusan.hackathon.buttons

fun scorer(playerAction: String, computerAction: String): Int {
    // winner is if; 1: player, 0: computer, 2: tie
    var win = 0
    if (playerAction == computerAction)
        win = 2
    else if (playerAction == "Rock" && computerAction == "Paper")
        win = 0
    else if (playerAction == "Rock" && computerAction == "Scissor")
        win = 1
    else if (playerAction == "Paper" && computerAction == "Rock")
        win = 1
    else if (playerAction == "Paper" && computerAction == "Scissor")
        win = 0
    else if (playerAction == "Scissor" && computerAction == "Paper")
        win = 1
    else if (playerAction == "Scissor" && computerAction == "Rock")
        win = 0
    return win
}