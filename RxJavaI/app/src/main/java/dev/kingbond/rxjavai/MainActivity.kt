package dev.kingbond.rxjavai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Subscriber
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val TAG: String = "Hello"
    private var list = ArrayList<StudentClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJust.setOnClickListener {
            Observable.just("Message")
                .subscribe(
                    { value -> Log.d(TAG, "Proceed to my name") },
                    { error -> Log.d(TAG, "Some error occured") },
                    { Log.d(TAG, "My name is Mausam Singh") }
                )
        }

        bntfromArrayButton.setOnClickListener {
            Observable.fromArray("Tokyo", "Ghoul", "Hello", "World")
                .subscribe {
                    Log.d(TAG, it)
                }
        }

        btnRangeButton.setOnClickListener {
            Observable.intervalRange(20L, 20L, 0L, 1L, TimeUnit.SECONDS)
                .subscribe() {
                    Log.d(TAG, "$it")
                }

        }


        btnListOfStudnet.setOnClickListener {
            list.clear()

            for (i in 0..99) {
                if (i >= 0 && i <= 35) list.add(StudentClass(i, "Mausam"))
                else if (i >= 36 && i <= 70) list.add(StudentClass(i, "Tokyo"))
                else if (i >= 71 && i < 80) list.add(StudentClass(i, "Attack on Titan"))
                else list.add(StudentClass(i, "Roberto Juice"))
            }

           var newList=ArrayList<StudentClass>()

//            newList.flatMap(Observable::fromIterable)
//                .filt

        }


    }


}

