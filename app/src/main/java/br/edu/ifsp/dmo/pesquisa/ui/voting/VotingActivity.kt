package br.edu.ifsp.dmo.pesquisa.ui.voting

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.pesquisa.databinding.ActivityVotingBinding
import br.edu.ifsp.dmo.pesquisa.ui.codeDisplay.CodeDisplay
import br.edu.ifsp.dmo.pesquisa.ui.main.MainActivity
import br.edu.ifsp.dmo.pesquisa.ui.utils.ActivityUtils
import java.util.UUID

class VotingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVotingBinding
    private val viewModel: VotingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVotingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.buttonVote.setOnClickListener{handleVote()}
        binding.buttonCancel.setOnClickListener{openHomeScreen()}
    }

    private fun handleVote() {
        try {
            val id = getStudentId()
            val value = getVoteValue()

            viewModel.setVoted(id)
            val voteCode = viewModel.registerVote(value)

            ActivityUtils.shortToast(this,"Voto realizado com sucesso!")
            openCodeDisplayScreen(voteCode)
        }
        catch(e: Exception) {
            ActivityUtils.shortToast(this, e.message.toString())
        }
    }

    private fun getVoteValue(): String {
        val selectedId = binding.radioGroup.checkedRadioButtonId

        if (selectedId == -1) {
            throw Exception("Por favor, selecione um valor.")
        }

        val selectedRadioButton = binding.root.findViewById<RadioButton>(selectedId)
        return selectedRadioButton.text.toString()
    }

    private fun getStudentId(): String {
        val id = intent.extras?.getString("studentId") as String
        return id ?: throw Exception("Desculpe, não conseguimos identificar seu prontuário. Tente novamente.")
    }

    private fun openCodeDisplayScreen(code: UUID) {
        val intent = Intent(this, CodeDisplay::class.java)
        intent.putExtra("code", code)
        startActivity(intent)
        finish()
    }

    private fun openHomeScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}