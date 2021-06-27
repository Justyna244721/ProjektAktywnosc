package com.example.projektaktywnosc

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Waga : Informacjerejestracja() {

    private lateinit var wagaaktualna:EditText
    private lateinit var progressbar:ProgressBar
    private var wagaprzycisk:Button?=null
    private var procentwaga:TextView?=null




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waga)

        wagaaktualna=findViewById(R.id.wagaaktualna)
        progressbar=findViewById(R.id.wagaprogressbar) as ProgressBar
        wagaprzycisk=findViewById(R.id.wagapotwierdzenie)
        procentwaga=findViewById(R.id.procentwaga)

        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter)



        FireStoreClass().getUserDetails(this)







        wagaprzycisk?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                if(wodainformacjedoguzika()) {
                var wa=wagaaktualna.toString().toInt()

                }
            }
        })




    }
    fun idealnawaga(user: User){

        procentwaga?.text = " Twoja idealna waga ${user.idealnawaga} kg"

    }

    private fun wodainformacjedoguzika(): Boolean {

        return when{
            TextUtils.isEmpty(wagaaktualna?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_brakwagi), true)
                false
            }


            else -> {

                //showErrorSnackBar("Your details are valid",false)
                true
            }
        }


    }


}