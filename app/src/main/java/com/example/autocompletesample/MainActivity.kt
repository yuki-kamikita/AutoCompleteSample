package com.example.autocompletesample

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View.OnFocusChangeListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val autoComplete = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val array: Array<String> = arrayOf("mm", "cm", "m", "km", "g", "mg") // ここはリソースファイルでやろ

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, array
        )
        autoComplete.setAdapter(adapter)
        autoComplete.threshold = 1 // 最低値が1しかできない 入力必須項目

        // （必要だったら）タップ時に強制的に全表示させる
        autoComplete.onFocusChangeListener = OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) autoComplete.showDropDown()
        }

        // TODO: 文字数カウントして0だったら強制表示、もあったらあった方がいいかも

    }
}