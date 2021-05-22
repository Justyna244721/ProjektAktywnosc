package com.example.projektaktywnosc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Silownia : AppCompatActivity() {
    private var dolnaPC: Button?=null
    private var caleC: Button?=null
    private var gornaPC: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_silownia)
        dolnaPC=findViewById(R.id.dolnaPC)
        caleC=findViewById(R.id.caleC)
        gornaPC=findViewById(R.id.gornaPC)

        dolnaPC?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openDolnaPC()
            }
        })
        caleC?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openCaleC()
            }
        })
        gornaPC?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openGornaPC()
            }
        })
    }
    private fun openDolnaPC(){
        val intent= Intent(this,DolnaPC::class.java)
        startActivity(intent)
    }
    private fun openCaleC() {
        val intent = Intent(this, CaleC::class.java)
        startActivity(intent)
    }
    private fun openGornaPC() {
        val intent = Intent(this, GornaPC::class.java)
        startActivity(intent)
    }
}