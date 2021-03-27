package com.codext.project.cleanarchauth.utils

import android.content.Context
import androidx.core.content.edit

class AuthPreferences(context: Context) {
    private val prefs = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun saveUserType(userType: Int) {
        prefs.edit {
            putInt("userType", userType)
        }
    }

    fun saveToken(token: String) {
        prefs.edit {
            putString("token", token)
        }
    }

    fun getUserType(): Int {
        return prefs.getInt("userType", -1)
    }

    fun getToken(): String? {
        return prefs.getString("token", null)
    }
}