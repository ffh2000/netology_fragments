package com.example.myapplication

import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment

/**
 * Реализация интерфейса роутера.
 * Так сделано с целью инверсии зависимостей т.к. в ViewModel не могут
 * попадать классы, зависящие от ввода/вывода т.е. в данном случае
 * от библиотек android. А реализация данного класса зависит от
 * activity т.е. от библиотеки android.
 *
 * На досуге придумайте такой вариант данной реализации, которая не будетё
 * испольщовать Navigation Component, а будет использовать старый
 * FragmentManager с транзакциями для перехода. Назовите этот класс, например OldRouterImpl и
 * примените. Передайте фабрике для создания ViewModel (см. [BaseFragment]).
 * Больше ничего менять не надо. Это и есть подход инверсии зависимостей.
 */
class RouterImpl(
    val activity: FragmentActivity
): Router {

    //получаю NavHostFragment из activity_mail.xml с помощью паттерна
    //ленивой инициализации
    private val navHostFragment: NavHostFragment by lazy {
        activity.supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
    }

    override fun toFragment2() {
        navHostFragment.navController.navigate(R.id.toFragment2)
    }
}
