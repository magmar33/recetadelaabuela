package com.example.recetadelaabuela.presentation.login

interface LoginInteractor {
    interface View {
        fun success()
        fun error(msg : String)
    }

    interface Presenter {
        fun goToLogin(email: String, password: String)
        fun getSessionActive()

    }
}