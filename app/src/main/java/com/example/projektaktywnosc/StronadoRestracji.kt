package com.example.projektaktywnosc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class StronadoRestracji : AppCompatActivity() {
    private var logowanie: Button?=null
    private var wyjscie: Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stronado_restracji)
        logowanie= findViewById(R.id.button3)


        logowanie?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openStronaGlowna()
            }
        })


    }
    //Przejście do strony Głównej
    private fun openStronaGlowna(){
        val intent= Intent(this,StronaGlowna::class.java)
        startActivity(intent)
    }



}