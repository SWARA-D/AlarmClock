package com.practice.alarmclock

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.practice.alarmclock.databinding.ActivityMainBinding
import java.util.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener

import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {

    companion object {
        var itemSelected: String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val destinations = resources.getStringArray(R.array.destinations)

        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_list, destinations)

        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)

        autocompleteTV.setAdapter(arrayAdapter)

        autocompleteTV.setOnItemClickListener { parent, view, position, id ->
            var item = parent.getItemAtPosition(position) as String
            itemSelected = item
        }


            val setTimeBtn = findViewById<Button>(R.id.setTimeBtn)
        setTimeBtn.setOnClickListener()
        {
            val intent = Intent(this,SetTimeActivity::class.java)
            intent.putExtra("item", itemSelected)
            startActivity(intent)

        }

    }

}
