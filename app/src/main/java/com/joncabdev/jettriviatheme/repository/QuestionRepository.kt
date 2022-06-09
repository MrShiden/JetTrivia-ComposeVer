package com.joncabdev.jettriviatheme.repository


import android.util.Log
import com.joncabdev.jettriviatheme.data.DataOrException
import com.joncabdev.jettriviatheme.model.QuestionItem
import com.joncabdev.jettriviatheme.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api:QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()
    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>,Boolean,Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false


        }catch (exception:Exception){
            dataOrException.e = exception
            Log.d("Exc", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")

        }

        return dataOrException
    }

}