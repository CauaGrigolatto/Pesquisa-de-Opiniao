package br.edu.ifsp.dmo.pesquisa.ui.result

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.dmo.pesquisa.R
import br.edu.ifsp.dmo.pesquisa.databinding.ActivityResultBinding
import br.edu.ifsp.dmo.pesquisa.ui.utils.ActivityUtils

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
        binding.textViewGreatVotes.text = viewModel.getGreatVotes().toString()
        binding.textViewGoodVotes.text = viewModel.getGoodVotes().toString()
        binding.textViewRegularVotes.text = viewModel.getRegularVotes().toString()
        binding.textViewBadVotes.text = viewModel.getBadVotes().toString()
    }
}