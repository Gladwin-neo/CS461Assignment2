package sg.edu.smu.cs461.cs461assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import org.w3c.dom.Text
import java.io.File
import java.io.PrintStream
import android.content.Context
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addItem(view: View) {
        val item = (findViewById<EditText>(R.id.item))
        val output = PrintStream(openFileOutput("saved_items.txt", MODE_APPEND))
        output.println(item.text.toString())
        output.close()

        Toast.makeText(this, "You have added ${item.text} to your to do list!", Toast.LENGTH_SHORT).show()
        item.setText("")


    }
}