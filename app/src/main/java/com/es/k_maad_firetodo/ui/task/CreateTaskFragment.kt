package com.es.k_maad_firetodo.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.es.k_maad_firetodo.data.model.Note
import com.es.k_maad_firetodo.databinding.FragmentCreateTaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateTaskFragment : Fragment() {

    lateinit var binding: FragmentCreateTaskBinding

    private val viewModel: TaskViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root

        } else {
            binding = FragmentCreateTaskBinding.inflate(inflater, container, false)

            return binding.root
        }


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.submit.setOnClickListener {
            val task = binding.taskEt.text.toString()


            viewModel.addNote(Note("", task, "High", "" + System.currentTimeMillis()))


        }


    }


}