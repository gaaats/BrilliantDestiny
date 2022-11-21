package com.kiloo.subwaysurfr

import android.app.Application
import android.content.Context
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class GooodClass: Application() {
    companion object {
        const val ftgthyy = "27545048914660692872"

        var frgtgttg: String? = "myID"
        var gttgttggtt: String? = "instID"
        var rfrgtgttt = "link"
        var gtghyhyhy: String? = ""
        const val jglfkdkdkgjd = "ee0b6087-2b6e-420c-aeaf-9a16af3db7b2"
        var ghyhplyplhy = "appsChecker"
        var C1hhhhh: String? = "c11"

    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(jglfkdkdkgjd)

        Hawk.init(this).build()


        val frgttgt = getSharedPreferences("PREFS_NAME", 0)

        val thttht = MyTracker.getTrackerParams()
        val frfrrf = MyTracker.getTrackerConfig()
        val bgbgb = MyTracker.getInstanceId(this)
        frfrrf.isTrackingLaunchEnabled = true
        if (frgttgt.getBoolean("my_first_time", true)) {
            val gtgththyy = UUID.randomUUID().toString()
            thttht.setCustomUserId(gtgththyy)
            Hawk.put(frgtgttg, gtgththyy)
            Hawk.put(gttgttggtt, bgbgb)
            frgttgt.edit().putBoolean("my_first_time", false).apply()

        } else {
            val IDIN = Hawk.get(frgtgttg, "null")
            thttht.setCustomUserId(IDIN)
        }
        MyTracker.initTracker(ftgthyy, this)

    }


}
