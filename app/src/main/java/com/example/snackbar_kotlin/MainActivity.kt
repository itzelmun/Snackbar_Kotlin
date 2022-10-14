package com.example.snackbar_kotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_1.setOnClickListener {

            Snackbar.make(
                linearLayout, "Este es un mensaje simple en snackbar",
                Snackbar.LENGTH_LONG
            )
                .show()
        }


        button_2.setOnClickListener {
            Snackbar.make(
                linearLayout, "Snackbar con acciones",
                Snackbar.LENGTH_LONG
            ).setAction(
                "Mostrar ahora"
            ){
                Toast.makeText(applicationContext, "Estas viendo la nueva acción", Toast.LENGTH_LONG).show()
                linearLayout.setBackgroundColor(Color.parseColor("#f2f2f2"))
                txt_titulo.setBackgroundColor(Color.parseColor("#000000"))
            }.show()
        }

        button_3.setOnClickListener {

            val snackbar = Snackbar.make(
                linearLayout, "Esto es un snackbar que te redirige a otra activity",
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction("Ir"){
                val intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)
                snackbar.dismiss()
            }
            snackbar.show()
        }
    }
}