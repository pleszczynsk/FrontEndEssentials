package com.pawelleszczynski.frontendessentials
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class CSSMin {
    fun main() {
        // Input File
        val input = File("/path/to/file.css")

        // Create Content
        val content = StringBuilder().apply {
            append(URLEncoder.encode("input", "UTF-8"))
            append("=")
            append(URLEncoder.encode(input.readText(), "UTF-8"))
        }.toString()

        // Create Request
        val request = (URL("https://cssminifier.com/raw").openConnection() as HttpURLConnection).apply {
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

        // Parse Response
        if(request.responseCode == 200) {

            // Print Result
            println(InputStreamReader(request.inputStream).readText())
        }

        // Handle Error
        else println("Error: ${request.responseCode} ${request.responseMessage}")

    }
}