package kz.step.stepeducation.presentation.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kz.step.stepeducation.presentation.fragments.MoviesFragment
import kz.step.stepeducation.presentation.utils.SortTypes

class MoviesPagerAdapter: FragmentPagerAdapter {
    val TABS_COUNT = 3
    var context: Context

    constructor(manager: FragmentManager, context: Context) : super(manager) {
        this.context = context
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MoviesFragment(SortTypes.NONE)
            1 -> MoviesFragment(SortTypes.RANDOM)
            else -> MoviesFragment(SortTypes.ALPHABETICALLY)
        }
    }

    override fun getCount(): Int {
        return TABS_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Фильмы"
            1 -> "Случайная сортировка"
            else -> "Сортировка по алфавиту"
        }
    }
}