package com.example.projektaktywnosc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar

class Waga : AppCompatActivity() {

    private  var wagaaktualna:EditText?=null
    private var progressbar:ProgressBar?=null
    private var wagaprzycisk:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waga)

        wagaaktualna=findViewById(R.id.wagaaktualna)
        progressbar=findViewById(R.id.wagaprogressbar) as ProgressBar
        wagaprzycisk=findViewById(R.id.wagapotwierdzenie)

        FireStoreClass().getUserDetails(this)

        wagaprzycisk?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {


            }
        })




    }


}