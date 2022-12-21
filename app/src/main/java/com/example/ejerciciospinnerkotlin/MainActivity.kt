package com.example.ejerciciospinnerkotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciospinnerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter.createFromResource(this, R.array.operacionesSpinner, R.layout.mi_spinner)
        adapter.setDropDownViewResource(R.layout.mi_spinner)
        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val operacion = parent?.getItemAtPosition(position)
        val valor1: Int
        val valor2: Int

        if (operacion == "Suma") {
            valor1 = binding.txtValor1.text.toString().toInt()
            valor2 = binding.txtValor2.text.toString().toInt()
            binding.txtResultado.text = (valor1 + valor2).toString()
        } else if (operacion == "Resta") {
            valor1 = binding.txtValor1.text.toString().toInt()
            valor2 = binding.txtValor2.text.toString().toInt()
            binding.txtResultado.text = (valor1 - valor2).toString()
        } else if (operacion == "Multiplicación") {
            valor1 = binding.txtValor1.text.toString().toInt()
            valor2 = binding.txtValor2.text.toString().toInt()
            binding.txtResultado.text = (valor1 * valor2).toString()
        } else if (operacion == "División") {
            valor1 = binding.txtValor1.text.toString().toInt()
            valor2 = binding.txtValor2.text.toString().toInt()
            if (valor2 == 0) {
                binding.txtResultado.text = "No se puede dividir por 0"
            } else {
                binding.txtResultado.text = (valor1 / valor2).toString()
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}