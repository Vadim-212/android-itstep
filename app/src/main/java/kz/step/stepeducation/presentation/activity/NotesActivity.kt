package kz.step.stepeducation.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_notes2.*
import kotlinx.android.synthetic.main.fragment_notes.*
import kz.step.stepeducation.R
import kz.step.stepeducation.presentation.fragments.CreateNoteFragment
import kz.step.stepeducation.presentation.fragments.NotesFragment


class NotesActivity : AppCompatActivity() {
    var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes2)

        initializeDefaultFragment()
        initializeListeners()
    }

    fun initializeDefaultFragment() {
        if(currentFragment == null){
            currentFragment = NotesFragment()
            displayFragment(currentFragment!!)
        }
    }

    fun displayFragment(fragment: Fragment) {
        this.currentFragment = fragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        supportFragmentManager.executePendingTransactions()
        fragmentTransaction.add(
            R.id.relativelayout_activity_notes_fragment_container,
            fragment,
            fragment.javaClass.name)

        fragmentTransaction.addToBackStack("Name")
        fragmentTransaction.commit()
    }

    fun initializeListeners() {
        floating_action_button_activity_notes?.setOnClickListener {
            val fragment = CreateNoteFragment()
            this.currentFragment = fragment
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            supportFragmentManager.executePendingTransactions()
            fragmentTransaction.replace(R.id.relativelayout_activity_notes_fragment_container, fragment)
            fragmentTransaction.addToBackStack("Name")
            fragmentTransaction.commit()

        }
    }
}