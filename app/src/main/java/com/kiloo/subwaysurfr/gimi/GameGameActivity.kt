package com.kiloo.subwaysurfr.gimi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiloo.subwaysurfr.R
import com.kiloo.subwaysurfr.databinding.ActivityGameGameBinding

class GameGameActivity : AppCompatActivity() {
    private lateinit var bindgggggame: ActivityGameGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindgggggame = ActivityGameGameBinding.inflate(layoutInflater)
        setContentView(bindgggggame.root)

        val text1 = resources.getString(R.string.fake_text_1)
        val text2 = resources.getString(R.string.faaaake_text)
        val text3 = resources.getString(R.string.fake_text_3)
        val text4 = resources.getString(R.string.fake_text_4)
        val text5 = resources.getString(R.string.fake_text_5)

        val result = text1 + text2 + text3 + text4 + text5

        bindgggggame.faaaaaaaakeText.text = result.toString()


    }
}