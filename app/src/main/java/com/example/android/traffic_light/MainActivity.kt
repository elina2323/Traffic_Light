package com.example.android.traffic_light

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import java.util.*

class MainActivity : Activity() {

    private var imageTrafficLight: ImageView? = null
    var counter:Int = 0
    var timer: Timer? = null
    private var is_run = false
    var imageArray: IntArray = intArrayOf(R.drawable.semafor_red, R. drawable.semafor_yellow, R.drawable.semafor_green)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageTrafficLight = findViewById(R.id.imageViewTrafficLight)
        //imageTrafficLight?.setImageResource(imageArray[1])
    }

    fun onClickStartStop(view: View) {
        view as ImageButton
        if (!is_run){
            timer = Timer()
            startStop()
        view.setImageResource(R.drawable.button_stop)
            is_run = true
        }else{
            imageTrafficLight?.setImageResource(R.drawable.semafor_grey)
            view.setImageResource(R.drawable.button_start)
            timer?.cancel()
            is_run = false
            counter = 0
        }
    }
    private fun startStop(){
        timer = Timer()
        timer?.schedule(object : TimerTask(){
            override fun run() {
                runOnUiThread {
                    imageTrafficLight?.setImageResource(imageArray[counter])
                    counter++
                    if (counter == 3) counter = 0
                }
            }

        }, 0, 1000)

    }

}


