package com.kiloo.subwaysurfr.gimi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.kiloo.subwaysurfr.databinding.FragmentEnddddddBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class EnddddddFragment : Fragment() {


    private var _biiiiiiinding: FragmentEnddddddBinding? = null
    private val binding
        get() = _biiiiiiinding ?: throw RuntimeException("FragmentStartBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biiiiiiinding = FragmentEnddddddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            Snackbar.make(
                binding.root,
                "You have already earned ${Random.nextInt(from = 10, until = 500)} points!!!",
                Snackbar.LENGTH_LONG
            ).show()
            requireActivity().onBackPressed()

            binding.btnExit.setOnClickListener {
                initAlertDialog()
            }
            binding.btnTryAgain.setOnClickListener {
                requireActivity().onBackPressed()
            }


        } catch (e: Exception) {
            makeError()
        }

        super.onViewCreated(view, savedInstanceState)
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

}