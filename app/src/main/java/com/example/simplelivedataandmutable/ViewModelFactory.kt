package com.example.simplelivedataandmutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory (private val startingTitle: String, private val startingResult: Int)
    : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelClass::class.java)){
            return ViewModelClass(startingTitle, startingResult) as T
        }
        throw IllegalArgumentException("Error bo nie działa klamra bez niej")
    }
}