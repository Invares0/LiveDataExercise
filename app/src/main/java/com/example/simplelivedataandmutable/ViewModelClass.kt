package com.example.simplelivedataandmutable

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModelClass (startingTitle: String, startingResult: Int): ViewModel(){
    private val _startingTitle = MutableLiveData<String>(startingTitle)
    val startingTitle: LiveData<String>
        get() = _startingTitle

    private val _startingResult = MutableLiveData<Int>(startingResult)
    val startingResult: LiveData<Int>
        get() = _startingResult


    fun setOperation(input: Int, operation: Char){
        when(operation){
            '+' -> _startingResult.value = (startingResult.value)?.plus(input)
            '-' -> _startingResult.value = (startingResult.value)?.minus(input)
        }
    }
}
