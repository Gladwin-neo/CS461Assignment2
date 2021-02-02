package sg.edu.smu.cs461.cs461assignment2

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sg.edu.smu.cs461.cs461assignment2.databinding.ActivityMainBinding
import java.io.PrintStream

class MainActivity : AppCompatActivity() {
    private lateinit var myAdapter: ArrayAdapter<String>
    private lateinit var binding: ActivityMainBinding
    private var toDoList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
    }

    fun addItem(view: View) {
        val item = (findViewById<EditText>(R.id.item))
        val output = PrintStream(openFileOutput("saved_items.txt", MODE_APPEND))
        output.println(item.text.toString())
        output.close()

        Toast.makeText(this, "You have added ${item.text} to your to do list!", Toast.LENGTH_SHORT).show()
        item.setText("")

        binding.toDoListLv.setOnItemClickListener { list, item, index, id ->
            toDoList.add(item.toString())
            myAdapter.notifyDataSetChanged()
        }
    }
}