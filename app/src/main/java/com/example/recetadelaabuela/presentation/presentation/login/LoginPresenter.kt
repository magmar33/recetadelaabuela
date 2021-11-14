package com.example.recetadelaabuela.presentation.login

import android.content.Context
import com.example.recetadelaabuela.utils.MySharedPreferences


class LoginPresenter(val view : LoginInteractor.View, val context: Context) : LoginInteractor.Presenter {

    override fun goToLogin(email: String, password: String) {
        when {
            email.isEmpty() -> {
                view.error(("Por favor escribe un correo"))
            }
            password.isEmpty() -> {
                view.error(("Por favor escribe una contraseña"))
            }
            else -> {
                MySharedPreferences.setShared(context)
                view.success()
            }
        }
    }

    override fun getSessionActive() {
        val session = MySharedPreferences.getShared(context)
        if (session){
            view.success()
        }
    }
}