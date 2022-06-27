package jp.techacademy.masaya.ishihara.calcapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.text.Editable
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.text.DecimalFormat
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, SecondActivity::class.java)
        var number1: String? = editTextNumberDecimal1.text.toString()
        var number2: String? = editTextNumberDecimal2.text.toString()
        var number3: String ="+"

        if (number1 != null && number2 != null) {
            if(v.id == R.id.button2){
                number3 = "-"
            }else if(v.id == R.id.button3){
                number3 = "*"
            }else if(v.id == R.id.button4){
                number3 = "/"
            }
            Log.d("LogD", number1 + ":" + number2 + ":" + number3)
            if (number1.length != 0 && number2.length != 0) {
                try {
                    var num_F1: String = "${number1.toDouble() / number1.toDouble()}"
                    var num_F2: String = "${number2.toDouble() / number2.toDouble()}"
                    Log.d("LogD", num_F1.toString() + num_F2.toString())
                    if(num_F1.toString() == "1.0" && num_F2.toString() == "1.0"){
                        intent.putExtra("VALUE1", number1)
                        intent.putExtra("VALUE2", number2)
                        intent.putExtra("VALUE3", number3)
                        startActivity(intent)
                    }
                }catch(e:NumberFormatException){
                    showAlertDialog()
                }
            }
        }
    }
    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("エラー")
        alertDialogBuilder.setMessage("正しい値を入力してください")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK"){dialog, which ->
            Log.d("UI_PARTS", "OK")
        }

        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}









