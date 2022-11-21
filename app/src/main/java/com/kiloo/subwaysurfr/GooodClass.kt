package com.kiloo.subwaysurfr

import android.app.Application
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk

class GooodClass: Application() {

    companion object {
        const val dedeedeeed = "ee0b6087-2b6e-420c-aeaf-9a16af3db7b2"
        var appsCheckfrfrrf = "appsChecker"
        var MAIN_IDdrfrrf: String? = ""
        var DEEPLfrfrrf: String? = ""
        var C1ftgtgttg: String? = "c11"
        var linkfrfrrf = "link"

    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(dedeedeeed)

        Hawk.init(this).build()


    }

}
