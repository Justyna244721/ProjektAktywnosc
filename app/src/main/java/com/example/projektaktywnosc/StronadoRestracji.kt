package com.example.projektaktywnosc

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class StronadoRestracji : Informacjerejestracja() {
    private var logowanie: Button?=null
    private var email:EditText?=null
    private var haslo:EditText?=null
    private var powhaslo:EditText?=null
    private var wzrost1: EditText?=null
    private var wiek1:EditText?=null
    private var idealnawaga:EditText?=null
    private var kobieta: CheckBox?=null
    private var mezczyzna: CheckBox?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stronado_restracji)
        logowanie= findViewById(R.id.button3)
        email=findViewById(R.id.email)
        haslo=findViewById(R.id.haslo)
        powhaslo=findViewById(R.id.powtorzhaslo)
        wzrost1=findViewById(R.id.wzrost1)
        wiek1=findViewById(R.id.wiek1)
        idealnawaga=findViewById(R.id.idealnawaga)
        kobieta=findViewById(R.id.kobieta)
        mezczyzna=findViewById(R.id.mezczyzna)



        logowanie?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                registerUser()
                //openStronaGlowna()
            }
        })




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

            TextUtils.isEmpty(powhaslo?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_reppassword),true)
                false
            }

            haslo?.text.toString().trim {it <= ' '} != powhaslo?.text.toString().trim{it <= ' '} -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_password_mismatch),true)
                false
            }
            TextUtils.isEmpty(wiek1?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_wiek),true)
                false
            }
            TextUtils.isEmpty(wzrost1?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_wzrost),true)
                false
            }
            TextUtils.isEmpty(idealnawaga?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_idealnawaga),true)
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

                       val user = User(
                            firebaseUser.uid,

                            email?.text.toString().trim() {it <= ' '},
                            wiek1?.text.toString().trim() {it <= ' '},
                            wzrost1?.text.toString().trim() {it <= ' '},
                            idealnawaga?.text.toString().trim() {it <= ' '},

                        )


                       FireStoreClass().registerUser(this,user)

                        showErrorSnackBar("Twoja rejestracja przebiegła pomyślnie.",false)
                        //FirebaseAuth.getInstance().signOut()




                    } else{
                        showErrorSnackBar(task.exception!!.message.toString(),true)
                    }
                    if(task.isSuccessful){
                        Handler().postDelayed({openStronaGlowna()},1000)
                    }
                }
            )
        }
    }

    //Przejście do strony Głównej
    private fun openStronaGlowna(){
        val intent= Intent(this,StronaGlowna::class.java)
        startActivity(intent)
    }
    fun userRegistrationSuccess(){

        Toast.makeText(
            this@StronadoRestracji,
            resources.getString(R.string.register_success),
            Toast.LENGTH_SHORT
        ).show()

    }



}