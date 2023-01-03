package fr.alasdiablo.tp4spring.controller

import fr.alasdiablo.tp4spring.model.Student
import fr.alasdiablo.tp4spring.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class StudentController {

    @Autowired
    private val database: StudentRepository? = null

    @Value("\${me}")
    private val me: String? = null

    @GetMapping(value = ["/moi"])
    fun moi(): String? {
        return me
    }

    @GetMapping(value = ["/"])
    fun getStutends(): Iterable<Student> {
        return this.database!!.findAll()
    }

    @GetMapping(value = ["/{id}"])
    fun getStudent(@PathVariable id: Int): Optional<Student> {
        return this.database!!.findById(id)
    }

    @PostMapping(value = ["/"], consumes = ["text/plain", "application/*"])
    fun addStudent(@RequestBody student: Student) {
        println(student)
        this.database!!.save(student)
    }

    @DeleteMapping(value = ["/{id}"], consumes = ["text/plain", "application/*"])
    fun deleteStudent(@PathVariable id: Int) {
        this.database!!.deleteById(id)
    }
}