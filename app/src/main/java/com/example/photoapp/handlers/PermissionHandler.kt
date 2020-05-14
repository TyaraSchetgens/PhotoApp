package com.example.photoapp.handlers

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionHandler(private val currentActivity: Activity) {
    private val globalPermissions = arrayOf(Manifest.permission.CAMERA)

    fun requestPermission() {
        ActivityCompat.requestPermissions(currentActivity, globalPermissions, 0)
    }

    fun hasPermissions(): Boolean {
        for (permission in globalPermissions) {
            val hasPermission = ContextCompat.checkSelfPermission(currentActivity, permission) == PackageManager.PERMISSION_GRANTED
            if(!hasPermission) {
                return false
            }
        }
        return true
    }

}