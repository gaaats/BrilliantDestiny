package com.kiloo.subwaysurfr

import android.app.Application
import android.content.Context
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GooodClass: Application() {
    companion object {

        const val jsoupCheckfrg5t = "2v4h"
        const val ONESIGNAL_APP_ID5fr5 = "ee0b6087-2b6e-420c-aeaf-9a16af3db7b2"

        var MAIN_IDfr5f: String? = ""
        var D111111: String? = "d11"
        var CHhhhhh: String? = "check"
        var C1111111: String? = "c11"



        const val AF_DEV_KEYfgtt = "KZQPgvXscUGon9aEQnZKj9"


        val linkAppsCheckPart1frr5 = "http://brilliant"
        val fr65linkAppsCheckPart2 = "destiny.xyz/apps.txt"
        val frg56tgtonenne = "http://brilliant"
        val linkFilterPart2df5rfr = "destiny.xyz/go.php?to=1&"
        val odonefrf5rg = "sub_id_1="

    }

    override fun onCreate() {
        super.onCreate()

        GlobalScope.launch(Dispatchers.IO) {
            applyDeviceIdddddfrr(context = applicationContext)
        }
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID5fr5)

    }

    private suspend fun applyDeviceIdddddfrr(context: Context) {
        val frgtttg = Advdfrgtt(context)
        val idInfofrgtgt = frgtttg.getAdvertisingIdddddd()

        val prefsaaaa5 = getSharedPreferences("SP", MODE_PRIVATE)
        val editorfrgft54 = prefsaaaa5.edit()

        editorfrgft54.putString(MAIN_IDfr5f, idInfofrgtgt)
        editorfrgft54.apply()
    }

}

class Advdfrgtt (context: Context) {
    private val adInfooooooo = AdvertisingIdClient(context.applicationContext)

    suspend fun getAdvertisingIdddddd(): String =
        withContext(Dispatchers.IO) {
            adInfooooooo.start()
            val eeeeeeeend = adInfooooooo.info
            eeeeeeeend.id
        }
}