package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.databinding.Fragment1Binding
import com.example.recyclerviewsample.ext.viewBinding

class Fragment1 : BaseFragment(R.layout.fragment1) {

    /**
     * Биндинг делается делегатом из статьи на хабре
     * [https://habr.com/ru/post/501158/]
     */
    private val binding by viewBinding(Fragment1Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners() //выделено в функцию с целью разделения уровней абстракции. Код читается понятнее. см. книгу "Чистый код"
    }

    /**
     * Метод устанавливает всем кому надо слушателей на клики
     */
    private fun setupClickListeners() {
        binding.apply {
            //данный фрагмент в MVVM является видом (view), он не может рализовывать никакой логики,
            //только выполнять элементарные действия т.е. вызвать метод из viewModel
            blankFragmentButton.setOnClickListener { viewModel.gotoBlankFragment() }
        }
    }

}
