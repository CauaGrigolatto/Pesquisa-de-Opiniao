package br.edu.ifsp.dmo.pesquisa.ui.codeChecker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.dao.VoteDAO
import java.util.UUID

class CodeCheckerViewModel(application: Application) : AndroidViewModel(application) {
    private val voteDAO = VoteDAO(application)

    fun getVote(code: String) = voteDAO.getById(UUID.fromString(code))

    fun getVote(code: UUID) = voteDAO.getById(code)
}