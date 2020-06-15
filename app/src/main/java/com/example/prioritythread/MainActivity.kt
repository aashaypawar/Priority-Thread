package com.example.prioritythread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)
        val btn1 = findViewById<Button>(R.id.btn1)

        val t1 = Thread(Runnable {
            tv.text = "t1 had more priority"
        })

        val t2 = Thread(Runnable{
            tv.text = "t2 had more priority"
        })

        t1.priority = 1
        t2.priority = 10

        btn1.setOnClickListener {
            when{
                t1.priority < t2.priority -> t1.start()
                t2.priority < t1.priority -> t2.start()
                else -> tv.text = "Both had same priority"
            }
            btn1.isEnabled = false
        }
    }
}