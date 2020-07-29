package com.example.calulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    var operator_var:String=""
    var first_num=""
    var second_num=""
    var flag=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
    fun onClick(view: View){
        when(view.id){
            R.id.btn_zero->addNumber("0")
            R.id.btn_one->addNumber("1")
            R.id.btn_two->addNumber("2")
            R.id.btn_three->addNumber("3")
            R.id.btn_four->addNumber("4")
            R.id.btn_five->addNumber("5")
            R.id.btn_six->addNumber("6")
            R.id.btn_seven->addNumber("7")
            R.id.btn_eight->addNumber("8")
            R.id.btn_nine->addNumber("9")
            R.id.btn_clear->clear()
            R.id.btn_plus->operate("+")
            R.id.btn_divide->operate("/")
            R.id.btn_minus->operate("-")
            R.id.btn_multiply->operate("*")
            R.id.btn_equal->calculate()
        }
    }
    fun addNumber(number:String){
        number_view.append(number)
    }
    fun clear(){
        operator_var=""
        first_num=""
        second_num=""
        number_view.text=""
    }
    fun operate(op:String){
        if(operator_var.isEmpty()||(first_num.isNotEmpty() &&second_num.isEmpty() )){
            operator_var=op
            first_num=number_view.text.toString()
            number_view.text=""
        }
        else {
            first_num=calculate()
            operator_var=op
            number_view.text=""

        }
    }
    fun calculate():String{
        var res:Double=0.0
        second_num=number_view.text.toString()

            when (operator_var) {


                "+" -> res = first_num.toDouble() + second_num.toDouble()
                "-" -> res = first_num.toDouble() - second_num.toDouble()
                "*" -> res = first_num.toDouble() * second_num.toDouble()
                "/" -> res = first_num.toDouble() / second_num.toDouble()
                "="-> number_view.text=first_num



            }
        first_num=res.toString()
        second_num=""
        number_view.text=res.toString()
        return res.toString()
    }
}