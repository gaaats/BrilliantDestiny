package com.kiloo.subwaysurfr.gimi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kiloo.subwaysurfr.R
import com.kiloo.subwaysurfr.databinding.FragmentStaaaaaaartBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class StaaaaaaartFragment : Fragment() {
    var tgtgttg = 0.05f
    var gtgt = 0.05f
    private var tgtgt = 1
    private var jkuokjku = true


    private var gykohkoykkh: FragmentStaaaaaaartBinding? = null
    private val gyohkyyhk
        get() = gykohkoykkh ?: throw RuntimeException("frthyhju = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gykohkoykkh = FragmentStaaaaaaartBinding.inflate(inflater, container, false)
        return gyohkyyhk.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            yhkyhkoyokhkkykh()

            polforgo()
            jkuokjku = false
            gyohkyyhk.btnPressMe.setOnClickListener {
                if (tgtgt >= 99) {
                    findNavController().navigate(R.id.action_staaaaaaartFragment_to_enddddddFragment)
                    tgtgt = 1
                }
                gyohkyyhk.progBarSplashScrn.progress = tgtgt
                tgtgt += 1
            }


            gyohkyyhk.btnImgExit.setOnClickListener {
                ghyhyhyhyyh()
            }


        } catch (e: Exception) {
            moska()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onPause() {
        tgtgt = 1
        super.onPause()
    }

    private fun moska() {
        Snackbar.make(
            gyohkyyhk.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    override fun onDestroy() {
        gykohkoykkh = null
        super.onDestroy()
    }




    private fun polforgo() {
        lifecycleScope.launch {
            while (true) {
                gyohkyyhk.btnPressMe.alpha = tgtgttg
                if (tgtgttg >= 1f) {
                    gtgt = -0.05f
                }
                if (tgtgttg <= 0.1f) {
                    gtgt = 0.05f
                }
                delay(10)
                tgtgttg += gtgt
            }
        }
    }

    private fun yhkyhkoyokhkkykh() {
        gyohkyyhk.progBarSplashScrn.progress = tgtgt
    }

    private fun ghyhyhyhyyh() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Are you reaaaaly want to exit, the current data will not be save?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().finish()
            }
            .setNegativeButton("Deny") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }



}