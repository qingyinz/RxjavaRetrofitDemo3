package com.example.mingyue.rxjavaretrofitdemo3.view

import android.app.Dialog
import android.content.Context
import com.example.mingyue.rxjavaretrofitdemo3.R

/**
 * Created by leimo on 2018/12/28.
 */
object LoadingDialog {
    private var dialog: Dialog? = null

    fun show(context: Context) {
        cancel()
        dialog = Dialog(context, R.style.LoadingDialog)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()
    }
    fun cancel() {
        dialog?.dismiss()
    }
}