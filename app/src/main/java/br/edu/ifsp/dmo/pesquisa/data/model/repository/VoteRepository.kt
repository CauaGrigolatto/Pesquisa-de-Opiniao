package br.edu.ifsp.dmo.pesquisa.data.model.repository

import android.content.Context
import br.edu.ifsp.dmo.pesquisa.data.model.dao.VoteDAO
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Vote
import java.util.UUID

class VoteRepository(context: Context) {
    private val voteDAO = VoteDAO(context)

    fun insert(value: String): Vote {
        try {
            val vote = Vote(UUID.randomUUID(), value)
            voteDAO.insert(vote)
            return vote
        }
        catch(e: Exception) {
            throw e
        }
    }

    fun countValuesOf(value: String) = voteDAO.countValuesOf(value)

    fun countAll() = voteDAO.countAll()

    fun getByCode(code: String): Vote? {
        try {
            return voteDAO.getByCode(UUID.fromString(code))
        }
        catch(e: Exception) {
            throw e
        }
    }

    fun getByCode(code: UUID): Vote? {
        try {
            return voteDAO.getByCode(code)
        }
        catch(e: Exception) {
            throw e
        }
    }
}