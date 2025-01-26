package br.edu.ifsp.dmo.pesquisa.data.model.dao

import android.content.ContentValues
import android.content.Context
import br.edu.ifsp.dmo.pesquisa.data.model.database.Contract
import br.edu.ifsp.dmo.pesquisa.data.model.database.Manager
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Student

class StudentDAO(context: Context) {
    private val dbManager = Manager(context)

    fun insert(student: Student): Boolean {
        try {
            val values = ContentValues().apply {
                put(Contract.Student.COLUMN_ID, student.id)
                put(Contract.Student.COLUMN_FULL_NAME, student.fullName)
                put(Contract.Student.COLUMN_VOTED, student.voted)
            }

            val db = dbManager.writableDatabase
            return ! db?.insert(Contract.Student.TABLE_NAME, null, values)!!.equals(-1)
        }
        catch (e: Exception) {
            e.printStackTrace()
            return false
        }
    }

    fun getById(id: String): Student? {
        try {
            val columns = arrayOf(
                Contract.Student.COLUMN_ID,
                Contract.Student.COLUMN_FULL_NAME,
                Contract.Student.COLUMN_VOTED
            )

            val db = dbManager.readableDatabase
            val cursor = db.query(
                Contract.Student.TABLE_NAME,
                columns,
                "${Contract.Student.COLUMN_ID} = ?",
                arrayOf(id.toString()),
                null,
                null,
                null
            )

            var student: Student? = null

            while (cursor.moveToNext()) {
                student = Student(cursor.getString(0), cursor.getString(1), cursor.getInt(2) == 1)
            }

            cursor.close()
            return student
        }
        catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    fun update(student: Student): Boolean {
        val values = ContentValues().apply {
            put(Contract.Student.COLUMN_FULL_NAME, student.fullName)
            put(Contract.Student.COLUMN_VOTED, student.voted)
        }

        val db = dbManager.writableDatabase

        val rowsAffected = db.update(
            Contract.Student.TABLE_NAME,
            values,
            "student_id = ?",
            arrayOf(student.id)
        )

        db.close()

        return rowsAffected > 0
    }
}