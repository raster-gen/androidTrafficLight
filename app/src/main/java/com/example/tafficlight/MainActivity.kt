package com.example.tafficlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import com.example.tafficlight.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    var stateOfTrafficLight = false
    var timer: Timer? = null

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun startStop(view: View) {
        view as ImageButton

        Log.i("imageButton", "Click, click")

        when (stateOfTrafficLight) {
            true -> {
                Log.i("imageButton", "when true")
                timer?.cancel()
                stateOfTrafficLight = false
                binding.btnStartStop.setImageResource(Constance.switchButton["turn_on"]!!)
                binding.ivTrafficLight.setImageResource(Constance.trafficLightColors["unplugged"]!!)
            }
            false -> {

                Log.i("imageButton", "when false")

                stateOfTrafficLight = true

                binding.btnStartStop.setImageResource(Constance.switchButton["turn_off"]!!)
                changeColor()
            }
        }
    }

        fun changeColor() {
            timer = Timer()
            val colorList = arrayOf("red", "yellow", "green")
            var counter = 0

                timer?.schedule(object: TimerTask(){
                    override fun run() {
                        runOnUiThread{
                            binding.ivTrafficLight.setImageResource(Constance.trafficLightColors[colorList[counter]]!!)
                            counter = (counter + 1) % colorList.size

                        }
                        Log.i("imageButton", "when true stateOfTrafficLight: $stateOfTrafficLight")
                    }

                }, 0, 1000 )
        }


}