package com.example.pocketpharma

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.observe
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FavoritesActivity : AppCompatActivity() {
    private val newRecordActivityRequestCode = 1
    private val recordViewModel: recordViewModel by viewModels {
        recordViewModelFactory((application as pocketPharmaApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = MyAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        recordViewModel.allRecords.observe(owner = this) { records->
            // Update the cached copy of the words in the adapter.
            records.let { adapter.submitList(it) }
        }

//        val fab = findViewById<FloatingActionButton>(R.id.fab)
//        fab.setOnClickListener {
//            val intent = Intent(this@MainActivity, NewRecordActivity::class.java)
//            startActivityForResult(intent, newRecordActivityRequestCode)
//        }
    }}

//    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
//        super.onActivityResult(requestCode, resultCode, intentData)
//
//        if (requestCode == newRecordActivityRequestCode && resultCode == Activity.RESULT_OK) {
//            intentData?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let { reply ->
//                val word = Word(reply)
//                wordViewModel.insert(word)
//            }
//        } else {
//            Toast.makeText(
//                applicationContext,
//                R.string.empty_not_saved,
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }
//}