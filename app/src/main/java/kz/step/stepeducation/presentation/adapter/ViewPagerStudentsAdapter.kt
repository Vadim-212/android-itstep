package kz.step.stepeducation.presentation.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kz.step.stepeducation.data.Student
import kz.step.stepeducation.presentation.fragments.StudentInformationFragment
import kz.step.stepeducation.presentation.utils.Constants

class ViewPagerStudentsAdapter(fragmentManager: FragmentManager, var students: ArrayList<Student>): FragmentStatePagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {
        return StudentInformationFragment().apply {
            arguments = Bundle().apply {
                putParcelable(Constants.STUDENT, students.get(position))
            }
        }
    }

    override fun getCount(): Int {
        return students.size
    }
}