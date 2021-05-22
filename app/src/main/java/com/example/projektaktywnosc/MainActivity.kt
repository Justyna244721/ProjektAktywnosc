package com.example.projektaktywnosc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var button: Button?=null
    private var button2: Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button=findViewById(R.id.button)
        button2=findViewById(R.id.button2)

        //przycisk do strony Głównej
        button?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openStronaGlowna()
            }
        })
        //przycisk do strony z Rejestracją
        button2?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openStronadoRestracji()
            }
        })


        }
    //Przejscie do strony z Rejestracją
    private fun openStronadoRestracji(){
        val intent= Intent(this,StronadoRestracji::class.java)
        startActivity(intent)
    }
    //Przejście do strony Głównej
    private fun openStronaGlowna(){
        val intent= Intent(this,StronaGlowna::class.java)
        startActivity(intent)
    }
}