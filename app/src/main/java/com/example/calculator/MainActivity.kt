package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

class MainActivity : AppCompatActivity() {

    private lateinit var result_tv:TextView
    private lateinit var data_tv:TextView
    private lateinit var btn_1:Button
    private lateinit var btn_2:Button
    private lateinit var btn_3:Button
    private lateinit var btn_4:Button
    private lateinit var btn_5:Button
    private lateinit var btn_6:Button
    private lateinit var btn_7:Button
    private lateinit var btn_8:Button
    private lateinit var btn_9:Button
    private lateinit var btn_0:Button
    private lateinit var btn_clear:Button
    private lateinit var btn_backspace:Button
    private lateinit var btn_module:Button
    private lateinit var btn_divide:Button
    private lateinit var btn_multiply:Button
    private lateinit var btn_subtract:Button
    private lateinit var btn_add:Button
    private lateinit var btn_equal:Button
    private lateinit var btn_dot:Button
    private lateinit var btn_allclear:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        result_tv = findViewById(R.id.result_tv)
        data_tv = findViewById(R.id.data_tv)
        btn_1 = findViewById(R.id.btn_1)
        btn_2 = findViewById(R.id.btn_2)
        btn_3 = findViewById(R.id.btn_3)
        btn_4 = findViewById(R.id.btn_4)
        btn_5 = findViewById(R.id.btn_5)
        btn_6 = findViewById(R.id.btn_6)
        btn_7 = findViewById(R.id.btn_7)
        btn_8 = findViewById(R.id.btn_8)
        btn_9 = findViewById(R.id.btn_9)
        btn_0 = findViewById(R.id.btn_0)
        btn_clear = findViewById(R.id.btn_clear)
        btn_backspace = findViewById(R.id.btn_backspace)
        btn_module = findViewById(R.id.btn_module)
        btn_divide = findViewById(R.id.btn_divide)
        btn_multiply = findViewById(R.id.btn_multiply)
        btn_subtract = findViewById(R.id.btn_subtract)
        btn_add = findViewById(R.id.btn_add)
        btn_equal = findViewById(R.id.btn_equal)
        btn_dot = findViewById(R.id.btn_dot)
        btn_allclear = findViewById(R.id.btn_allclear)


        var str:String


        btn_clear.setOnClickListener {
            data_tv.setText("")
            data_tv.textSize = 35F
        }

        btn_allclear.setOnClickListener {
            data_tvText("")
            result_tv.text = ""
            result_tv.visibility = View.GONE
            data_tv.textSize = 30F
            //result_tv.textSize = 30F
            //resultText()
        }

        btn_backspace.setOnClickListener {
            if (data_tv.text.toString().isNotEmpty())
            {
                val lastIndex = data_tv.text.toString().lastIndex
                str = data_tv.text.toString().substring(0,lastIndex)
                data_tvText(str)
                resultText()
            }
        }

        btn_module.setOnClickListener {
            if (data_tv.text.toString().endsWith("%") || data_tv.text.toString().endsWith("/") || data_tv.text.toString().endsWith("*") || data_tv.text.toString().endsWith("+") || data_tv.text.toString().endsWith("-") || data_tv.text.toString().endsWith("."))
            {
                str = data_tv.text.toString()
                data_tvText(str)
            }else
            {
                str = data_tv.text.toString() + "%"
                data_tvText(str)
            }
        }

        btn_divide.setOnClickListener {
            if (data_tv.text.toString().endsWith("%") || data_tv.text.toString().endsWith("/") || data_tv.text.toString().endsWith("*") || data_tv.text.toString().endsWith("+") || data_tv.text.toString().endsWith("-") || data_tv.text.toString().endsWith("."))
            {
                str = data_tv.text.toString()
                data_tvText(str)
            }else {
                str = data_tv.text.toString() + "/"
                data_tvText(str)
            }
        }

        btn_multiply.setOnClickListener {
            if (data_tv.text.toString().endsWith("%") || data_tv.text.toString().endsWith("/") || data_tv.text.toString().endsWith("*") || data_tv.text.toString().endsWith("+") || data_tv.text.toString().endsWith("-") || data_tv.text.toString().endsWith("."))
            {
                str = data_tv.text.toString()
                data_tvText(str)
            }else {
                str = data_tv.text.toString() + "*"
                data_tvText(str)
            }
        }

        btn_add.setOnClickListener {
            if (data_tv.text.toString().endsWith("%") || data_tv.text.toString().endsWith("/") || data_tv.text.toString().endsWith("*") || data_tv.text.toString().endsWith("+") || data_tv.text.toString().endsWith("-") || data_tv.text.toString().endsWith("."))
            {
                str = data_tv.text.toString()
                data_tvText(str)
            }else {
                str = data_tv.text.toString() + "+"
                data_tvText(str)
            }
        }

        btn_subtract.setOnClickListener {
            if (data_tv.text.toString().endsWith("%") || data_tv.text.toString().endsWith("/") || data_tv.text.toString().endsWith("*") || data_tv.text.toString().endsWith("+") || data_tv.text.toString().endsWith("-") || data_tv.text.toString().endsWith("."))
            {
                str = data_tv.text.toString()
                data_tvText(str)
            }else {
                str = data_tv.text.toString() + "-"
                data_tvText(str)
            }
        }

        btn_equal.setOnClickListener {
            data_tv.textSize = 25F
            result_tv.textSize = 60F
            result_tv.visibility = View.VISIBLE

        }

        btn_dot.setOnClickListener {
            if (data_tv.text.toString().endsWith("%") || data_tv.text.toString().endsWith("/") || data_tv.text.toString().endsWith("*") || data_tv.text.toString().endsWith("+") || data_tv.text.toString().endsWith("-") || data_tv.text.toString().endsWith("."))
            {
                str = data_tv.text.toString()
                data_tvText(str)
            }else {
                str = data_tv.text.toString() + "."
                data_tvText(str)
            }
        }

        btn_0.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "0"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "0"
                data_tvText(str)
                resultText()
            }
        }

        btn_1.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "1"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "1"
                data_tvText(str)
                resultText()
            }
        }

        btn_2.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "2"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "2"
                data_tvText(str)
                resultText()
            }
        }

        btn_3.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "3"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "3"
                data_tvText(str)
                resultText()
            }
        }

        btn_4.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "4"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "4"
                data_tvText(str)
                resultText()
            }
        }

        btn_5.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "5"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "5"
                data_tvText(str)
                resultText()
            }
        }

        btn_6.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "6"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "6"
                data_tvText(str)
                resultText()
            }
        }

        btn_7.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "7"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "7"
                data_tvText(str)
                resultText()
            }
        }

        btn_8.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "8"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "8"
                data_tvText(str)
                resultText()
            }
        }

        btn_9.setOnClickListener {
            if (data_tv.text.toString().startsWith("0"))
            {
                str = data_tv.text.toString().replace("0","") + "9"
                data_tvText(str)
                resultText()
            }else{
                str = data_tv.text.toString() + "9"
                data_tvText(str)
                resultText()
            }
        }


    }

    private fun data_tvText(str:String)
    {
        data_tv.text = str
    }

    private fun resultText()
    {
        val res = data_tv.text.toString()
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val ress = engine.eval(res)
            if (ress.toString().endsWith(".0"))
            {
                result_tv.text = "=" + ress.toString().replace(".0","")
            }else{
                result_tv.text = "=$ress"
            }
        }catch (ex : java.lang.Exception)
        {
            Toast.makeText(applicationContext,ex.toString(),Toast.LENGTH_LONG).show()
        }
    }


}