package com.es.k_maad_firetodo.ui.note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.es.k_maad_firetodo.R
import com.es.k_maad_firetodo.databinding.FragmentNoteListShowBinding
import com.es.k_maad_firetodo.ui.task.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListShowFragment : Fragment() {

    lateinit var binding: FragmentNoteListShowBinding
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentNoteListShowBinding.inflate(inflater, container, false)

            return binding.root
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllTaskData().forEach {
            Log.i("TAG", "Task Name : ${it.noteText} ")

        }




        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_noteListShowFragment_to_createTaskFragment)

        }

    }


}