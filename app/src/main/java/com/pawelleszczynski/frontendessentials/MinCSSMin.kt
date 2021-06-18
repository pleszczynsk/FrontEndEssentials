package com.pawelleszczynski.frontendessentials

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.minunmin_css_min.*
import kotlinx.coroutines.*
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


class MinCSSMin: AppCompatActivity() {
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.Main + job)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.minunmin_css_min)

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
    suspend fun cssMinify(inputstr: Editable)= withContext(Dispatchers.IO){
        val content = StringBuilder().apply {
            append(URLEncoder.encode("input", "UTF-8"))
            append("=")
            append(URLEncoder.encode(inputstr.toString(), "UTF-8"))
        }.toString()
        val request =
            (URL("https://cssminifier.com/raw").openConnection() as HttpURLConnection).apply {
                requestMethod = "POST"
                doOutput = true
                setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
                setRequestProperty("charset", "utf-8")
                setRequestProperty("Content-Length", content.length.toString())
                OutputStreamWriter(outputStream).apply {
                    write(content)
                    flush()
                }
            }
        if (request.responseCode == 200) {
            return@withContext InputStreamReader(request.inputStream).readText()
        }
        else return@withContext "Error: ${request.responseCode} ${request.responseMessage}"
    }
    fun onSendCSSMinify(view: View) {
        scope.launch { output_minify.text = cssMinify(input_text_view1.text) }
    }
}