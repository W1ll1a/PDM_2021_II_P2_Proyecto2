package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_loser.*

class LoserActivity : AppCompatActivity() {
    private var mp: MediaPlayer= MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loser)
        palabra = getIntent().getExtras()?.getSerializable("palabra") as String
        txvLoserPalabra.text = ("La palabra era: "+ palabra)
        mp = MediaPlayer.create(this, R.raw.lose)
        mp.start()
        btnRestart.setOnClickListener { reiniciarJuego() }
    }

    private fun reiniciarJuego() {
        var intent  = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    var palabra = String()
}