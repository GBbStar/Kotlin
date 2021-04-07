package org.techtown.calculater

import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible
import androidx.room.Room
import org.techtown.calculater.model.History
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private val expressionTextView:TextView by lazy{
        findViewById<TextView>(R.id.expressionTextView)
    }


    private val resultTextView:TextView by lazy{
        findViewById<TextView>(R.id.resultTextView)
    }

    private val historyLayout:View by lazy{
        findViewById<View>(R.id.historyLayout)
    }

    private val historyLinearLayout:LinearLayout by lazy {
        findViewById<LinearLayout>(R.id.histiryLinearLayout)
    }

    lateinit var db:AppDatabase

    private var isOperator = false
    private var hasOperator = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "historyDB"
        ).build()


    }

    fun buttonClicked(v:View){
        when(v.id){
            R.id.button0 -> numberButtonClicked("0")
            R.id.button1 -> numberButtonClicked("1")
            R.id.button2 -> numberButtonClicked("2")
            R.id.button3 -> numberButtonClicked("3")
            R.id.button4 -> numberButtonClicked("4")
            R.id.button5 -> numberButtonClicked("5")
            R.id.button6 -> numberButtonClicked("6")
            R.id.button7 -> numberButtonClicked("7")
            R.id.button8 -> numberButtonClicked("8")
            R.id.button9 -> numberButtonClicked("9")
            R.id.buttonPlus -> operatorButtonClicked("+")
            R.id.buttonMinus -> operatorButtonClicked("-")
            R.id.buttonMulti -> operatorButtonClicked("*")
            R.id.buttonDivider -> operatorButtonClicked("/")
            R.id.buttonModulo -> operatorButtonClicked("%")
        }
    }

    private fun numberButtonClicked(number:String){
        if(isOperator){
            expressionTextView.append(" ")
        }

        isOperator = false

        val expressionText = expressionTextView.text.split(" ")

        if(expressionText.isNotEmpty() && expressionText.last().length >= 15){
            Toast.makeText(this, "15자리까지만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
            return
        }
        else if (expressionText.last().isEmpty() && number=="0"){
            Toast.makeText(this, "0은 제일 앞에 올 수 없습니다", Toast.LENGTH_SHORT).show()
            return
        }

        expressionTextView.append(number)
        resultTextView.text = calculeateExpression()
    }

    private fun operatorButtonClicked(operator:String){
        if(expressionTextView.text.isEmpty()){
            return
        }

        when{
            isOperator -> {
                val text = expressionTextView.text.toString()
                expressionTextView.text = text.dropLast(1) + operator
            }

            hasOperator -> {
                Toast.makeText(this, "연산잔 한번만 사용", Toast.LENGTH_SHORT).show()
                return
            }

            else -> {
                expressionTextView.append(" $operator")
            }

        }


        val ssb = SpannableStringBuilder(expressionTextView.text)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ssb.setSpan(
                ForegroundColorSpan(getColor(R.color.green)),
                expressionTextView.text.length-1,
                expressionTextView.text.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        expressionTextView.text = ssb
        isOperator = true
        hasOperator = true
    }

    private fun calculeateExpression():String{
        val expressionTexts = expressionTextView.text.split(" ")

        if(hasOperator.not() || expressionTexts.size != 3){
            return ""
        }
        else if (expressionTexts[0].isNumber().not() || expressionTexts[2].isNumber().not()){
            return " "
        }

        val exp1 = expressionTexts[0].toBigInteger()
        val exp2 = expressionTexts[2].toBigInteger()
        val op = expressionTexts[1]

        return when (op){
            "+"-> (exp1+exp2).toString()
            "-"-> (exp1-exp2).toString()
            "*"-> (exp1*exp2).toString()
            "/"-> (exp1/exp2).toString()
            "%"-> (exp1%exp2).toString()
            else -> ""
        }
    }

    fun String.isNumber():Boolean{
        return try{
            this.toBigInteger()
            true
        } catch (e:NumberFormatException){
            false
        }
    }

    fun resultButtonClicked(v:View){
        val expressionText = expressionTextView.text.split(" ")

        if(expressionTextView.text.isEmpty() || expressionText.size == 1){
            return
        }

        if(expressionText.size != 3 && hasOperator){
            Toast.makeText(this, "수식완성해라", Toast.LENGTH_SHORT).show()
            return
        }

        if(expressionText[0].isNumber().not() || expressionText[2].isNumber().not()){
            Toast.makeText(this,"뭐야 이건",Toast.LENGTH_SHORT).show()
            return
        }

        val expression = expressionTextView.text.toString()
        val resultText = calculeateExpression()

        Thread(Runnable {
            db.historyDao().insertHistory(History(null, expression, resultText))
        }).start()

        resultTextView.text=""
        expressionTextView.text=resultText

        isOperator = false
        hasOperator = false
    }

    fun clearButtonClicked(v:View){
        expressionTextView.text = ""
        resultTextView.text = ""
        isOperator = false
        hasOperator = false
    }

    fun historyButtonClicked(v:View){
        historyLayout.isVisible = true
        historyLinearLayout.removeAllViews()

        Thread(Runnable {
            db.historyDao().getAll().reversed().forEach {
                runOnUiThread{
                    val historyView = LayoutInflater.from(this).inflate(R.layout.history_row, null, false)
                    historyView.findViewById<TextView>(R.id.expressionTextView).text = it.expression
                    historyView.findViewById<TextView>(R.id.resultTextView).text = "= ${it.result}"

                    historyLinearLayout.addView(historyView)
                }
            }
        }).start()
    }

    fun closeHistoryButtonClicked(v:View){
        historyLayout.isVisible = false
    }

    fun historyClearButtonClicked(v:View){
        historyLinearLayout.removeAllViews()

        Thread(Runnable {
            db.historyDao().deleteAll()
        }).start()
    }
}