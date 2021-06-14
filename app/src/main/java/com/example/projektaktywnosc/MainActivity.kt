package com.example.projektaktywnosc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class MainActivity : Informacjerejestracja() {

    private var button: Button?=null
    private var button2: Button?=null
    private var email: EditText?=null
    private var haslo:EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button=findViewById(R.id.button)
        button2=findViewById(R.id.button2)
        email=findViewById(R.id.emailLog)
        haslo=findViewById(R.id.hasloLog)

        //przycisk do strony Głównej
        button?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                logInRegisteredUser()
            }
        })
        //przycisk do strony z Rejestracją
        button2?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                openStronadoRestracji()
            }
        })


        }

    private fun validateLoginDetails(): Boolean {

        return when{
            TextUtils.isEmpty(email?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }

            TextUtils.isEmpty(haslo?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password),true)
                false
            }

            else -> {
                //showErrorSnackBar("Your details are valid",false)
                true
            }
        }


    }
    private fun logInRegisteredUser(){


        if(validateLoginDetails()){
            val email1 = email?.text.toString().trim(){ it<= ' '}
            val password1 = haslo?.text.toString().trim(){ it<= ' '}

            //Log-in using FirebaseAuth

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email1,password1)
                .addOnCompleteListener{task ->

                    if(task.isSuccessful){
                        FireStoreClass().getUserDetails(this)
                        showErrorSnackBar("Zostałeś zalogowany", false)
                        //finish()
                        Handler().postDelayed({openStronaGłowna()},1000)

                    } else{
                        showErrorSnackBar(task.exception!!.message.toString(),true)
                    }
                }
        }
    }
    open fun goToMainActivity() {

        val user = FirebaseAuth.getInstance().currentUser;
        val uid = user?.email.toString()

        val intent = Intent(this, StronaGlowna::class.java)
        intent.putExtra("uID",uid)
        startActivity(intent)
    }

    fun userLoggedInSuccess(user: User){

        Log.i("Email: ", user.email)
        Log.i("Wiek: ", user.wiek1)
        Log.i("Wzrost: ", user.wzrost1)
        Log.i("Idealna waga: ", user.idealnawaga)




        goToMainActivity()
        finish()
    }

    //Przejscie do strony z Rejestracją
    private fun openStronadoRestracji(){
        val intent= Intent(this,StronadoRestracji::class.java)
        startActivity(intent)
    }

    //Przejscie do strony z Rejestracją
    private fun openStronaGłowna(){
        val intent= Intent(this,StronaGlowna::class.java)
        startActivity(intent)
    }

}