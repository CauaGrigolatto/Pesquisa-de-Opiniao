package br.edu.ifsp.dmo.pesquisa.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.dmo.pesquisa.data.model.database.Contract
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Student
import br.edu.ifsp.dmo.pesquisa.databinding.ActivityRegistrationBinding
import br.edu.ifsp.dmo.pesquisa.ui.main.MainActivity
import br.edu.ifsp.dmo.pesquisa.ui.utils.ActivityUtils
import br.edu.ifsp.dmo.pesquisa.ui.voting.VotingActivity

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.buttonRegister.setOnClickListener{handleRegistration()}
        binding.buttonCancel.setOnClickListener{openHomeScreen()}
    }

    private fun handleRegistration() {
        val id = binding.editTextId.text.toString()
        val fullName = binding.editTextFullName.text.toString()
        val student = Student(id, fullName)

        try {
            viewModel.register(student)
            openVotingScreen(id)
        }
        catch(e: Exception) {
            ActivityUtils.shortToast(this, e.message.toString())
        }
    }

    private fun openVotingScreen(id: String) {
        val intent = Intent(this, VotingActivity::class.java)
        intent.putExtra("userId", id)
        startActivity(intent)
        finish()
    }

    private fun openHomeScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}