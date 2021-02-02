package sg.edu.smu.cs461.cs461assignment2

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sg.edu.smu.cs461.cs461assignment2.databinding.ActivityMainBinding
import java.io.PrintStream
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var myAdapter: ArrayAdapter<String>
    private lateinit var binding: ActivityMainBinding
    private var toDoList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        
        setupList()
    }

    fun addItem(view: View) {
        val item = (findViewById<EditText>(R.id.item))
        val output = PrintStream(openFileOutput("saved_items.txt", MODE_APPEND))
        output.println(item.text.toString())
        output.close()

        Toast.makeText(this, "You have added ${item.text} to your to do list!", Toast.LENGTH_SHORT).show()

        toDoList.add(item.text.toString())
        myAdapter.notifyDataSetChanged()

        item.setText("")
    }

    fun readFile(){
        val scan = Scanner(openFileInput("file_name.txt"))
        while(scan.hasNextLine()){
            val line = scan.nextLine()
            toDoList.add(line)
        }
        
    }

    private fun setupList() {
        myAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,toDoList)
        binding.toDoListLv.adapter = myAdapter
    }
}