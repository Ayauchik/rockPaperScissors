package jusan.hackathon.di

import jusan.hackathon.gameScreen.GameScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{ GameScreenViewModel() }
}