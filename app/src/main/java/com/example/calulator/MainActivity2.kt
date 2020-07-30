package com.example.calulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.lang.Math.*
import kotlin.math.cos
import kotlin.math.tan
import kotlin.math.tanh

class MainActivity2 : AppCompatActivity() {
    var operator_var:String=""
    var first_num=""
    var second_num=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        number_view.text=cos(0.0).toString()
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
            R.id.btn_deposit->operate("%")
            R.id.btn_sin->operate("sin")
            R.id.btn_cos->operate("cos")
            R.id.btn_tan->operate("tan")
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
        if ((op=="sin"||op=="cos"||op=="tan")&&first_num.isNotEmpty()&&second_num.isEmpty()){
            operator_var=op


            calculate()
        }
        else
        if(operator_var.isEmpty()||(first_num.isNotEmpty() &&second_num.isEmpty() )){
            operator_var=op
            first_num=number_view.text.toString()
            number_view.text=""
        }
        else {
            first_num=calculate()
            operator_var=op
            if ((op=="sin"||op=="cos"||op=="tan")&&first_num.isNotEmpty()&&second_num.isEmpty()){
                calculate()
                operator_var=""
            }
            else {
                number_view.text = ""
            }
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
                "%" -> res = first_num.toDouble() % second_num.toDouble()
                "sin"->res= kotlin.math.sin(first_num.toDouble()*0.0174532925)
                "cos"->res= kotlin.math.cos(first_num.toDouble()*0.0174532925)
                "tan"->res= kotlin.math.tan(first_num.toDouble()*0.0174532925)
                "="-> number_view.text=first_num

            }
        first_num=res.toString()
        second_num=""
        number_view.text=res.toString()
        return res.toString()
    }
}