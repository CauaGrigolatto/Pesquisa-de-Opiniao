package br.edu.ifsp.dmo.pesquisa.data.model.dao

import android.content.ContentValues
import android.content.Context
import br.edu.ifsp.dmo.pesquisa.data.model.database.Contract
import br.edu.ifsp.dmo.pesquisa.data.model.database.Manager
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Vote
import java.util.UUID

class VoteDAO(context: Context) {
    private val dbManager = Manager(context)

    fun insert(vote: Vote): Boolean {
        try {
            val values = ContentValues().apply {
                put(Contract.Vote.COLUMN_ID, vote.id.toString())
                put(Contract.Vote.COLUMN_VALUE, vote.value)
            }

            val db = dbManager.writableDatabase
            return ! db?.insert(Contract.Vote.TABLE_NAME, null, values)!!.equals(-1)
        }
        catch (e: Exception) {
            println("VoteDAO: erro ao inserir: $vote.")
            throw e
        }
    }

    fun getByCode(id: UUID): Vote? {
        try {
            val columns = arrayOf(
                Contract.Vote.COLUMN_ID,
                Contract.Vote.COLUMN_VALUE
            )

            val db = dbManager.readableDatabase
            val cursor = db.query(
                Contract.Vote.TABLE_NAME,
                columns,
                Contract.Vote.SQL_WHERE_ID_EQUALS,
                arrayOf(id.toString()),
                null,
                null,
                null
            )

            var vote: Vote? = null

            while (cursor.moveToNext()) {
                vote = Vote(UUID.fromString(cursor.getString(0)), cursor.getString(1))
            }

            cursor.close()
            return vote
        }
        catch (e: Exception) {
            println("VoteDAO: erro ao recuperar por ID: $id.")
            throw e
        }
    }

    fun countValuesOf(value: String): Int {
        try {
            val db = dbManager.readableDatabase
            val cursor = db.rawQuery(Contract.Vote.SQL_COUNT_VALUE, arrayOf(value))
            var count = 0

            if (cursor.moveToFirst()) {
                count = cursor.getInt(0)
            }

            cursor.close()
            return count
        }
        catch (e: Exception) {
            println("VoteDAO: erro ao contar por valor: $value.")
            throw e
        }
    }

    fun countAll(): Int {
        try {
            val db = dbManager.readableDatabase
            val cursor = db.rawQuery(Contract.Vote.SQL_COUNT, null)
            var count = 0

            if (cursor.moveToFirst()) {
                count = cursor.getInt(0)
            }

            cursor.close()
            return count
        }
        catch (e: Exception) {
            println("VoteDAO: erro ao contar todos.")
            throw e
        }
    }
}