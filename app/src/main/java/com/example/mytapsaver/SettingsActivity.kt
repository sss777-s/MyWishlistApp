package com.mywishlist.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SettingsActivity : AppCompatActivity() {

    private lateinit var targetAmountInput: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        targetAmountInput = findViewById(R.id.targetAmountInput)
        saveButton = findViewById(R.id.btnSave)

        // جلب المبلغ الحالي من SharedPreferences
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val currentTarget = prefs.getInt("target_amount", 0)
        targetAmountInput.setText(currentTarget.toString())

        // عند الحفظ
        saveButton.setOnClickListener {
            val newTarget = targetAmountInput.text.toString().toIntOrNull()
            if (newTarget != null) {
                prefs.edit().putInt("target_amount", newTarget).apply()
                Toast.makeText(this, "تم حفظ الإعدادات", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "أدخل رقم صحيح", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
