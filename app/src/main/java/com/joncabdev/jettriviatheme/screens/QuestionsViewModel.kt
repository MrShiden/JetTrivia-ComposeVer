package com.joncabdev.jettriviatheme.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joncabdev.jettriviatheme.data.DataOrException
import com.joncabdev.jettriviatheme.model.QuestionItem
import com.joncabdev.jettriviatheme.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: QuestionRepository):ViewModel() {
    val data: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> = mutableStateOf(
        DataOrException(null,true,Exception(""))
    )

    init {
        getAllQuestions()
    }

    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions()
            if (data.value.toString().isNotEmpty()) data.value.loading = false



        }
    }

    fun getTotalQuestions():Int{
        return data.value.data?.toMutableList()?.size!!
    }
}