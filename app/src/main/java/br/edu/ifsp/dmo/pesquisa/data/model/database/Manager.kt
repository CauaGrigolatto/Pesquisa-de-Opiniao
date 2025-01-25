package br.edu.ifsp.dmo.pesquisa.data.model.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Manager(context: Context) :
    SQLiteOpenHelper(
        context,
        Contract.Database.DATABASE_NAME,
        null,
        Contract.Database.DATABASE_VERSION
    ) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(Contract.Student.SQL_CREATE)
        db.execSQL(Contract.Vote.SQL_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(Contract.Student.SQL_DROP)
        db.execSQL(Contract.Vote.SQL_DROP)
        onCreate(db)
    }
}