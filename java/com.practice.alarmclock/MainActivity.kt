package com.practice.alarmclock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.AutoCompleteTextView


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
