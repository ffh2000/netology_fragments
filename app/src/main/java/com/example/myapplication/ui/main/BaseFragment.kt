package com.example.myapplication.ui.main

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.RouterImpl

/**
 * Базовый класс фрагмента.
 * Поскольку все фрагменты используют механизм shared view model,
 * а значит одну и ту же view model, нет никакого смысла
 * инициализиаровать одинаково во всех фрагментах ViewModel.
 * Ее инициализация вынесена сюда.
 */
open class BaseFragment(
    @LayoutRes contentLayoutId: Int
) : Fragment(contentLayoutId) {

    /**
     * Фабрика, умеющая создавать экземпляр [MainViewModel] с
     * передачей ему нужных ему зависимостей в конструктор.
     * Задание на досуге: придумать такой вариант viewModels, что бы не
     * приходилось так сложно создавать фабрику. Что бы только тело метода create
     * Т.е. должно быть примерно так:
     *     private val viewModel by viewModels<MainViewModel>{
     *         return FilesListViewModel(
     *             FileImagesRepositoryImpl(requireContext())
     *         )
     *     }
     */
    private val filesListViewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(
                RouterImpl(activity = requireActivity()) //конкретной релазации роутера нужен Activity
            ) as T
        }
    }

    /**
     * Создание viewModel паттерном ленивая инициализация.
     * Требуется подключить fragment-ktx
     * Поскольку в [MainViewModel] требуется получение зависимостей через
     * конструктор, создается фабрика, которая потом и создаст экземпляр
     * [MainViewModel] и передаст в него зависимость.
     */
    protected val viewModel by viewModels<MainViewModel> { filesListViewModelFactory }

}
