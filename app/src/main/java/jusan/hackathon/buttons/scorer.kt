package jusan.hackathon.buttons

const val rock = "Rock"
const val paper = "Paper"
const val scissors = "Scissors"

fun scorer(playerAction: String, computerAction: String): Int {
    // winner is if; 1: player, 0: computer, 2: tie
    var win = 0
    if (playerAction == computerAction)
        win = 2
    else if (playerAction == rock && computerAction == paper)
        win = 0
    else if (playerAction == rock && computerAction == scissors)
        win = 1
    else if (playerAction == paper && computerAction == rock)
        win = 1
    else if (playerAction == paper && computerAction == scissors)
        win = 0
    else if (playerAction == scissors && computerAction == paper)
        win = 1
    else if (playerAction == scissors && computerAction == rock)
        win = 0
    return win
}