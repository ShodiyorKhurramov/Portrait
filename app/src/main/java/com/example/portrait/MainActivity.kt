package com.example.portrait

import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    private fun initView(){
        val text1:TextView?=findViewById(R.id.text)
        //val list=extractUrls(text1!!.text.toString())
        // text1.text=list.toString()
    }


    fun extractUrls(input: String): List<String>? {
        val result: MutableList<String> = ArrayList()
        val words = input.split("\\s+").toTypedArray()
        val pattern: Pattern = Patterns.WEB_URL
        for (word in words) {
            var word=""
            if (pattern.matcher(word).find()) {
                if (!word.toLowerCase().contains("http://") && !word.toLowerCase().contains("https://")) {
                   word+= "http://$word"
                }
                result.add(word)
            }
        }
        return result
    }
}