package com.practice.alarmclock

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class SetTimeActivity : AppCompatActivity() {

    var clockHour = 0
    var clockMinute = 0
    var clockAm_Pm = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_time_activity)


        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        timePicker.setOnTimeChangedListener { _, hour, minute ->
            var hour = hour
            var am_pm = ""

            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM"
                }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"

            }

            clockHour = hour
            clockMinute = timePicker.minute
            clockAm_Pm = am_pm
        }

            val setAlarmBtn = findViewById<Button>(R.id.setAlarmBtn)
            setAlarmBtn.setOnClickListener {

                val calendar: Calendar = Calendar.getInstance().apply {
                    timeInMillis = System.currentTimeMillis()
                    set(Calendar.HOUR_OF_DAY, timePicker.hour)
                    set(Calendar.MINUTE, timePicker.minute)
                }


                scheduleNotification(this,calendar.timeInMillis,"Alarm","Don't Forget")

            }
    }
    fun scheduleNotification(context: Context, time: Long, title: String, text: String) {
        val alarmintent = Intent(context, AlarmReceiver::class.java)
        alarmintent.putExtra("title", title)
        alarmintent.putExtra("text", text)

        val pending =
            PendingIntent.getBroadcast(context, 42, alarmintent, PendingIntent.FLAG_UPDATE_CURRENT)

        val manager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        manager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, time, pending)
    }

}
