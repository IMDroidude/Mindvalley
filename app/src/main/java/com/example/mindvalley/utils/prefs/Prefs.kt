package com.example.mindvalley.utils.prefs

interface ReadableTkPrefs {
    fun isLoggedIn(): Boolean
    fun isAppLaunchedFirstTime(): Boolean
    fun msisdn(): String
    fun pin(): String
    fun clearWelcomeBack()
    fun welcomeBack(): Boolean
    fun emailScreen(): Boolean
    fun clearEmailScreen()
    fun getReferralCode(): String
}

interface WritableTkhPrefs {
    fun loggedIn()
    fun appLaunchedFirstTime()
    fun setPin(pin: String)
    fun msisdn(msisdn: String)
    fun saveWelcomeBack()
    fun saveEmailScreen()
    fun setReferralCode(code: String)
}


interface Prefs : ReadableTkPrefs,
    WritableTkhPrefs