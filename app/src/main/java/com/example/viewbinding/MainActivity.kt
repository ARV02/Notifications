package com.example.viewbinding

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viewbinding.databinding.ActivityMainBinding
import com.example.viewbinding.notifications.notification

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var i: Intent
    private var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.button.setOnClickListener {
            val name: String = binding.nombre.text.toString()
            Toast.makeText(this, "Hello: " + name,Toast.LENGTH_SHORT).show()
            i = Intent(context, notification::class.java)
            context.startService(i)
        }
    }

    private fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
    }
}