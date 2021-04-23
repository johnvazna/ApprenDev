package com.apprendev.instagramfake.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.apprendev.instagramfake.R

@SuppressLint("StaticFieldLeak")
object DialogProgress {

    private lateinit var dialog: Dialog
    private lateinit var tvMessage: TextView

    fun showDialog(context: Context, msg: String) {
        dialog = (Dialog(context, R.style.ThemDialogProgress))
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_loading)

        tvMessage = dialog.findViewById(R.id.tvMessage)
        tvMessage.text = msg

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        dialog.show()
    }

    fun setText(msg: String) {
        tvMessage.text = msg
    }

    fun hideDialog() {
        dialog.dismiss()
    }

}