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
import com.es.k_maad_firetodo.data.model.Note
import com.es.k_maad_firetodo.databinding.FragmentNoteListShowBinding
import com.es.k_maad_firetodo.ui.adapters.NoteAdapter
import com.es.k_maad_firetodo.ui.task.TaskViewModel
import com.es.k_maad_firetodo.utils.UiState
import com.es.k_maad_firetodo.utils.hide
import com.es.k_maad_firetodo.utils.hideBtn
import com.es.k_maad_firetodo.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.annotation.meta.When

@AndroidEntryPoint
class NoteListShowFragment : Fragment() {

    lateinit var binding: FragmentNoteListShowBinding
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentNoteListShowBinding.inflate(inflater, container, false)
            return binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_noteListShowFragment_to_createTaskFragment)


        }



        viewModel.getAllTaskData()
        viewModel.allTask.observe(viewLifecycleOwner) { state ->

            when (state) {
                is UiState.Failure -> {
                    Log.i("TAG", "Failure : ${state.message} ")

                }
                is UiState.Loading -> {

                    Log.i("TAG", "Loading ")
                }
                is UiState.Success -> {
                    val data: List<Note> = state.data!!
                    Log.i("TAG", "onViewCreated: $data")


                    setRecyclerView(data);


                }
            }
        }


    }

    private fun setRecyclerView(data: List<Note>) {
        val noteAdapter = NoteAdapter(requireActivity(), data)

        binding.noteListRecyclerview.adapter = noteAdapter


    }


}

