package com.example.projektaktywnosc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Bieganie : AppCompatActivity() {
    private var planT: Button?=null
    private var planTSZ: Button?=null
    private var planTZ: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bieganie)
        planT=findViewById(R.id.planT)
        planTSZ=findViewById(R.id.planTSZ)
        planTZ=findViewById(R.id.planTZ)

        planT?.setOnClickListener { setContentView(R.layout.activity_plan_t)}
        planTSZ?.setOnClickListener { setContentView(R.layout.activity_plan_tsz) }
        planTZ?.setOnClickListener { setContentView(R.layout.activity_plan_tz) }
    }
}