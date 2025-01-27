package br.edu.ifsp.dmo.pesquisa.ui.result

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.repository.VoteRepository

class ResultViewModel(application: Application) : AndroidViewModel(application) {
    private val voteRepository = VoteRepository(application)

    fun getCountAll() = voteRepository.countAll()
    fun getCountGreatVotes() = voteRepository.countValuesOf("Ótimo")
    fun getCountGoodVotes() = voteRepository.countValuesOf("Bom")
    fun getCountRegularVotes() = voteRepository.countValuesOf("Regular")
    fun getCountBadVotes() = voteRepository.countValuesOf("Ruim")
}