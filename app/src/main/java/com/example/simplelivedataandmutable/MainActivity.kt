package com.example.simplelivedataandmutable

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplelivedataandmutable.databinding.ActivityMainBinding



class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewModelClass::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.startingTitle.observe(this) { it ->
            binding.textTitle.text = it.toString()
        }
        viewModel.startingResult.observe(this) { it ->
            binding.textResult.text = it.toString()
        }

        binding.buttonAdd.setOnClickListener {
            val userInput = binding.editInput.text.toString()
            if (userInput.isEmpty()){
                Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show()
            }else {
                val number = userInput.toInt()
                viewModel.setOperation(number, '+')
            }
        }
        binding.buttonMinus.setOnClickListener {
            val userInput = binding.editInput.text.toString()
            if (userInput.isEmpty()){
                Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show()
            }else{
                val number = userInput.toInt()
                viewModel.setOperation(number, '-')
            }
        }
        binding.buttonTimes.setOnClickListener {
            val userInput = binding.editInput.text.toString()
            if(userInput.isEmpty()) {
                Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show()
            }else {
                val number = userInput.toInt()
                viewModel.setOperation(number, '*')
            }
        }
        binding.buttonDivide.setOnClickListener {
            val userInput = binding.editInput.text.toString()
            if (userInput.isEmpty()){
                Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show()
            }else {
                val number = userInput.toInt()
                viewModel.setOperation(number, '/')
            }
        }
    }

}