package com.example.assigment

import androidx.compose.runtime.Composable
import com.example.assigment.ui.login.LoginScreen
import com.example.assigment.ui.nav.Nav
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ApplicationSwitcher(auth: FirebaseAuth) {
    val vm = UserState.current
    if (vm.isLoggedIn) {
        Nav()
    } else {
        LoginScreen(auth)
    }
}