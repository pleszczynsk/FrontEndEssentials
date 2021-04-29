package com.pawelleszczynski.frontendessentials


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onOptionSearch(view: View)
    {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }
    fun onOptionMinUnmin(view: View)
    {
        val intent = Intent(this, MinUnminActivity::class.java)
        startActivity(intent)
    }
    fun onOptionGraph(view: View)
    {
        val intent = Intent(this, GraphActivity::class.java)
        startActivity(intent)
    }
    fun onOptionCalc(view: View)
    {
        val intent = Intent(this, CalcActivity::class.java)
        startActivity(intent)
    }
    fun onOptionTemp(view: View)
    {
        val intent = Intent(this, TemplateActivity::class.java)
        startActivity(intent)
    }
}