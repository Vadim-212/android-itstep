package kz.step.stepeducation.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity: AppCompatActivity() {
    abstract fun initializeDefaultFragment()

    abstract fun displayFragment(fragment: Fragment)

    abstract fun getActivityInstance(): BaseActivity
}