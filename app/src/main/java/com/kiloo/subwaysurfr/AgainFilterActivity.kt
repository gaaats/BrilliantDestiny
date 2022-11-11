package com.kiloo.subwaysurfr

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiloo.subwaysurfr.GooodClass.Companion.C1111111
import com.kiloo.subwaysurfr.GooodClass.Companion.jsoupCheckfrg5t
import com.kiloo.subwaysurfr.GooodClass.Companion.frg56tgtonenne
import com.kiloo.subwaysurfr.GooodClass.Companion.linkFilterPart2df5rfr
import com.kiloo.subwaysurfr.GooodClass.Companion.odonefrf5rg
import com.kiloo.subwaysurfr.gimi.GameGameActivity
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class AgainFilterActivity : AppCompatActivity() {
    val naaaaafrgtt= 55698
    lateinit var frgt65gt5jjjsoup: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_again_filter)
        frgt65gt5jjjsoup = ""
        val jobbbbbbbb = GlobalScope.launch(Dispatchers.IO) {
            frgt65gt5jjjsoup = fgtg5hycoroutineTask()
        }

        runBlocking {
            try {
                jobbbbbbbb.join()
                if (frgt65gt5jjjsoup == jsoupCheckfrg5t) {
                    Intent(
                        applicationContext,
                        GameGameActivity::class.java
                    ).also { startActivity(it) }
                } else {
                    Intent(applicationContext, VeeeebVievActivity::class.java).also {
                        startActivity(
                            it
                        )
                    }
                }
                finish()
            } catch (e: Exception) {

            }
        }

    }

    private suspend fun fgtg5hycoroutineTask(): String {

        val sharPreffgtt59 = getSharedPreferences("SP", MODE_PRIVATE)
        val hawk: String? = sharPreffgtt59.getString(C1111111, "null")

        val forJsoupSetNamingfr5r =
            "${frg56tgtonenne}${linkFilterPart2df5rfr}${odonefrf5rg}$hawk"

        withContext(Dispatchers.IO) {
            gt66t6t66getCodeFromUrl(forJsoupSetNamingfr5r)
        }
        return frgt65gt5jjjsoup
    }

    private fun gt66t6t66getCodeFromUrl(link: String) {
        val frg56t56url = URL(link)
        val urlConnectionfr5g6t = frg56t56url.openConnection() as HttpURLConnection

        try {
            val text6frr59 = urlConnectionfr5g6t.inputStream.bufferedReader().readText()
            if (text6frr59.isNotEmpty()) {
                frgt65gt5jjjsoup = text6frr59
            } else {
            }
        } catch (ex: Exception) {

        } finally {
            urlConnectionfr5g6t.disconnect()
        }
    }
}