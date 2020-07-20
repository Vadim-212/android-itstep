package kz.step.stepeducation.presentation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kz.step.stepeducation.R
import kz.step.stepeducation.data.GroupWithStudents
import kz.step.stepeducation.presentation.fragments.StudentsFragment
import kz.step.stepeducation.presentation.viewholder.GroupWithStudentsHolder

class GroupWithStudentsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder> {
    var context: Context?
    var groupsWithStudents: List<GroupWithStudents>
    var fragment: StudentsFragment

    constructor(context: Context?, groupsWithStudents: List<GroupWithStudents>, fragment: StudentsFragment) {
        this.context = context
        this.groupsWithStudents = groupsWithStudents
        this.fragment = fragment
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.viewholder_students_group, parent, false)
        return GroupWithStudentsHolder(view)
    }

    override fun getItemCount(): Int {
        return groupsWithStudents.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            fragment.initializeAdapter()
            fragment.presenter.initiazeDataRoomStudents(groupsWithStudents.get(position).group.id)
        }

        (holder as GroupWithStudentsHolder).initiateBind(groupsWithStudents.get(position))
    }
}