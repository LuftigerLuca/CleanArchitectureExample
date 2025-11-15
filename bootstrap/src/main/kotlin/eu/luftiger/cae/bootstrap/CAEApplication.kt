package eu.luftiger.cae.bootstrap

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["eu.luftiger.cae.bootstrap", "eu.luftiger.cae.web"])
open class CAEApplication

fun main(args: Array<String>) {
    runApplication<CAEApplication>(*args)
}
