package com.app.filesystemmonitoring.service

import com.app.filesystemmonitoring.config.MyFileChangeListener
import org.springframework.stereotype.Service

@Service
class FileWatcherService(
    val myFileChangeListener: MyFileChangeListener
) {

    fun getListOfChangedFile(): List<String> {
        return myFileChangeListener.getListOfChangedFile()
    }

}