//  Вывод строк в Log (ключ: "ShowPoem") при изменении событий жизненного цикла Activity
//  Для добавления строк нажимать на кнопки или поворачивать.
//   Кнопка "првтор" начинает вывод с начала
//

package com.example.poemlog

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var repitBat: TextView   // кнопка "повтор"

    var count = 1           // счетчик изменения состояния
    var LogKey = "ShowPoem" // ключ для логирования !!
    var SaveKey = "GGG"   // ключ для сохранения

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {       //  получение сохраненного счетчика
            count = savedInstanceState.getInt(SaveKey) +1
        }

        repitBat = findViewById(R.id.repite)
        repitBat.setOnClickListener {           //  прослушивание кнопки "повтор"
            count = 1
            Log.d(LogKey, "\n---------повтор---------\n")
        }

        logString ()
    }

    override fun onStart() {
        super.onStart()
        logString ()
    }

    override fun onResume() {
        super.onResume()
        logString ()
    }

    override fun onPause() {
        super.onPause()
        logString ()
    }

    override fun onStop() {
        super.onStop()
        logString ()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
        logString ()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SaveKey, count)
//        logMassage("сохранен count")
        logString ()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        logMassage("вызвано восстановление")
        logString ()
    }



    fun logMassage (string: String){   //  вывод строк в log
        Log.d(LogKey, "  " + string)
        count++
    }

    fun logString (){    //  выбор строк по номеру
        when(count){
            1 -> logMassage("Заунывный ветер гонит")
            2 -> logMassage("Стаю туч на край небес.")
            3 -> logMassage("Ель надломленная стонет,")
            4 -> logMassage("Глухо шепчет темный лес.")
            5 -> logMassage("На ручей, рябой и пестрый,")
            6 -> logMassage("За листком летит листок,")
            7 -> logMassage("И струей, сухой и острой;")
            8 -> logMassage("Набегает холодок.")
            9 -> logMassage("Полумрак на все ложится,")
            10 -> logMassage("Налетев со всех сторон,")
            11 -> logMassage("С криком в воздухе кружится")
            12 -> logMassage("Стая галок и ворон…")
            13 -> logMassage("\nэто был Н.Некрасов \"Перед дождем\"")

        }

    }
}