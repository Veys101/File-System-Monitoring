package com.app.filesystemmonitoring.controller

import com.app.filesystemmonitoring.service.FileWatcherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/file-watcher")
class FileWatcherController(
    val fileWatcherService: FileWatcherService
) {

    @GetMapping
    fun getListOfChangedFiles() {
        fileWatcherService.getListOfChangedFile()
    }
}