package com.example.projektaktywnosc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class StronaGlowna : AppCompatActivity() {

    private var bieganie: Button?=null
    private var silownia: Button?=null
    private var woda: Button?=null
    private  var sen: Button?=null
    private var waga: Button?=null
    private  var cel: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strona_glowna)
        bieganie= findViewById(R.id.bieganie)
        silownia= findViewById(R.id.silownia)
        woda= findViewById(R.id.woda)
        sen= findViewById(R.id.sen)
        waga= findViewById(R.id.waga)
        cel=findViewById(R.id.cel)

        bieganie?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openBieganie()
            }
        })
        silownia?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openSilownia()
            }
        })
        woda?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openWoda()
            }
        })
        sen?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openSen()
            }
        })
        waga?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openWaga()
            }
        })
        cel?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openCel()
            }
        })
    }
    private fun openBieganie(){
        val intent= Intent(this,Bieganie::class.java)
        startActivity(intent)
    }
    private fun openSilownia(){
        val intent= Intent(this,Silownia::class.java)
        startActivity(intent)
    }
    private fun openWoda(){
        val intent= Intent(this,Woda::class.java)
        startActivity(intent)
    }
    private fun openSen(){
        val intent= Intent(this,Sen::class.java)
        startActivity(intent)
    }
    private fun openWaga(){
        val intent= Intent(this,Waga::class.java)
        startActivity(intent)
    }
    private fun openCel(){
        val intent= Intent(this,Cel::class.java)
        startActivity(intent)
    }
}