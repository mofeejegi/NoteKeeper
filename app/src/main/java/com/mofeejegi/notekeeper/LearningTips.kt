package com.mofeejegi.notekeeper

import android.os.CountDownTimer
import android.view.View

abstract class MyClass(val num: Int) {

    abstract fun myFunction()
}

interface MyOnClickListener {
    fun onClick(v: View)
    fun onLongClick(v: View): Boolean
}

var lis = object: View.OnClickListener {
    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

var lisLambda = View.OnClickListener {}
var lisLambda2 = View.OnClickListener {v -> }

var ct = object : CountDownTimer(3000L, 1000L) {
    override fun onTick(millisUntilFinished: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFinish() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

var mc = object: MyClass(1) {
    override fun myFunction() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

var mi2 = object : MyOnClickListener {
    override fun onLongClick(v: View): Boolean {
        return false
    }

    override fun onClick(v: View) {

    }
}


class SomeStuff {

    fun showName(p: Person?) {
        var n: String? = null
        if (p != null)
            n = p.name

        var textName = n ?: "Unknown"
        print(textName)

    }

    fun showName2(p: Person?) {

        var textName = p?.name ?: "Unknown"
        print(textName)

    }

    fun returnBoolean(): Boolean {
        return true
    }

    var lista = listOf("ho", "ho")


    var p = Person("M", 6.0)
}

