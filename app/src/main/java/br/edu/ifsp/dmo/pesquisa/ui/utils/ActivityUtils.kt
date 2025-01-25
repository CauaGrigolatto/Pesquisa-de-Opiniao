package br.edu.ifsp.dmo.pesquisa.ui.utils

import android.content.Context
import android.widget.Toast

object ActivityUtils {
    fun shortToast(context: Context, message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}