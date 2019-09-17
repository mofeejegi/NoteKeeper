package com.mofeejegi.notekeeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        fab.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        listNotes.adapter = ArrayAdapter<NoteInfo>(
            this,
            android.R.layout.simple_list_item_1,
            DataManager.notes
        )


        val listener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(NOTE_POSITION, position)
            startActivity(intent)
        }

        listNotes.onItemClickListener = listener

    }

    override fun onResume() {
        super.onResume()
        (listNotes.adapter as ArrayAdapter<*>).notifyDataSetChanged()
    }
}
