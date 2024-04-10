package jusan.hackathon.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jusan.hackathon.gameScreen.menuScreen.botGame.GameScreen
import jusan.hackathon.gameScreen.menuScreen.chooseModGame.ChooseModeScreen
import jusan.hackathon.gameScreen.menuScreen.onlineGame.onLineGameScreen

@Composable
fun Routing(
    modifier: Modifier
){
    val navController = rememberNavController()
    NavHost(navController, "/choosemode"){
        composable("/choosemode"){
            ChooseModeScreen(
                onPlayOnline = { navController.navigate("/game/online")},
                onPlayBot = {navController.navigate("/computer")
                }
            )
        }
        composable("/computer"){
            GameScreen()
        }
        composable("/game/online"){
            onLineGameScreen()
        }
    }

}