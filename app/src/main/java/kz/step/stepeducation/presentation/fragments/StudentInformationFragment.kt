package kz.step.stepeducation.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_student_information.*
import kz.step.stepeducation.R
import kz.step.stepeducation.domain.Student
import kz.step.stepeducation.presentation.base.BaseFragment
import kz.step.stepeducation.presentation.utils.Constants

class StudentInformationFragment : BaseFragment() {
    var rootView: View? = null
    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null) {
            student = arguments?.getParcelable(Constants.STUDENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = LayoutInflater.from(context).inflate(
            R.layout.fragment_student_information,
            container,
            false)

        return rootView
    }

    override fun onClick(v: View?) { }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeData()
    }

    @SuppressLint("SetTextI18n")
    fun initializeData() {
        if(student?.avatar != null) {
            imageview_fragment_students_information_image?.setImageBitmap(student?.avatar)
        }
        textview_fragment_students_information_name?.setText(student?.name)
        textview_fragment_students_information_info?.setText("Group: ${student?.group}\nMark: ${student?.mark}\nDescription: ${student?.description}")
    }
}