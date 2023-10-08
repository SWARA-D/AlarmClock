package com.practice.alarmclock

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DestinationActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destination_activity)

        val item1 = findViewById<TextView>(R.id.Item1)
        val item2 = findViewById<TextView>(R.id.Item2)
        val item3 = findViewById<TextView>(R.id.Item3)
        val item4 = findViewById<TextView>(R.id.Item4)

        if(MainActivity.itemSelected == "Shopping")
        {
            item1.text = "Keys"
            item2.text = "Cloth Bag"
            item3.text = "Wallet"
            item4.text = "Shopping List"
        }

        if(MainActivity.itemSelected == "School")
        {
            item1.text = "Keys"
            item2.text = "ID Card"
            item3.text = "Books & Stationery"
            item4.text = "Concentration"
        }

        if(MainActivity.itemSelected == "Work")
        {
            item1.text = "Keys"
            item2.text = "ID Card"
            item3.text = "Lunch"
            item4.text = "Hard Work"
        }

        if(MainActivity.itemSelected == "Exercise")
        {
            item1.text = "Keys"
            item2.text = "Water Bottle"
            item3.text = "Music"
            item4.text = "Motivation"
        }
    }
}
