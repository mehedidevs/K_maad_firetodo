package com.es.k_maad_firetodo.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.es.k_maad_firetodo.R
import com.es.k_maad_firetodo.databinding.FragmentCreateTaskBinding


class CreateTaskFragment : Fragment() {

    lateinit var binding: FragmentCreateTaskBinding


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




    }


}