package com.example.onbid.data

import android.app.ProgressDialog
import android.content.ContentProvider
import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.contentValuesOf
import androidx.room.Room

class InsertAsyncTask(
    a: ArrayList<RoomData>,
    context: Context?
) : AsyncTask<RoomData, Void, Void>() {
    val database = Room.databaseBuilder(context!!, AppDataBase::class.java, "jundb")
        .allowMainThreadQueries()
        .build()
    val dialog = ProgressDialog(context)
    override fun doInBackground(vararg params: RoomData?): Void? {
        database.userDao().insertCamcoDao(params)

        return null

    }

    override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
        dialog.show()

    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)



    }
}