package kz.step.stepeducation.presentation.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_viewpager.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Student
import kz.step.stepeducation.presentation.adapter.ViewPagerStudentsAdapter
import kz.step.stepeducation.presentation.utils.Constants

class ViewPagerFragment : Fragment(), View.OnClickListener {
    var rootView: View? = null
    val students: ArrayList<Student> = ArrayList()
    var newPosition: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null) {
            //viewpager_fragment_viewpager?.setCurrentItem(arguments?.getInt("Position")!!, true)
            newPosition = arguments?.getInt("Position")
            //Toast.makeText(context, "agrs ${arguments?.getInt("Position")!!}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_viewpager, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeStudentsData()
        initializeViewPagerAdapter()
//        initializeListeners()
        if(newPosition != null) {
            viewpager_fragment_viewpager?.setCurrentItem(newPosition!!, true)
        }
    }

    fun initializeStudentsData() {
        students.add(Student("Alex", "Good Student","Group 2",12F, BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))))
        students.add(Student("Roland", "Bad Student", "Group 1",11F, BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))))
        students.add(Student("Force", "Average Student","Group 2",10.5F, BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))))
    }

    fun initializeViewPagerAdapter() {
        viewpager_fragment_viewpager?.adapter = ViewPagerStudentsAdapter(activity?.supportFragmentManager!!, students)
    }

//    fun initializeListeners() {
//        button_fragment_viewpager_next_student?.setOnClickListener(this)
//    }

    override fun onClick(v: View?) {
        //when(v?.id) {
//            R.id.button_fragment_viewpager_next_student -> {
//                //viewpager_fragment_viewpager?.adapter?.
//            }
        //}
    }

}