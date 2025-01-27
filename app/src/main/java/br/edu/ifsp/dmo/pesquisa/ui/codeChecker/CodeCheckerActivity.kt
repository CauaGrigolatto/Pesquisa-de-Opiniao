package br.edu.ifsp.dmo.pesquisa.ui.codeChecker

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Vote
import br.edu.ifsp.dmo.pesquisa.databinding.ActivityCodeCheckerBinding
import br.edu.ifsp.dmo.pesquisa.ui.utils.ActivityUtils

class CodeCheckerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCodeCheckerBinding
    private val viewModel: CodeCheckerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodeCheckerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.buttonSearch.setOnClickListener{handleSearch()}
        binding.buttonCancel.setOnClickListener{finish()}
    }

    private fun handleSearch() {
        try {
            val code = binding.editTextCode.text.toString()
            val vote = viewModel.getVoteByCode(code)
            displayVoteValue(vote)
        }
        catch(e: Exception) {
            ActivityUtils.shortToast(this, e.message.toString())
        }
    }

    private fun displayVoteValue(vote: Vote?) {
        if (vote != null) {
            setVoteValue("Votou '${vote.value}'.")
        }
        else {
            setVoteValue("Não encontrado.")
        }
    }

    private fun setVoteValue(value: String) {
        binding.textViewVoteValue.text = value
    }
}