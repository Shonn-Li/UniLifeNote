package com.noteapplication.cs398

import android.app.Activity
import android.os.Bundle
import com.noteapplication.cs398.databinding.ReadNoteBinding

class ReadNoteActivity :Activity(){
    private lateinit var binding:ReadNoteBinding

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        binding = ReadNoteBinding.inflate(layoutInflater)

        val noteItem = intent.getSerializableExtra("noteItem") as Note
        binding.noteTitle.setText(noteItem.noteTitle)
        binding.noteContent.setText(noteItem.noteContent)

        setContentView(binding.root)
    }
}