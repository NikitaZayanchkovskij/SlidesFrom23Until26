package com.example.designslidefrom23until26.utils

import android.app.Activity
import android.app.AlertDialog
import com.example.designslidefrom23until26.databinding.ProgressDialogLayoutBinding


object ProgressDialog {

    fun createProgressDialog(act: Activity): AlertDialog {

        val builder = AlertDialog.Builder(act)
        val bindingDialogElement = ProgressDialogLayoutBinding.inflate(act.layoutInflater)
        val view = bindingDialogElement.root

        builder.setView(view)

        val dialog = builder.create()

        dialog.setCancelable(false)

        dialog.show()

        return dialog
    }
}