package com.app.filesystemmonitoring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FileSystemMonitoringApplication

fun main(args: Array<String>) {
	runApplication<FileSystemMonitoringApplication>(*args)
}
