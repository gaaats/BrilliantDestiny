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

    private var currentProgress = 1
    private var isCreated = true
    var counterAlpha = 0.05f
    var diffAlpha = 0.05f

    private var _biiiiiiinding: FragmentStaaaaaaartBinding? = null
    private val binding
        get() = _biiiiiiinding ?: throw RuntimeException("FragmentStartBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biiiiiiinding = FragmentStaaaaaaartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            initProgBar()

            makeCycleUpAndDovnAlpha()
            isCreated = false
            binding.btnPressMe.setOnClickListener {
                if (currentProgress >= 99) {
                    findNavController().navigate(R.id.action_staaaaaaartFragment_to_enddddddFragment)
                    currentProgress = 1
                }
                binding.progBarSplashScrn.progress = currentProgress
                currentProgress += 1
            }


            binding.btnImgExit.setOnClickListener {
                initAlertDialog()
            }


        } catch (e: Exception) {
            makeError()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onPause() {
        currentProgress = 1
        super.onPause()
    }

    override fun onDestroy() {
        _biiiiiiinding = null
        super.onDestroy()
    }

    private fun makeError() {
        Snackbar.make(
            binding.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    private fun makeCycleUpAndDovnAlpha() {
        lifecycleScope.launch {
            while (true) {
                binding.btnPressMe.alpha = counterAlpha
                if (counterAlpha >= 1f) {
                    diffAlpha = -0.05f
                }
                if (counterAlpha <= 0.1f) {
                    diffAlpha = 0.05f
                }
                delay(10)
                counterAlpha += diffAlpha
            }
        }
    }

    private fun initAlertDialog() {
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

    private fun initProgBar() {
        binding.progBarSplashScrn.progress = currentProgress
    }

}