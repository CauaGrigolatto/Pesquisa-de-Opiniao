package br.edu.ifsp.dmo.pesquisa.ui.codeChecker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Vote
import br.edu.ifsp.dmo.pesquisa.data.model.repository.VoteRepository
import java.util.UUID

class CodeCheckerViewModel(application: Application) : AndroidViewModel(application) {
    private val voteRepository= VoteRepository(application)

    fun getVoteByCode(code: String): Vote? {
        try {
            return voteRepository.getByCode(code)
        }
        catch (e: Exception) {
            throw Exception("Código inválido.")
        }
    }

    fun getVoteByCode(code: UUID): Vote? {
        try {
            return voteRepository.getByCode(code)
        }
        catch (e: Exception) {
            throw Exception("Código inválido.")
        }
    }
}