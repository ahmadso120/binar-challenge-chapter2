package com.sopian.gojek.util

import android.content.Context
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat

fun getColor(context: Context, @ColorRes id: Int): Int {
    return ContextCompat.getColor(context, id)
}

fun enableStatusBar(isLight: Boolean, view: View, window: Window) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val controller = view.windowInsetsController
        controller?.setSystemBarsAppearance(
            if (isLight) APPEARANCE_LIGHT_STATUS_BARS else 0,
            APPEARANCE_LIGHT_STATUS_BARS
        )
    } else {
        WindowCompat.getInsetsController(window, window.decorView)?.apply {
            isAppearanceLightStatusBars = isLight
        }
    }
}