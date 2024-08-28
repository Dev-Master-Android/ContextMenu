package com.example.contextmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var gradeInput: EditText
    private lateinit var randomNumberButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gradeInput = findViewById(R.id.gradeInput)
        randomNumberButton = findViewById(R.id.randomNumberButton)

        registerForContextMenu(gradeInput)

        randomNumberButton.setOnClickListener {
            val randomNumber = Random.nextInt(1, 51)
            gradeInput.setText(randomNumber.toString())
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.title) {
            "Цветовое качество" -> updateColorQuality()
            "Выход из приложения" -> finish()
            else -> return super.onContextItemSelected(item)
        }
        return true
    }

    private fun updateColorQuality() {
        val gradeString = gradeInput.text.toString()
        if (gradeString.isNotEmpty()) {
            val grade = gradeString.toIntOrNull()
            when (grade) {
                1 -> gradeInput.setBackgroundColor(Color.parseColor("#FFA500"))
                2 -> gradeInput.setBackgroundColor(Color.YELLOW)
                3 -> gradeInput.setBackgroundColor(Color.GREEN)
                4 -> gradeInput.setBackgroundColor(Color.BLUE)
                5 -> gradeInput.setBackgroundColor(Color.RED)
                in 1..10 -> gradeInput.setTextColor(Color.RED)
                in 11..20 -> gradeInput.setTextColor(Color.parseColor("#FFA500"))
                in 21..30 -> gradeInput.setTextColor(Color.YELLOW)
                in 31..40 -> gradeInput.setTextColor(Color.GREEN)
                in 41..50 -> gradeInput.setTextColor(Color.BLUE)
                else -> Toast.makeText(this, "Оценка должна быть от 1 до 5", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Введите оценку", Toast.LENGTH_SHORT).show()
        }
    }
}
























































