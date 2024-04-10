package jusan.hackathon.di

import jusan.hackathon.gameScreen.menuScreen.botGame.GameScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ GameScreenViewModel() }
}