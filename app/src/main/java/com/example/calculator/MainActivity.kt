package com.example.calculator

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var b:Button? =null


    var flag=true
    var op="+"
    var oldNum=""
    var newNum=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onResume()
    }

    override fun onResume() {
        super.onResume()
        val mp= MediaPlayer.create(this,R.raw.sound)
        b=findViewById<View>(R.id.button1) as Button
        b!!.setOnClickListener{
            mp.start()
//            startActivity(Intent(this,MainActivity::class.java))
        }

    }


    fun buttonPress(view: View) {
        if(flag){
            input.setText("")
            flag=false
        }
        var btn :String=input.text.toString()
        val b=view as Button
        when(b.id){
            button10.id->{btn +="1"}
            button11.id->{btn +="2"}
            button12.id->{btn +="3"}
            button7.id->{btn +="4"}
            button8.id->{btn +="5"}
            button6.id->{btn +="6"}
            button4.id->{btn +="7"}
            button5.id->{btn +="8"}
            button9.id->{btn +="9"}
            button13.id->{btn +="0"}
            button14.id->{btn +="00"}
            button15.id->{btn+="."}
            button22.id->{btn ="-$btn"}

        }
        input.setText(btn)
    }
    fun operator(view: View) {
        flag=true
        oldNum=input.text.toString()
        val b1=view as Button
        when(b1.id){
            button17.id->{op="+"}
            button18.id->{op="-"}
            button19.id->{op="*"}
            button20.id->{op="/"}
        }
    }

    fun calculate(view: View) {
        newNum=input.text.toString()
        var ans=0.0
        when(op){
            "+"->{ans=oldNum.toDouble()+newNum.toDouble()}
            "-"->{ans=oldNum.toDouble()-newNum.toDouble()}
            "*"->{ans=oldNum.toDouble()*newNum.toDouble()}
            "/"->{ans=oldNum.toDouble()/newNum.toDouble()}
        }
        input.setText(ans.toString())
    }

    fun clear(view: View){
        input.setText("0")
        flag=true
    }

    fun percent(view: View) {
        val res=(input.text.toString().toDouble())/100.0
        input.setText(res.toString())


        flag=true
    }





}