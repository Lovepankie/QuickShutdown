package com.lovepankie.quickshutdown

import android.app.AlertDialog
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageButton>(R.id.btnPower).setOnClickListener {
            confirmShutdown()
        }
    }

    private fun confirmShutdown() {
        AlertDialog.Builder(this)
            .setTitle("Shut down?")
            .setMessage("Your phone will power off.")
            .setPositiveButton("Power off") { _, _ -> shutdown() }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun shutdown() {
        try {
            val process = Runtime.getRuntime().exec(arrayOf("su", "-c", "reboot -p"))
            process.waitFor()
        } catch (e: Exception) {
            // Root not available — fall back to showing power dialog via root alternative
            try {
                Runtime.getRuntime().exec(arrayOf("su", "-c", "poweroff"))
            } catch (ex: Exception) {
                Toast.makeText(
                    this,
                    "Root access is required to shut down.\nGrant root permission and try again.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
