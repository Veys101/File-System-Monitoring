package com.app.filesystemmonitoring.config

import org.springframework.boot.devtools.filewatch.FileSystemWatcher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File
import java.time.Duration
import javax.annotation.PreDestroy

@Configuration
class FileWatcherConfig {

    @Bean
    fun fileSystemWatcher(): FileSystemWatcher {
        val fileSystemWatcher = FileSystemWatcher(true, Duration.ofMillis(5000L), Duration.ofMillis(3000L))
        fileSystemWatcher.addSourceDirectory(File("C:\\Users\\voz\\Desktop\\Directory"))
        fileSystemWatcher.addListener(MyFileChangeListener())
        fileSystemWatcher.start()
        println("started fileSystemWatcher")
        return fileSystemWatcher
    }

    @PreDestroy
    @Throws(Exception::class)
    fun onDestroy() {
        fileSystemWatcher().stop()
    }
}