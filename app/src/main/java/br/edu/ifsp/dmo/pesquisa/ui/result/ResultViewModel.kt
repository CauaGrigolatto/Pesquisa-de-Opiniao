package br.edu.ifsp.dmo.pesquisa.ui.result

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.dao.VoteDAO

class ResultViewModel(application: Application) : AndroidViewModel(application) {
    private val voteDAO = VoteDAO(application)

    fun getCountAll() = voteDAO.countAll()
    fun getCountGreatVotes() = voteDAO.countValuesOf("Ótimo")
    fun getCountGoodVotes() = voteDAO.countValuesOf("Bom")
    fun getCountRegularVotes() = voteDAO.countValuesOf("Regular")
    fun getCountBadVotes() = voteDAO.countValuesOf("Ruim")
}