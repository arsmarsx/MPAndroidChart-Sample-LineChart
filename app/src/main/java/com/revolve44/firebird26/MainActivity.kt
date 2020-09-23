package com.revolve44.firebird26

//import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    private var fragmentF: FirstFragment? = null
    private var fragmentS: SecondFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_test)
        supportFragmentManager.beginTransaction()
            .add(R.id.container_a, FirstFragment())
            .add(R.id.container_b, SecondFragment())
            .commit()
    }

}
