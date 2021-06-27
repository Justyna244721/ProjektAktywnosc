package com.example.projektaktywnosc

import android.content.Intent
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.appcompat.widget.ButtonBarLayout

class Woda : Informacjerejestracja() {
    private lateinit var szklanka: Button
    private lateinit var butelka: Button
    private lateinit var zatwierdz:Button
    private lateinit var iloscwody:EditText
    private var progres:Int=0
    private lateinit var progresbar:ProgressBar
    private lateinit var wysprogres:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_woda)

        szklanka=findViewById(R.id.szklanka)
        butelka=findViewById(R.id.butelka)
        zatwierdz=findViewById(R.id.zatwierdz)
        iloscwody=findViewById(R.id.iloscwody)
        progresbar=findViewById(R.id.wodaprogresbar)
        wysprogres=findViewById(R.id.wysprog)

        progresbar!!.max=2500

        szklanka?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                iloscwody?.append("250")
                butelka.isEnabled=false
                szklanka.isEnabled=false
                zatwierdz.isEnabled=true


            }
        })
        butelka?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                iloscwody?.append("1500")
                szklanka.isEnabled=false
                butelka.isEnabled=false
                zatwierdz.isEnabled=true
            }
        })
        zatwierdz?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                if(wodainformacjedoguzika()){
                    var woda= iloscwody?.text.toString().trim(){ it<= ' '}


                    var woda1=iloscwody.text.toString().toInt()
                    progres+=woda1
                    progresbar!!.progress=progres


                    if (progres>=2500){

                        wysprogres.setText("100%")
                        Toast.makeText(
                            this@Woda,
                            resources.getString(R.string.koniecwoda),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    else{
                        var procent=(100*progres)/2500
                        var procentstr=procent.toString()
                        wysprogres.setText(procentstr+"%")
                    }



                    Toast.makeText(
                        this@Woda,
                        resources.getString(R.string.dodanawoda),
                        Toast.LENGTH_SHORT
                    ).show()


                    iloscwody.text.clear()
                    szklanka.isEnabled=true
                    butelka.isEnabled=true

                }
            }
        })





    }
    private fun wodainformacjedoguzika(): Boolean {

        return when{
            TextUtils.isEmpty(iloscwody?.text.toString().trim{ it <= ' '}) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_brakwody), true)
                false
            }


            else -> {
                //showErrorSnackBar("Your details are valid",false)
                true
            }
        }


    }


}