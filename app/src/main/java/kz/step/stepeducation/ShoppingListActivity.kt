package kz.step.stepeducation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class ShoppingListActivity : AppCompatActivity() {
    val CHECKBOX_COUNT = 15
    var layout: LinearLayout? = null
    var checkButton: Button? = null
    val checkboxList: ArrayList<CheckBox> = ArrayList()
    val productsList: ArrayList<String> = arrayListOf("Хлеб", "Молоко", "Яйца", "Сливочное масло", "Подсолнечное масло",
                                                      "Кефир", "Сметана", "Творог", "Сыр", "Колбаса",
                                                      "Сосиски", "Мясо", "Фарш", "Вода", "Газировка",
                                                      "Мороженное", "Пельмени", "Лаваш", "Лепёшка", "Багет",
                                                      "Огурцы", "Помидоры", "Яблоки", "Бананы", "Рыба",
                                                      "Моющее средство", "Мыло", "Шампунь", "Салфетки", "Конфеты")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        layout = findViewById(R.id.layout_activity_shopping_list)
        checkButton = Button(this)

        var checkbox: CheckBox
        var layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        var randomItem: String
        for(i in 0..CHECKBOX_COUNT) {
            checkbox = CheckBox(this)
            checkbox.layoutParams = layoutParams
            randomItem = productsList.get(Random.nextInt(0, productsList.size))
            productsList.remove(randomItem)
            checkbox.text = randomItem
            layout?.addView(checkbox)
            layout?.invalidate()
            checkboxList.add(checkbox)
        }

        checkButton?.layoutParams = layoutParams
        checkButton?.text = "Check"
        layout?.addView(checkButton)
        layout?.invalidate()
    }

    fun initializeListeners() {
        checkButton?.setOnClickListener {
            for(checkbox in checkboxList) {
                if(checkbox.isChecked)
                    checkbox.setBackgroundColor(Color.WHITE)
                else
                    checkbox.setBackgroundColor(Color.RED)
            }
        }
    }
}