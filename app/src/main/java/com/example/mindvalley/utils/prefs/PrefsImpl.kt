package com.example.mindvalley.utils.prefs

import javax.inject.Inject

class PrefsImpl @Inject constructor(private val prefStore: PrefStore) :
    Prefs {

    override fun getReferralCode(): String = prefStore.getString(REFERRAL_CODE, "")

    override fun setReferralCode(code: String) {
        prefStore.saveString(REFERRAL_CODE, code)
    }

    override fun setPin(pin: String) {
        prefStore.saveString(PIN, pin)
    }

    override fun msisdn(): String = prefStore.getString(MSISDN, "")

    override fun pin(): String = prefStore.getString(PIN, "")

    override fun isLoggedIn(): Boolean = prefStore.getBoolean(IS_LOGGED_IN)

    override fun isAppLaunchedFirstTime(): Boolean = prefStore.getBoolean(IS_LAUNCHED_FIRST)


    override fun clearWelcomeBack() {
        prefStore.remove(WELCOME_BACK)
    }

    override fun clearEmailScreen() {
        prefStore.remove(EMAIL_SCREEN)
    }

    override fun saveWelcomeBack() {
        prefStore.saveBoolean(WELCOME_BACK, true)
    }

    override fun emailScreen(): Boolean {
        return prefStore.getBoolean(EMAIL_SCREEN, false)
    }

    override fun saveEmailScreen() {
        prefStore.saveBoolean(EMAIL_SCREEN, true)
    }

    override fun welcomeBack(): Boolean {
        return prefStore.getBoolean(WELCOME_BACK, false)
    }

    override fun msisdn(msisdn: String) {
        prefStore.saveString(MSISDN, msisdn)
    }

    override fun loggedIn() {
        prefStore.saveBoolean(IS_LOGGED_IN, true)
    }

    override fun appLaunchedFirstTime() {
        prefStore.saveBoolean(IS_LAUNCHED_FIRST, true)
    }

    companion object {
        private const val PIN = "code"
        private const val REFERRAL_CODE = "referral.code"
        private const val MSISDN = "ssd"
        private const val IS_LOGGED_IN = "is_logged_in"
        private const val WELCOME_BACK = "welcome.back"
        private const val EMAIL_SCREEN = "email.screen"
        private const val IS_LAUNCHED_FIRST = "is_launched_first"
    }
}