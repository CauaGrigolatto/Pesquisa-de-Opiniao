package br.edu.ifsp.dmo.pesquisa.ui.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Student
import br.edu.ifsp.dmo.pesquisa.data.model.repository.StudentRepository

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
    private val studentRepository = StudentRepository(application)

    fun registerStudent(student: Student) {
        try {
            studentRepository.save(student)
        }
        catch(e: Exception) {
            throw e
        }
    }
}