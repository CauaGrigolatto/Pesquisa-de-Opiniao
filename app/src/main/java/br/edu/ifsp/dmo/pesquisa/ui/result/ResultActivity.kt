package br.edu.ifsp.dmo.pesquisa.ui.result

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.pesquisa.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private val viewModel: ResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListeners()
        setVotesResult()
    }

    private fun setupClickListeners() {
        binding.buttonExit.setOnClickListener{finish()}
    }

    private fun setVotesResult() {
        binding.textViewGreatVotes.text = viewModel.getCountGreatVotes().toString()
        binding.textViewGoodVotes.text = viewModel.getCountGoodVotes().toString()
        binding.textViewRegularVotes.text = viewModel.getCountRegularVotes().toString()
        binding.textViewBadVotes.text = viewModel.getCountBadVotes().toString()
        binding.textViewTotalVotes.text = viewModel.getCountAll().toString()
    }
}