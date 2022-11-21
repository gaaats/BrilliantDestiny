package com.kiloo.subwaysurfr.gimi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.kiloo.subwaysurfr.databinding.FragmentEnddddddBinding
import kotlin.random.Random


class EnddddddFragment : Fragment() {


    private var tgtgttgt: FragmentEnddddddBinding? = null
    private val ftgttgtg
        get() = tgtgttgt ?: throw RuntimeException("FragmentStartBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        tgtgttgt = FragmentEnddddddBinding.inflate(inflater, container, false)
        return ftgttgtg.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            Snackbar.make(
                ftgttgtg.root,
                "You have already earned ${Random.nextInt(from = 10, until = 500)} points!!!",
                Snackbar.LENGTH_LONG
            ).show()

            ftgttgtg.btnExit.setOnClickListener {
                gkhykhkykyhk()
            }
            ftgttgtg.btnTryAgain.setOnClickListener {
                requireActivity().onBackPressed()
            }


        } catch (e: Exception) {
            gtgygyhyhyy()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        tgtgttgt = null
        super.onDestroy()
    }

    private fun gtgygyhyhyy() {
        Snackbar.make(
            ftgttgtg.root,
            "Some error",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    private fun gkhykhkykyhk() {

        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Exit, the current data will not be save?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().finish()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }

}