package br.edu.ifsp.dmo.pesquisa.ui.codeDisplay

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.pesquisa.databinding.ActivityCodeDisplayBinding
import br.edu.ifsp.dmo.pesquisa.ui.main.MainActivity

class CodeDisplay : AppCompatActivity() {
    private lateinit var binding: ActivityCodeDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodeDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewCode()
        setupClickListeners()
    }

    private fun setViewCode() {
        val code = getCode()
        binding.textViewCode.text = code
    }

    private fun setupClickListeners() {
        binding.buttonFinalize.setOnClickListener{openHomeScreen()}
        binding.imageViewCopy.setOnClickListener{copyCode()}
    }

    private fun copyCode() {
        val clipboard = this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val code = getCode()
        val clip = ClipData.newPlainText("copied_code", code)
        clipboard.setPrimaryClip(clip)
    }

    private fun getCode() = intent.extras?.getSerializable("code").toString()

    private fun openHomeScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}