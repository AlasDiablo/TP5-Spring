package fr.alasdiablo.tp4spring.repository

import fr.alasdiablo.tp4spring.model.Student
import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student, Int> {
    fun findByPrenom(name: String): Iterable<Student>
}