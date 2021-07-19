package hn.edu.ujcv.pdm_2021_ii_p2_proyecto2

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_winner.*

class WinnerActivity : AppCompatActivity() {
    private var mp = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)
        txvWinnerPalabra.text = "Congratulation"
        mp = MediaPlayer.create(this, R.raw.winner)
        mp.start()
        btnRestartWinner.setOnClickListener { reiniciar() }
    }

    private fun reiniciar() {
        var intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }
}
