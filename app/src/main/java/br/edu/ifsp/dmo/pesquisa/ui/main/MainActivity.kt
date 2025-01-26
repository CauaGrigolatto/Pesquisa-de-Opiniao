package br.edu.ifsp.dmo.pesquisa.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.pesquisa.databinding.ActivityMainBinding
import br.edu.ifsp.dmo.pesquisa.ui.codeChecker.CodeCheckerActivity
import br.edu.ifsp.dmo.pesquisa.ui.codeChecker.CodeCheckerViewModel
import br.edu.ifsp.dmo.pesquisa.ui.registration.RegistrationActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.buttonStartSurvey.setOnClickListener{openRegistrationScreen()}
        binding.buttonCheckVote.setOnClickListener{openVoteCheckerScreen()}
    }

    private fun openRegistrationScreen() {
        val intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun openVoteCheckerScreen() {
        val intent = Intent(this, CodeCheckerActivity::class.java)
        startActivity(intent)
    }
}