package kz.step.stepeducation.domain.usecase

import android.content.Context

interface ISocialNetworkHelper {
    fun sendText(`package`: String, text: String)
}