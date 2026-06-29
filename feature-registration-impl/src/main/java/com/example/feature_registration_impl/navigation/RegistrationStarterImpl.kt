package com.example.feature_registration_impl.navigation

import com.example.feature_registration_api.navigation.RegistrationStarter

class RegistrationStarterImpl: RegistrationStarter {

    override fun getRoute(): String {
        return REGISTRATION_FLOW_SCREEN
    }

    companion object {
        const val REGISTRATION_FLOW_SCREEN = "registration_flow_screen"
    }

}