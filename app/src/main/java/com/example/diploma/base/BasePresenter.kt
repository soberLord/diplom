package com.example.diploma.base

import com.example.diploma.injection.component.DaggerPresenterInjector
import com.example.diploma.injection.component.PresenterInjector
import com.example.diploma.injection.module.ContextModule
import com.example.diploma.injection.module.PresenterModule
import com.example.diploma.ui.main.MainPresenter
import com.example.diploma.ui.record.RecordPresenter

/**
 * Base presenter any presenter of the application must extend. It provides initial injections and
 * required methods.
 * @param V the type of the View the presenter is based on
 * @property view the view the presenter is based on
 * @constructor Injects the required dependencies
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {
    /**
     * The injector used to inject required dependencies
     */
    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .presenterModule(PresenterModule)
        .build()

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(){}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed(){}

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is MainPresenter -> injector.inject(this)
            is RecordPresenter -> injector.inject(this)
        }
    }
}