package com.example.projektaktywnosc

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class StronadoRestracji : Informacjerejestracja() {
    private var logowanie: Button?=null
    private var wyjscie: Button?=null
    var email: EditText?=null
    private var haslo: EditText?=null
    private var powturzhaslo: EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        email=findViewById(R.id.email)
        haslo=findViewById(R.id.haslo)
        powturzhaslo=findViewById(R.id.powtorzhaslo)

        setContentView(R.layout.activity_stronado_restracji)
        logowanie= findViewById(R.id.button3)

        logowanie?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                registerUser()
            }
        })


    }

    //Przejście do strony Głównej
    private fun openStronaGlowna(){
        val intent= Intent(this,StronaGlowna::class.java)
        startActivity(intent)
    }

    private fun validateRegisterDetails(): Boolean {
        return when{
            TextUtils.isEmpty(email?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_login),true)
                false
            }
            TextUtils.isEmpty(haslo?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password),true)
                false
            }
            TextUtils.isEmpty(powturzhaslo?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_reppassword),true)
                false
            }
            haslo?.text.toString().trim {it <= ' '} != powturzhaslo?.text.toString().trim{it <= ' '} -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_password_mismatch),true)
                false
            }
            else -> {
                //showErrorSnackBar("Your details are valid",false)
                true
            }
        }
    }

    private fun registerUser(){
        if (validateRegisterDetails()){
            val login: String = email?.text.toString().trim() {it <= ' '}
            val password: String = haslo?.text.toString().trim() {it <= ' '}

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(login,password).addOnCompleteListener(
                OnCompleteListener <AuthResult>{ task ->
                    if(task.isSuccessful){
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        showErrorSnackBar("You are registered successfully. Your user id is ${firebaseUser.uid}",false)
                        openStronaGlowna()

                    } else{
                        showErrorSnackBar(task.exception!!.message.toString(),true)
                    }
                }
            )
        }
    }
}