package br.edu.ifsp.dmo.pesquisa.data.model.repository

import android.content.Context
import br.edu.ifsp.dmo.pesquisa.data.model.dao.StudentDAO
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Student

class StudentRepository(context: Context) {
    private val studentDAO = StudentDAO(context)

    fun getById(id: String): Student? {
        val formattedId = formatId(id)
        return studentDAO.getById(formattedId)
    }

    private fun formatId(id: String): String {
        return id.replace("\\s".toRegex(), "")
    }

    fun save(student: Student) {
        val registeredStudent = studentDAO.getById(student.id)

        if (registeredStudent == null) {
            studentDAO.insert(student)
        }
        else {
            if (registeredStudent.voted) {
                throw Exception("Este prontuário já foi utilizado para votar.")
            }

            studentDAO.update(student)
        }
    }

    fun setVoted(student: Student?) {
        if (student != null) {
            student.voted = true
            studentDAO.update(student)
        }
        else {
            throw Exception("Estudante não encontrado.")
        }
    }
}