package com.example.projektaktywnosc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*

class Sen : Informacjerejestracja() {
    private lateinit var potwierdzsen: Button
    private lateinit var iloscsen: EditText
    private lateinit var procentsen:TextView
    private lateinit var senprogresbar: ProgressBar
    private var progsen:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sen)

        potwierdzsen=findViewById(R.id.potwierdzsen)
        iloscsen=findViewById(R.id.iloscsen)
        procentsen=findViewById(R.id.procentsen)
        senprogresbar=findViewById(R.id.senprogresbar)

        potwierdzsen?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                if(wodainformacjedoguzika()){
                    var woda= iloscsen?.text.toString().trim(){ it<= ' '}


                    var sen1=iloscsen.text.toString().toInt()
                    progsen+=sen1
                    senprogresbar!!.progress=progsen


                    if (progsen>=8){

                        procentsen.setText("100%")
                        Toast.makeText(
                            this@Sen,
                            resources.getString(R.string.koniecsen),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else{
                        var procent=(100*progsen)/8
                        var procentstr=procent.toString()
                        procentsen.setText(procentstr+"%")
                    }



                    Toast.makeText(
                        this@Sen,
                        resources.getString(R.string.dodanysen),
                        Toast.LENGTH_SHORT
                    ).show()


                    iloscsen.text.clear()

                }
            }
        })


    }
    private fun wodainformacjedoguzika(): Boolean {

        return when{
            TextUtils.isEmpty(iloscsen?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_braksnu), true)
                false
            }


            else -> {
                //showErrorSnackBar("Your details are valid",false)
                true
            }
        }


    }
}