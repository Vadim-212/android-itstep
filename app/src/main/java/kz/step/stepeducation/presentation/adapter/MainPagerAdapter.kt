package kz.step.stepeducation.presentation.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kz.step.stepeducation.presentation.fragments.MainFragment
import kz.step.stepeducation.presentation.fragments.NotesFragment
import kz.step.stepeducation.presentation.fragments.StudentsFragment

class MainPagerAdapter: FragmentPagerAdapter {
    var context: Context
    val TABS = arrayListOf<String>("Main", "Студенты", "Заметки")

    constructor(manager: FragmentManager, context: Context): super(manager) {
        this.context = context
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MainFragment()
            1 -> StudentsFragment()
            else -> NotesFragment()
        }
    }

    override fun getCount(): Int {
        return TABS.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TABS.get(position)
    }
}