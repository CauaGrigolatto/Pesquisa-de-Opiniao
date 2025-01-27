package br.edu.ifsp.dmo.pesquisa.data.model.repository

import android.content.Context
import br.edu.ifsp.dmo.pesquisa.data.model.dao.StudentDAO
import br.edu.ifsp.dmo.pesquisa.data.model.entity.Student

class StudentRepository(context: Context) {
    private val studentDAO = StudentDAO(context)

    fun getById(id: String) = studentDAO.getById(id)

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