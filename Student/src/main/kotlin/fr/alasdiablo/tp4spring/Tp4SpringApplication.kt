package fr.alasdiablo.tp4spring

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.jdbc.core.JdbcTemplate

@EnableDiscoveryClient
@SpringBootApplication
class Tp4SpringApplication {

    @Autowired
    private val jdbcTemplate: JdbcTemplate? = null

    @PostConstruct
    private fun initDB() {
        val sqls = listOf(
            "drop table student if exists",
            "create table if not exists student(ID int primary key auto_increment,NOM varchar(255), PRENOM varchar(255), DIPLOME varchar(255));",
            "insert into student (NOM, PRENOM, DIPLOME) values ('Marcolet', 'Pierre', 'Master Infomatique')"
        )

        sqls.forEach { sql -> jdbcTemplate?.execute(sql) }

    }
}

fun main(args: Array<String>) {
    runApplication<Tp4SpringApplication>(*args)
}
