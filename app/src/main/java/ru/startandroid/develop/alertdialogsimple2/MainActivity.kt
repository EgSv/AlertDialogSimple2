package ru.startandroid.develop.alertdialogsimple2

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.coroutines.NonCancellable.cancel
import java.lang.System.exit

class MainActivity : AppCompatActivity() {

    val DIALOG_EXIT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(v: View?) {
        showDialog(DIALOG_EXIT)
    }

    override fun onCreateDialog(id: Int): Dialog {
        if (id == DIALOG_EXIT) {
            val adb: AlertDialog.Builder = AlertDialog.Builder(this)
            adb.setTitle(R.string.exit)
            adb.setMessage(R.string.save_data)
            adb.setIcon(android.R.drawable.ic_dialog_info)
            adb.setPositiveButton(R.string.yes, myClickListener)
            adb.setNegativeButton(R.string.no, myClickListener)
            adb.setNeutralButton(R.string.cancel, myClickListener)
            adb.setCancelable(false)
            return adb.create()
        }
        return super.onCreateDialog(id)
    }

    var myClickListener: DialogInterface.OnClickListener = object :
        DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface?, which: Int) {
            when(which) {
                Dialog.BUTTON_POSITIVE -> {
                    saveData()
                    finish()
                }
                Dialog.BUTTON_NEGATIVE -> {
                    finish()
                }
                Dialog.BUTTON_NEUTRAL -> {}
            }
        }
    }
    fun saveData() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
    }
    override fun onBackPressed() {
        showDialog(DIALOG_EXIT)
    }
}