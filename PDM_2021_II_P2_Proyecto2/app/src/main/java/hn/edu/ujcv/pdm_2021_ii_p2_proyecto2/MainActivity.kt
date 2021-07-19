package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mp = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicio()
        btnAgregar.setOnClickListener{agregar()}
        btnAdivinar.setOnClickListener{adivinar()}
    }

    private fun inicio() {
        palabra = null
        pista = null
        mp  = MediaPlayer.create(this , R.raw.main)
        mp.start()
    }

    var palabra: String? =null
    var pista  : String? =null

    private fun agregar() {
        if (palabra.equals(null)&&pista.equals(null)){
            if (txtPalabra.text.toString().isNotEmpty()){
                if (txtPista.text.toString().isNotEmpty()){
                    palabra = txtPalabra.text.toString().toLowerCase()
                    pista = txtPista.text.toString().toLowerCase()
                }else{
                    Toast.makeText(this, "Introduzca una pista", Toast.LENGTH_SHORT).show()}
            }else{
                Toast.makeText(this, "Introduzca una palabra", Toast.LENGTH_SHORT).show()}
        }else{ Toast.makeText(this, "Ya hay una palabra ingresada", Toast.LENGTH_SHORT).show()}}


    private fun adivinar() {
        if (palabra.equals(null)){
            Toast.makeText(this, "Introduzca una palabra", Toast.LENGTH_SHORT).show()
        }else {
            mp.stop()
            val intent = Intent(this,AdivinarActivity::class.java)
            intent.putExtra("palabra",palabra)
            intent.putExtra("pista",pista)
            startActivity(intent)
        }
    }
}