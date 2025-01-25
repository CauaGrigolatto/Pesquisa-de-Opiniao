package br.edu.ifsp.dmo.pesquisa.ui.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.edu.ifsp.dmo.pesquisa.data.model.dao.StudentDAO
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Student

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {
    private val studentDAO = StudentDAO(application)

    fun register(student: Student) {
        val registeredStudent = studentDAO.getById(student.id)

        if (registeredStudent == null) {
            studentDAO.insert(student)
        }
        else if (student.voted) {
            throw Exception("${student.fullName} já votou")
        }
    }
}