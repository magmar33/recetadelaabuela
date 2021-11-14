package com.example.recetadelaabuela.presentation.creation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recetadelaabuela.R
import com.example.recetadelaabuela.domain.Receta
import java.util.*

class CreationActivity  : AppCompatActivity(), CreationController.View, View.OnClickListener {

    private lateinit var presenter: CreationPresenter

    private lateinit var etName : TextView
    private lateinit var etSteps : TextView
    private lateinit var etIngredients: TextView
    private lateinit var etTime: TextView

    private lateinit var btnEnviar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creation)

        presenter = CreationPresenter(this, this)

        etName = findViewById(R.id.etName)
        etSteps = findViewById(R.id.etSteps)
        etIngredients = findViewById(R.id.etIngredients)
        etTime = findViewById(R.id.etTime)

        btnEnviar = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener(this)
    }

    override fun success() {
        finish()
    }

    override fun error(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view : View) {
        when(view.id){
            R.id.btnEnviar ->{
                val id = UUID.randomUUID().toString()
                val name = etName.text.toString()
                val steps = etSteps.text.toString()
                val ingredients = etIngredients.text.toString()
                val time = etTime.text.toString()

                val receta = Receta(id,name,steps,ingredients,time)
                presenter.createReceta(receta)
            }
        }
    }
}