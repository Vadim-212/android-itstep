package kz.step.stepeducation.presentation.activity

import android.app.AlertDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_test.*
import kz.step.stepeducation.R
import kotlin.collections.ArrayList

class TestActivity : AppCompatActivity() {
    var answerButtonsList: List<Button>? = null
    val questions: Map<Int, String> = mapOf(1 to "Какой язык программирования поддерживает Android Studio?",
                                            2 to "Какое расширение у файлов activity?")
    val answers: Map<Int, String> = mapOf(1 to "Kotlin", 2 to "xml")
    val wrongAnswers: Map<Int, ArrayList<String>> = mapOf(1 to arrayListOf("Python", "JavaScript", "PHP"),
                                                        2 to arrayListOf("html", "py", "cpp"))
    var questionCounter: Int = 0
    var rightAnswersCount: Int = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        initializeViews()
        loadNextQuestion()
        initializeListeners()
    }

    fun initializeViews() {
        answerButtonsList = arrayListOf(button_activity_test_answer1,
                                        button_activity_test_answer2,
                                        button_activity_test_answer3,
                                        button_activity_test_answer4)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun initializeListeners() {
        for (answerButton in this!!.answerButtonsList!!) {
            answerButton?.setOnClickListener {
                checkAnswer(answerButton?.text as String)
                loadNextQuestion()
            }
        }
    }

    fun checkAnswer(answer: String) {
        val rightAnswer = answers[questionCounter]
        if(answer == rightAnswer) {
            val toast = Toast.makeText(applicationContext, "Верный ответ!", Toast.LENGTH_SHORT)
            toast.show()
            rightAnswersCount++
        } else {
            val toast = Toast.makeText(applicationContext, "Ответ неверный", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun loadNextQuestion() {
        questionCounter++
        val question = questions.getOrDefault(questionCounter, "null")
        if(question == "null") {
            // Вопросов больше нет
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Конец теста!")
            builder.setMessage("Количество правильных ответов - $rightAnswersCount")

            builder.setPositiveButton(android.R.string.ok) { dialog, which -> }
            builder.setNeutralButton("Пройти повторно") {dialog, which ->
                questionCounter = 0
                rightAnswersCount = 0
                loadNextQuestion()
            }
            builder.show()
        } else {
            textview_activity_test_question?.text = questions.get(questionCounter)
            var answersList = wrongAnswers.get(questionCounter)
            if (answersList != null) {
                answers.get(questionCounter)?.let { answersList.add(it) }
                answersList.shuffle()
            }
            for(i: Int in 0 until (answerButtonsList?.count() ?: 1)) {
                answerButtonsList?.get(i)?.text = answersList?.get(i)
            }
        }
    }
}