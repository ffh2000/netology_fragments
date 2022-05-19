package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModel
import com.example.myapplication.Router

/**
 * Основная ViewModel, она и используется как shared view model.
 * Из-за того что данной ViewModel требуется зависимость через конструктор,
 * приходится усложнять в [BaseFragment] создание ViewModel путем определения
 * собственной фабрики т.к. обычный способ создания ViewModel через провайдер
 * не предполагает передачу параметров в конструктор.
 * В реальных приложениях это делатся через Dependency Injection, например
 * с помощью dagger/hilt, koin, kodein и др. библиотек для внедрения заивисмостей.
 */
class MainViewModel(
    private val router: Router
) : ViewModel() {

    /**
     * Метод переключает фрагмент на Fragment2.
     * Реализует бизнес-логику, поэтому должен быть тут согласно MVVM.
     */
    fun gotoBlankFragment() {
        router.toFragment2()
    }

}
