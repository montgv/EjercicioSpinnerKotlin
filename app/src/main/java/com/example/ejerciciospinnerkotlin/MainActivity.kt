package com.example.ejerciciospinnerkotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciospinnerkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private lateinit var binding: ActivityMainBinding

    //Este metodo es el metodo que se llama para que comience el activity
    override fun onCreate(savedInstanceState: Bundle?) {
        //Estas lineas hace que se nos vincule las vistas con el activity
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creamos un adaptador, que devolve una vista para cada objeto de una colección de objetos
        //de datos, es decir, para las diferentes opciones del spinner
        val adapter = ArrayAdapter.createFromResource(this, R.array.operacionesSpinner, R.layout.mi_spinner)
        adapter.setDropDownViewResource(R.layout.mi_spinner)
        //Asociamos con el binding al spinner con el metodo adapter para que use ese adaptador
        binding.spinner.adapter = adapter
        //Definimos un escuchador para cuando pulsemos el spinner y seleccionemos una opcion haga lo
        //que se va a definir dentro del metodo onItemSelectedListener
        binding.spinner.onItemSelectedListener = this
    }

    //Definimos el metodo onItemSelectedListener que tiene que hacer
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //Creamos una variable inmutable operacion para que muestre  los elementos cargados en el adaptador
        val operacion = parent?.getItemAtPosition(position)
        //Creacion de variables inmutables para los dos valores
        val valor1: Int
        val valor2: Int
        //Tenemos diferentes if donde le estamos diciendo que si operación es igual a los nombre de
        //las diferentes operaciones tiene que hacer determinadas cosas para que muestre el resultado
        //por el componente txtResultado
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