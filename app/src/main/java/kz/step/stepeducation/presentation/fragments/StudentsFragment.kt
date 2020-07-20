package kz.step.stepeducation.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_students.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Currency
import kz.step.stepeducation.data.GroupWithStudents
import kz.step.stepeducation.data.StudentsGroup
import kz.step.stepeducation.data.api.APIConnection
import kz.step.stepeducation.di.component.DaggerRepositoryComponent
import kz.step.stepeducation.di.module.RepositoryModule
import kz.step.stepeducation.presentation.adapter.StudentsAdapter
import kz.step.stepeducation.domain.Student
import kz.step.stepeducation.domain.StudentsSortUseCase
import kz.step.stepeducation.presentation.adapter.GroupWithStudentsAdapter
import kz.step.stepeducation.presentation.contract.StudentsFragmentContract
import kz.step.stepeducation.presentation.presenters.StudentsFragmentPresenter
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class StudentsFragment : Fragment(), StudentsFragmentContract.View, View.OnClickListener {
    var rootView: View? = null
    var students: ArrayList<Student> = ArrayList()
    var filteredStudentsList: ArrayList<Student> = ArrayList()
    var studentsAdapter: StudentsAdapter? = null
    lateinit var presenter: StudentsFragmentPresenter
    var studentToAdd: Student? = null
    var groups: ArrayList<GroupWithStudents> = ArrayList()
    var groupsAdapter: GroupWithStudentsAdapter? = null

    @Inject lateinit var studentsSortUseCase: StudentsSortUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.fragment_students,
            container,
            false)

        if(arguments != null) {
            if(arguments!!.getParcelable<Student>("student") != null) {
                studentToAdd = arguments!!.getParcelable<Student>("student")
            }
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        studentsSortUseCase = DaggerUseCaseComponent
//            .builder()
//            .useCaseModule(UseCaseModule())
//            .build()
//            .initiateReturnStudentsUseCase()

//        DaggerUseCaseComponent
//            .builder()
//            .useCaseModule(UseCaseModule())
//            .build()
//            .inject(this)

        DaggerRepositoryComponent.builder().repositoryModule(RepositoryModule(this)).build().inject(this)

//        val call = APIConnection().initializeAPI()?.currencies()
//        call?.enqueue(object : retrofit2.Callback<Currency>{
//            override fun onFailure(call: Call<Currency>, t: Throwable) {
//                Log.d("RETROFIT_FAILURE", t.message)
//            }
//
//            override fun onResponse(call: Call<Currency>, response: Response<Currency>) {
//                if(response.isSuccessful) {
//                    Log.d("RETROFIT_SUCCESS", response.body().toString())
//                } else {
//                    Log.d("RETROFIT_FAILURE", response.errorBody().toString())
//                }
//            }
//        })

        initializeViews()
        initializePresenter()
        initializeLayoutManager()
        presenter.initiazeDataRoomGroupWithStudents()
        //initializeAdapter()
        initializeGroupsAdapter()
        initializeListeners()
        //presenter.initializeData()


        if(studentToAdd != null) {
            presenter.initiateAddStudent(studentToAdd!!)
        }
    }

    override fun initializePresenter() {
        presenter = StudentsFragmentPresenter(context!!)
        presenter.attach(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_fragment_students_filtration_by_name -> {
                presenter.initializeSortStudentsByName()
            }
            R.id.button_fragment_students_filtration_by_mark -> {
                presenter.initializeSortStudentsByMark()
            }
            R.id.button_fragment_students_random_filtration -> {
                presenter.initializeSortStudentsRandom()
            }
            R.id.button_fragment_students_clear_query -> {
                edittext_fragment_students_search_query?.setText("")
                presenter.initializeData()
            }
            R.id.button_fragment_students_top_three_by_mark -> {
                presenter.initiateTopThreeStudentsByMark()
            }
        }
    }

    override fun initializeListeners() {
        button_fragment_students_filtration_by_name?.setOnClickListener(this)

        button_fragment_students_filtration_by_mark?.setOnClickListener(this)

        button_fragment_students_random_filtration?.setOnClickListener(this)

        button_fragment_students_clear_query?.setOnClickListener(this)

        button_fragment_students_top_three_by_mark?.setOnClickListener(this)

        edittext_fragment_students_search_query?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                presenter.initiateSortStudentsByQuery(edittext_fragment_students_search_query?.text.toString())
//                filteredStudentsList.clear()
//                filteredStudentsList.addAll(students.filter { it.name.toLowerCase().contains(edittext_fragment_students_search_query?.text.toString().toLowerCase()) || it.name.toLowerCase() == edittext_fragment_students_search_query?.text.toString().toLowerCase() } as ArrayList<Student>)
//                studentsAdapter?.notifyDataSetChanged()
            }
        })
    }

    override fun initializeViews() {
        recyclerview_fragment_students?.visibility = View.VISIBLE


        button_fragment_students_filtration_by_name.visibility = View.INVISIBLE

        button_fragment_students_filtration_by_mark.visibility = View.INVISIBLE

        button_fragment_students_random_filtration.visibility = View.INVISIBLE

        button_fragment_students_clear_query.visibility = View.INVISIBLE

        button_fragment_students_top_three_by_mark.visibility = View.INVISIBLE

        edittext_fragment_students_search_query.visibility = View.INVISIBLE
    }

    override fun initializeLayoutManager() {
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter() {
        studentsAdapter = StudentsAdapter(context, students)
        recyclerview_fragment_students?.adapter = studentsAdapter
    }

    override fun initializeGroupsAdapter() {
        groupsAdapter = GroupWithStudentsAdapter(context, groups.toList(), this)
        recyclerview_fragment_students?.adapter = groupsAdapter
    }

    override fun initiateUpdateAdapter() {
        //studentsAdapter?.notifyDataSetChanged()
        groupsAdapter?.notifyDataSetChanged()
    }

    override fun processData(students: ArrayList<Student>) {
        this.students.clear()
        this.students.addAll(students)
    }

    override fun processDataGroups(groupWithStudents: List<GroupWithStudents>) {
        this.groups.clear()
        this.groups.addAll(groupWithStudents)
    }

    override fun initializeArguments() { }

    override fun initializeDependencies() { }

//    fun getTop3StudentsByMark(studentsList: ArrayList<Student>): ArrayList<Student> {
//        val top3StudentsByMark: ArrayList<Student> = ArrayList()
//        var topStudent: Student
//
//        for (i: Int in 0 until 3) {
//            topStudent = studentsList.first()
//            for (student in studentsList) {
//                if(student.mark > topStudent.mark) {
//                    topStudent = student
//                }
//            }
//            top3StudentsByMark.add(topStudent)
//            studentsList.remove(topStudent)
//        }
//
//        return top3StudentsByMark
//    }
}