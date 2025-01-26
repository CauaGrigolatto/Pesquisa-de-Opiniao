package br.edu.ifsp.dmo.pesquisa.ui.codeChecker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.dao.VoteDAO
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Vote
import java.util.UUID

class CodeCheckerViewModel(application: Application) : AndroidViewModel(application) {
    private val voteDAO = VoteDAO(application)

    fun getVote(code: String): Vote? {
        try {
            return voteDAO.getById(UUID.fromString(code))
        }
        catch(e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    fun getVote(code: UUID): Vote? {
        try {
            return voteDAO.getById(code)
        }
        catch(e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}