package com.example.myapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
    private val taskList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Создание адаптера
        adapter = CustomAdapter(taskList)
        recyclerView.adapter = adapter

        // Установка обработчика кликов для кнопки добавления задачи
        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            addTask()
        }
    }

    private fun addTask() {
        val task = findViewById<EditText>(R.id.new_work).text.toString()
        if (task.isNotEmpty()) {
            taskList.add(task) // Добавляем задачу
            adapter.notifyItemInserted(taskList.size - 1) // Уведомляем адаптер об изменении
            findViewById<EditText>(R.id.new_work).text.clear() // Очищаем поле
        }
    }
}