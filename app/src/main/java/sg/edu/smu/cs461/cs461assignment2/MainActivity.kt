package sg.edu.smu.cs461.cs461assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import org.w3c.dom.Text
import sg.edu.smu.cs461.cs461assignment2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var toDoItem = ArrayList<String>()
    private lateinit var myAdapter: ArrayAdapter<String>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

    }

    fun addItem(view: View) {
        val item = findViewById<EditText>(R.id.item)
    }
}