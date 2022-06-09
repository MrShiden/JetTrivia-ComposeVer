package com.joncabdev.jettriviatheme.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.joncabdev.jettriviatheme.component.Questions


@Composable
fun TriviaHome(viewModel:QuestionsViewModel = hiltViewModel()){

    Questions(viewModel)


}