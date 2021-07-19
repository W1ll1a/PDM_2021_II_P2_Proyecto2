package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_adivinar.*

class AdivinarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivinar)
        inicio()
        palabra = getIntent().getExtras()?.getSerializable("palabra") as String
        pista = getIntent().getExtras()?.getSerializable("pista") as String
        txvPistaDePalabra.text = pista
        btnPrueba.setOnClickListener { comprobar() }
        for (i in 0..palabra.length - 1) {
            mostrada.append("-")
        }
        txvPalabraGame.text = mostrada


    }

    private fun inicio() {
        letras.clear()
        intentosContador=0
    }

    fun hangmanVisibility(intentos: Int ) {
        when (intentos) {
            1 ->{ImHead.isVisible = true
            }
            2 -> {
                ImNeck.isVisible = true
                ImHead.isVisible = false
            }
            3 -> {
                ImBody.isVisible = true
                ImNeck.isVisible = false
            }
            4 -> {
                ImLegs.isVisible = true
                ImBody.isVisible = false
            }
            5 -> {
                ImLeftArm.isVisible = true
                ImLegs.isVisible = false
            }
            6 -> {
                ImLeftArm.isVisible = false
                loser()
            }
            else -> {
                loser()
            }
        }
    }

    var palabra: String = String()
    var pista: String = String()
    var letras: ArrayList<Char> = ArrayList()
    var mostrada = StringBuilder()
    var intentosContador : Int = 0


    private fun comprobar() {
        var letra = txtLetra.text.toString().first().toLowerCase()
        if (letras.isEmpty()) {
            letras.add(letra)
            comprobacionLetra(letra)
            letraCorrecta(letra)
        } else {
            for (n in 0..letras.size - 1) {
                if (letra.equals(letras[n])) {
                    Toast.makeText(this, "Esta letra ya fue ingresada", Toast.LENGTH_SHORT).show()

                }else {
                    letras.add(letra)
                    letraCorrecta(letra)
                }

            }

        }
        if (comprobacionLetra(letra) == false){
            intentosContador++
            hangmanVisibility(intentosContador)
        }

    }

    private fun letraCorrecta(letra: Char) {
        if (comprobacionLetra(letra) == true){
            Toast.makeText(this, "Excelente",
                Toast.LENGTH_SHORT).show()
            if(palabraCompleta()== true ){
                winner()
            }
        }else{
            Toast.makeText(this, "Letra no esta en palabra",
                Toast.LENGTH_SHORT).show()
        }
    }
    fun mostrarLetras (letra: Char){
        for (i in 0..palabra.length - 1) {
            if (letra.equals(palabra.get(i))) {
                mostrada.set(i,letra)
                txvPalabraGame.text=  mostrada
            }
        }
    }

    fun comprobacionLetra (letra: Char) : Boolean{
        for (i in 0..palabra.length - 1) {
            if (letra.equals(palabra.get(i))) {
                mostrarLetras(letra)
                return true
            }
        }
        return false
    }
    fun palabraCompleta (): Boolean{
        if (txvPalabraGame.text == palabra ){
            return true
        }else {
            return false
        }
    }
    fun loser(){
        var intent  = Intent(this , LoserActivity::class.java)
        intent.putExtra("palabra", palabra)
        startActivity(intent)
    }
    fun winner(){
        var intent  = Intent (this, WinnerActivity::class.java)
        startActivity(intent)
    }
}
