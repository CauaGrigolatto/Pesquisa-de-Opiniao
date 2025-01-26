package br.edu.ifsp.dmo.pesquisa.ui.result

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.dao.VoteDAO

class ResultViewModel(application: Application) : AndroidViewModel(application) {
    private val voteDAO = VoteDAO(application)

    fun getGreatVotes() = voteDAO.countValuesOf("Ótimo")
    fun getGoodVotes() = voteDAO.countValuesOf("Bom")
    fun getRegularVotes() = voteDAO.countValuesOf("Regular")
    fun getBadVotes() = voteDAO.countValuesOf("Ruim")
}