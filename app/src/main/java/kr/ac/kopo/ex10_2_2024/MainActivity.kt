package kr.ac.kopo.ex10_2_2024

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var voteCount = IntArray(9)

        for(i in 0 .. 8)
            voteCount[i] = 0

        var image = arrayOfNulls<ImageView>(9)

        var imageId = arrayOf(R.id.img01, R.id.img02, R.id.img03, R.id.img04, R.id.img05,
            R.id.img06, R.id.img07, R.id.img08, R.id.img09)

        var imgName = arrayOf("명화 1", "명화 2", "명화 3", "명화 4", "명화 5", "명화 6",
            "명화 7", "명화 8", "명화 9")

        for(i in imageId.indices){
            image[i] = findViewById(imageId[i])
            image[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i] + "총" + voteCount[i] + "표", Toast.LENGTH_SHORT).show()

            }
        }

        var btnDone = findViewById<Button>(R.id.btnDone)
        btnDone.setOnClickListener {
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("imgName", imgName)
            intent.putExtra("vateCount", voteCount)
            startActivity(intent)
        }
        var btnHome = findViewById<Button>(R.id.btnHome)
        btnHome.setOnClickListener {
            finish()
        }
    }
}