package com.lovepankie.quickshutdown

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class ShutdownAccessibilityService : AccessibilityService() {

    override fun onServiceConnected() {
        instance = this
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}

    override fun onInterrupt() {}

    override fun onDestroy() {
        instance = null
        super.onDestroy()
    }

    fun triggerPowerDialog() {
        performGlobalAction(GLOBAL_ACTION_POWER_DIALOG)
    }

    companion object {
        var instance: ShutdownAccessibilityService? = null
    }
}
