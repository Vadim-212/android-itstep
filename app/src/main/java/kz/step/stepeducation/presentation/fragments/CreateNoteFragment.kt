package kz.step.stepeducation.presentation.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity.RESULT_OK
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_notes2.*
import kotlinx.android.synthetic.main.fragment_create_note.*
import kz.step.stepeducation.R
import kz.step.stepeducation.data.Note
import kz.step.stepeducation.presentation.base.BaseFragment
import java.time.LocalDate


class CreateNoteFragment : BaseFragment(), DatePickerDialog.OnDateSetListener {
    var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.fragment_create_note,
            container,
            false
        )
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListeners()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.edittext_fragment_create_note_due_date -> {
                val dialog = DatePickerDialog(
                    context!!,
                    this,
                    LocalDate.now().year,
                    LocalDate.now().month.value - 1,
                    LocalDate.now().dayOfMonth
                )
                dialog.show()
            }
            R.id.button_fragment_create_note_add -> {
                var bitmapImage: Bitmap? = null
                if (edittext_fragment_create_note_title?.text.isNullOrEmpty()) {
                    Toast.makeText(context, "Необходимо заполнить заголовок!", Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                if (edittext_fragment_create_note_due_date?.text.isNullOrEmpty()) {
                    Toast.makeText(context, "Необходимо заполнить дату!", Toast.LENGTH_SHORT).show()
                    return
                }
                if (edittext_fragment_create_note_text?.text.isNullOrEmpty()) {
                    Toast.makeText(context, "Необходимо заполнить текст!", Toast.LENGTH_SHORT)
                        .show()
                    return
                }

                if(imageview_fragment_create_note_photo?.drawable is BitmapDrawable) {
                    bitmapImage = (imageview_fragment_create_note_photo?.drawable as BitmapDrawable).bitmap
                }

                val note = Note(edittext_fragment_create_note_title?.text.toString(), edittext_fragment_create_note_text?.text.toString(),edittext_fragment_create_note_due_date?.text.toString(), bitmapImage)
                val fragment = NotesFragment()
                val args = Bundle()
                args.putSerializable("addedNote", note)
                fragment.arguments = args
                val activity = view!!.context as AppCompatActivity
                activity.supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.relativelayout_activity_notes_fragment_container,
                        fragment
                    ).addToBackStack("Name").commit()
            }

            R.id.imageview_fragment_create_note_photo -> {
                if (ActivityCompat.checkSelfPermission(context!!, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 2000)
                } else {
                    val cameraIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    cameraIntent.type = "image/*"
                    startActivityForResult(cameraIntent, 1000)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1000) {
                val returnUri: Uri? = data?.getData()
                val bitmapImage: Bitmap =
                    MediaStore.Images.Media.getBitmap(activity?.getContentResolver(), returnUri)
                imageview_fragment_create_note_photo?.setImageBitmap(bitmapImage)
            }
        }
    }

    fun initializeListeners() {
        edittext_fragment_create_note_due_date?.setOnClickListener(this)
        button_fragment_create_note_add?.setOnClickListener(this)
        imageview_fragment_create_note_photo?.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        edittext_fragment_create_note_due_date?.setText("$year-${(if (monthOfYear + 1 < 10) "0${monthOfYear + 1}" else (monthOfYear + 1))}-${(if (dayOfMonth < 10) "0$dayOfMonth" else dayOfMonth)}")
    }
}