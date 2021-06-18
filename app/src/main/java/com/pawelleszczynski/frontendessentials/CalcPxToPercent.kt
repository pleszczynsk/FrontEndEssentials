package com.pawelleszczynski.frontendessentials

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.calc_px_to_percent.*
import java.math.BigDecimal
import java.math.RoundingMode

class CalcPxToPercent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calc_px_to_percent)

        if(savedInstanceState != null) {

            output_px_to_percent?.text = savedInstanceState?.get("saved1") as CharSequence?
            input_text_view1?.text = Editable.Factory.getInstance().newEditable(savedInstanceState?.get("saved2") as CharSequence?)
            input_text_view2?.text = Editable.Factory.getInstance().newEditable(savedInstanceState?.get("saved3") as CharSequence?)
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
                    startActivity(Intent(this, MinActivity::class.java))
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
    fun emToPx(view: View)
    {
        output_px_to_percent.text = ((BigDecimal((input_text_view2.text.toString().toDouble()/input_text_view1.text.toString().toDouble() )*100.0).setScale(2,RoundingMode.HALF_EVEN)).toString())
    }

    override fun onSaveInstanceState(@NonNull outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("saved1", output_px_to_percent.text.toString())
        outState.putString("saved2", input_text_view1.text.toString())
        outState.putString("saved3", input_text_view2.text.toString())
    }
}