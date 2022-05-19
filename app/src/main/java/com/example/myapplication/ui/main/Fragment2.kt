package com.example.myapplication.ui.main

import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.Fragment2Binding
import com.example.recyclerviewsample.ext.viewBinding

/**
 * Fragment2, на который мы производим переход
 */
class Fragment2 : BaseFragment(R.layout.fragment2) {

    /**
     * Биндинг делается делегатом из статьи на хабре
     * [https://habr.com/ru/post/501158/]
     */
    private val binding by viewBinding(Fragment2Binding::bind)

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    companion object {
        private const val ARG_PARAM1 = "param1"

        /**
         * Фабричный метод для создания экземпляра [Fragment2] с передачей ему аргументов
         *
         * @param param1 аргумент 1. Это просто строка, которую фрагмент должен отобразить
         * @return Возвращает экземпляр [Fragment2]
         */
        @JvmStatic
        fun newInstance(param1: String) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}
