package br.edu.ifsp.dmo.pesquisa.ui.voting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.dao.StudentDAO
import br.edu.ifsp.dmo.pesquisa.data.model.dao.VoteDAO
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Vote
import java.util.UUID

class VotingViewModel(application: Application) : AndroidViewModel(application) {
    private val studentDAO = StudentDAO(application)
    private val voteDAO = VoteDAO(application)

    fun registerVote(value: String): UUID {
        val vote = Vote(UUID.randomUUID(), value)
        voteDAO.insert(vote)
        return vote.id
    }

    fun setVoted(id: String) {
        val student = studentDAO.getById(id)

        if (student != null) {
            student.voted = true
            studentDAO.update(student)
        }
        else {
            throw Exception("Erro ao registrar voto. Por favor, insira seus dados e tente novamente.")
        }
    }
}