package com.example.recetadelaabuela.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recetadelaabuela.R
import com.example.recetadelaabuela.domain.Receta

class RecetaDetail : AppCompatActivity(), RecetaDetailController.View, View.OnClickListener {

    private lateinit var receta : Receta
    private lateinit var etName : TextView
    private lateinit var etSteps : TextView
    private lateinit var etIngredients: TextView
    private lateinit var etTime: TextView
    private lateinit var btnEnviar : Button
    private lateinit var presenter : RecetaDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        presenter = RecetaDetailPresenter(this,this)

        receta = intent.getSerializableExtra("receta") as Receta

        etName = findViewById(R.id.etName)
        etName.text = receta.name

        etSteps = findViewById(R.id.etSteps)
        etSteps.text = receta.steps

        etIngredients = findViewById(R.id.etIngredients)
        etIngredients.text = receta.ingredients

        etTime = findViewById(R.id.etTime)
        etTime.text = receta.time

        btnEnviar = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener(this)

    }

    override fun success() {
    finish()
    }

    override fun error(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnEnviar -> {

                val name = etName.text.toString()
                val steps = etSteps.text.toString()
                val ingredients = etIngredients.text.toString()
                val time = etTime.text.toString()

                receta.name = name
                receta.steps = steps
                receta.ingredients = ingredients
                receta.time = time

                presenter.saveUpdate(receta)
            }
        }
    }


}