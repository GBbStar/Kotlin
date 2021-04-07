package org.techtown.lotto

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private val clearBtn:Button by lazy{
        findViewById<Button>(R.id.clearButton)
    }

    private val addBtn:Button by lazy{
        findViewById<Button>(R.id.addButton)
    }

    private val runBtn:Button by lazy{
        findViewById<Button>(R.id.runButton)
    }

    private val numberPicker:NumberPicker by lazy{
        findViewById<NumberPicker>(R.id.numberPicker)
    }

    private val numberTextViewList:List<TextView> by lazy{
        listOf<TextView>(
            findViewById<TextView>(R.id.num1),
            findViewById<TextView>(R.id.num2),
            findViewById<TextView>(R.id.num3),
            findViewById<TextView>(R.id.num4),
            findViewById<TextView>(R.id.num5),
            findViewById<TextView>(R.id.num6)
        )
    }

    private var didRun = false

    private val pickNumberSet = hashSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNumberPicker()
        initRunButton()
        initAddButton()
        initClearButton()
    }

    private fun initNumberPicker() {
        numberPicker.minValue = 1
        numberPicker.maxValue = 45
    }

    private fun initAddButton(){
        addBtn.setOnClickListener {
            // 자동 생성 되어있는 경우
            if (didRun) {
                Toast.makeText(this, "초기화하고 시도해주세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 이미 5개가 뽑혀있는 경우
            if(pickNumberSet.size >= 6){
                Toast.makeText(this, "번호는 6개까지만 ~~", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 이미 뽑은 데이터인 경우
            if(pickNumberSet.contains(numberPicker.value)){
                Toast.makeText(this, "이미 뽑혀있어요~~", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val textView = numberTextViewList[pickNumberSet.size]
            textView.isVisible = true
            textView.text = numberPicker.value.toString()

            setNumberBackground(numberPicker.value, textView)
            pickNumberSet.add(numberPicker.value)
        }
    }


    @SuppressLint("ResourceAsColor")
    private fun setNumberBackground(number:Int, textView: TextView) {
        when(number) {
            in 1..10 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_yello)
            in 11..20 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_blue)
            in 21..30 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_red)
            in 31..40 -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_gray)
            else -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_green)

        }
    }
    private fun initClearButton(){
        clearBtn.setOnClickListener {
            pickNumberSet.clear()
            numberTextViewList.forEach {
                it.isVisible = false
            }

            didRun = false
        }
    }

    private fun initRunButton(){
        runBtn.setOnClickListener {
            val list = getRandomNumber()

            didRun = true

            list.forEachIndexed { index, i ->
                val textView = numberTextViewList[index]

                textView.text = i.toString()
                textView.isVisible = true

                setNumberBackground(i, textView)
            }
        }
    }

    private fun getRandomNumber():List<Int>{
        val numberList = mutableListOf<Int>()
            .apply {
                for(i in 1..45){
                    if (pickNumberSet.contains(i)){
                        continue
                    }
                    this.add(i)
                }
            }

        numberList.shuffle()

        val newList = pickNumberSet.toList() + numberList.subList(0, 6-pickNumberSet.size)

        return newList
    }
}