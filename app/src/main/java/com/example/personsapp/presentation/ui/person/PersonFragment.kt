package com.example.personsapp.presentation.ui.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.personsapp.R
import com.example.personsapp.databinding.FragmentPersonBinding
import com.example.personsapp.domain.model.Person
import com.example.personsapp.presentation.ui.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonFragment: Fragment() {

    private var _binding: FragmentPersonBinding? = null
    private val binding: FragmentPersonBinding get() = _binding!!

    private val viewModel: PersonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonBinding.inflate(inflater, container, false)
        initView()
        initObservers()
        return binding.root
    }

    private fun initView() {
        binding.rvFpPersonList.layoutManager = LinearLayoutManager(context)
    }

    private fun initObservers() {
        binding.apply {
            viewModel.listPerson.observe(viewLifecycleOwner){ list ->
                val personAdapter = PersonAdapter( object: OnItemClick{
                    override fun onClick(item: Person) {
                        viewModel.setPerson(item)
                        findNavController().navigate(R.id.action_fragmentPerson_to_fragmentPersonDetail)
                    }
                })
                personAdapter.submitList(list)
                rvFpPersonList.adapter = personAdapter
            }
        }
    }

}