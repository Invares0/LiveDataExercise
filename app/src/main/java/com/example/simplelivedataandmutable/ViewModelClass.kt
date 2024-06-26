package com.example.simplelivedataandmutable

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModelClass (application: Application): AndroidViewModel(application){
    private val _startingTitle = MutableLiveData<String>("")
    val startingTitle: LiveData<String>
        get() = _startingTitle

    private val _startingResult = MutableLiveData<Int>(0)
    val startingResult: LiveData<Int>
        get() = _startingResult


    fun setOperation(input: Int, operation: Char){
        when(operation){
            '+' -> _startingResult.value = (startingResult.value)?.plus(input)
            '-' -> _startingResult.value = (startingResult.value)?.minus(input)
            '*' -> _startingResult.value = (startingResult.value)?.times(input)
            '/' -> _startingResult.value = (startingResult.value)?.div(input)
        }
    }
}
