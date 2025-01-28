package br.com.calculoimc

import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }

        val textresultadoImc = findViewById<TextView>(R.id.resultadoImc)
        val editaltura = findViewById<EditText>(R.id.altura)
        val editpeso = findViewById<EditText>(R.id.peso)


        fun fazercalculo(view: View) {


            val altura = editaltura.getText().toString()
            val peso = editpeso.getText().toString()

            if (altura.isEmpty() || peso.isEmpty()) {
                textresultadoImc.setText("Insira algum valor.")
                return
            }

            val alturaConvertida: Double = altura.toDouble() / 100
            val pesoConvertido: Double = peso.toDouble()


            if (pesoConvertido > 1 && pesoConvertido <= 700 && alturaConvertida > 0.1 && alturaConvertida <= 4.00) {

                val resultado = pesoConvertido / (alturaConvertida * alturaConvertida)
                val resultadoImc = BigDecimal(resultado).setScale(2, RoundingMode.HALF_UP)

                textresultadoImc.setText("IMC:$resultadoImc")

            } else {
                textresultadoImc.setText("Valor incorreto.")
            }
        }
    }







