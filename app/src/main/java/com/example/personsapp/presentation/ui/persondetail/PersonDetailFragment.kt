package com.example.personsapp.presentation.ui.persondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.personsapp.databinding.FragmentPersonDetailBinding
import com.example.personsapp.presentation.ui.PersonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailFragment: Fragment() {

    private var _binding: FragmentPersonDetailBinding? = null
    private val binding: FragmentPersonDetailBinding get() = _binding!!

    private val viewModel: PersonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonDetailBinding.inflate(inflater, container, false)
        initObservers()
        return binding.root
    }

    private fun initObservers() {
        binding.apply {
            viewModel.person.observe(viewLifecycleOwner){ person ->
                tvFpdName.text = "${person.name.title} ${person.name.first} ${person.name.last}"
                tvFpdEmail.text = person.email
                ivFpdImage.load(person.photo)
                tvFpdGender.text = person.gender
                tvFpdAge.text = person.age.toString()
                tvFpdCity.text = person.city
            }
        }
    }
}