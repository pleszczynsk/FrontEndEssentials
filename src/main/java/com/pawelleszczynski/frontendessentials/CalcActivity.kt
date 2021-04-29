package com.pawelleszczynski.frontendessentials

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calc.*

class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

    if(savedInstanceState != null) {
        output_px_to_em?.text = savedInstanceState?.get("savedEquation1") as CharSequence?
        output_em_to_px?.text = savedInstanceState?.get("savedEquation2") as CharSequence?
    }
}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.toolbar, menu)

        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item != null)
        {
            when (item.itemId)
            {

                R.id.option_1 ->
                {
                    startActivity(Intent(this, MainActivity::class.java))
                }
                R.id.option_2 ->
                {
                    startActivity(Intent(this, SearchActivity::class.java))
                }
                R.id.option_3 ->
                {
                    startActivity(Intent(this, MinUnminActivity::class.java))
                }
                R.id.option_4 ->
                {
                    startActivity(Intent(this, GraphActivity::class.java))
                }
                R.id.option_5 ->
                {
                    startActivity(Intent(this, CalcActivity::class.java))
                }
                R.id.option_6 ->
                {
                    startActivity(Intent(this, TemplateActivity::class.java))
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun px_to_em(view: View)
    {
        output_px_to_em.text = ( input_text_view1.text.toString().toDouble()/input_text_view2.text.toString().toDouble() ).toString()
    }
    fun em_to_px(view: View)
    {
        output_em_to_px.text = ( input_text_view3.text.toString().toDouble()/input_text_view4.text.toString().toDouble() ).toString()
    }
    fun px_to_rem()
    {

    }
    fun rem_to_px()
    {

    }
    fun px_to_percent()
    {

    }
    fun percent_to_px()
    {

    }
    fun px_to_vw()
    {

    }
    fun vw_to_px()
    {

    }
    fun vh_to_px()
    {

    }
    fun px_to_vh()
    {

    }
    override fun onSaveInstanceState(@NonNull outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("savedEquation1", output_px_to_em.text.toString())
        outState.putString("savedEquation2", output_em_to_px.text.toString())
    }
}