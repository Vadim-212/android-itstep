package kz.step.stepeducation.presentation.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.fragment_viewpager.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.StepEducationDatabase
import kz.step.stepeducation.domain.Student
import kz.step.stepeducation.presentation.adapter.ViewPagerStudentsAdapter

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

        var stepEducationDatabase = Room.databaseBuilder(
            context!!,
            StepEducationDatabase::class.java,
            "StepEducationDatabase").allowMainThreadQueries()
            .fallbackToDestructiveMigration() // TODO: потеря данных в базе данных, при использовании fallbackToDestructiveMigration()
            .build()

        stepEducationDatabase.getStudentsGroupDao().initiateInsertGroup(kz.step.stepeducation.data.StudentsGroup().apply {
            title = "Group A"
        })
        stepEducationDatabase.getStudentDao().initiateInsertStudent(kz.step.stepeducation.data.Student().apply {
            name = "John"
        })


        stepEducationDatabase.getStudentDao().initiateInsertStudentsList(listOf(kz.step.stepeducation.data.Student().apply {
            name = "Roland"
        }, kz.step.stepeducation.data.Student().apply {
            name = "Mike"
        }))
        stepEducationDatabase.getStudentsGroupDao().initiateInsertGroupsList(listOf(kz.step.stepeducation.data.StudentsGroup().apply {
            title = "Group B"
        }, kz.step.stepeducation.data.StudentsGroup().apply {
            title = "Group C"
        }))

        Log.d("ROOM_TEST", stepEducationDatabase.getStudentDao().initiateGetStudents().joinToString { it.toString() })
        Log.d("ROOM_TEST", stepEducationDatabase.getStudentsGroupDao().initiateGetGroups().joinToString { it.toString() })

        Log.d("ROOM_TEST", stepEducationDatabase.getStudentDao().initiateGetStudentById(8).toString())
        Log.d("ROOM_TEST", stepEducationDatabase.getStudentsGroupDao().initiateGetGroupById(9).toString())

        stepEducationDatabase.getStudentDao().initiateDeleteStudentById(1)
        stepEducationDatabase.getStudentsGroupDao().initiateDeleteGroupById(1)

        stepEducationDatabase.getStudentDao().initiateDeleteStudents()
        stepEducationDatabase.getStudentsGroupDao().initiateDeleteGroups()

//        stepEducationDatabase.getStudentDao().initiateInsertStudent(kz.step.stepeducation.data.Student().apply {
//            name = "John"
//        })
//        stepEducationDatabase.getStudentDao().initiateInsertStudent(kz.step.stepeducation.data.Student().apply {
//            name = "Alex"
//        })
//        stepEducationDatabase.getStudentDao().initiateInsertStudent(kz.step.stepeducation.data.Student().apply {
//            name = "Jack"
//        })

        var list = stepEducationDatabase.getStudentDao().initiateGetStudents()

        if(newPosition != null) {
            viewpager_fragment_viewpager?.setCurrentItem(newPosition!!, true)
        }
    }

    fun initializeStudentsData() {
        students.add(
            Student(
                "Alex",
                "Good Student",
                "Group 2",
                12F,
                BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))
            )
        )
        students.add(
            Student(
                "Roland",
                "Bad Student",
                "Group 1",
                11F,
                BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))
            )
        )
        students.add(
            Student(
                "Force",
                "Average Student",
                "Group 2",
                10.5F,
                BitmapFactory.decodeStream(context?.assets?.open("camera_stub_image.png"))
            )
        )
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