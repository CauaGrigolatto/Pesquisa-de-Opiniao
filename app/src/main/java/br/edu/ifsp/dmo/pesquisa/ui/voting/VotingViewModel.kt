package br.edu.ifsp.dmo.pesquisa.ui.voting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.repository.StudentRepository
import br.edu.ifsp.dmo.pesquisa.data.model.repository.VoteRepository
import java.util.UUID

class VotingViewModel(application: Application) : AndroidViewModel(application) {
    private val studentRepository = StudentRepository(application)
    private val voteRepository = VoteRepository(application)

    fun registerVote(value: String): UUID {
        try {
            val vote = voteRepository.insert(value)

            if (vote.id == null) throw Exception()

            return vote.id!!
        }
        catch(e: Exception) {
            throw Exception("Erro ao registrar voto. Por favor, tente novamente mais tarde.")
        }
    }

    fun setVoted(id: String) {
        try {
            val student = studentRepository.getById(id)
            studentRepository.setVoted(student)
        }
        catch (e: Exception) {
            throw e
        }
    }
}