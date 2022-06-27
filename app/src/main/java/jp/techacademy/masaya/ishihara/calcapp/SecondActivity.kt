package jp.techacademy.masaya.ishihara.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var value1: String? = intent.getStringExtra("VALUE1")
        var value2: String? = intent.getStringExtra("VALUE2")
        var value3: String? = intent.getStringExtra("VALUE3")
        if (value1 != null && value2 != null) {

            if (value3 == "+") {
                var Sum1 = "${value1.toFloat() + value2.toFloat()}"
                textView.text = value1.toString() + " + " + value2.toString() + " = " + Sum1
            }else if(value3 == "-"){
                var Sum1 = "${value1.toFloat() - value2.toFloat()}"
                textView.text = value1.toString() + " - " + value2.toString() + " = " + Sum1

            }else if(value3 == "*"){
                var Sum1 = "${value1.toFloat() * value2.toFloat()}"
                textView.text = value1.toString() + " - " + value2.toString() + " = " + Sum1

            }else if(value3 == "/"){
                var Sum1 = "${value1.toFloat() / value2.toFloat()}"
                textView.text = value1.toString() + " - " + value2.toString() + " = " + Sum1

            }

        }
    }
}

fun isWhole(value: Double):Boolean {
    return value - value.toInt() == 0.0
}


