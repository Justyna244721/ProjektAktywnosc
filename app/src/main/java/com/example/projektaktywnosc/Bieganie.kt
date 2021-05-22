package com.example.projektaktywnosc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Bieganie : AppCompatActivity() {
    private var planT: Button?=null
    private var zmienP: Button?=null
    private var stworzP: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bieganie)
        planT=findViewById(R.id.planT)
        zmienP=findViewById(R.id.zmienP)
        stworzP=findViewById(R.id.stworzP)


        planT?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openPlanT()
            }
        })
        zmienP?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openStronadoRestracji()
            }
        })
        stworzP?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openStworzP()
            }
        })
    }
    private fun openPlanT(){
        val intent= Intent(this,PlanT::class.java)
        startActivity(intent)
    }
    private fun openStronadoRestracji() {
        val intent = Intent(this, StronadoRestracji::class.java)
        startActivity(intent)
    }
    private fun openStworzP() {
        val intent = Intent(this, StworzP::class.java)
        startActivity(intent)
    }


}