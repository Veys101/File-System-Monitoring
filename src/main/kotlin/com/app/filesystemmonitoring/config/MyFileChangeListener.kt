package com.app.filesystemmonitoring.config

import org.springframework.boot.devtools.filewatch.ChangedFile
import org.springframework.boot.devtools.filewatch.ChangedFiles
import org.springframework.boot.devtools.filewatch.FileChangeListener
import org.springframework.stereotype.Component
import java.io.IOException
import java.nio.channels.FileChannel
import java.nio.file.Path
import java.nio.file.StandardOpenOption

@Component
class MyFileChangeListener() : FileChangeListener {

    private val changeList = mutableListOf<String>()

    override fun onChange(changeSet: Set<ChangedFiles>) {
        for (cfiles: ChangedFiles in changeSet) {
            for (cfile: ChangedFile in cfiles.files) {
                if ( /* (cfile.getType().equals(Type.MODIFY)
                     || cfile.getType().equals(Type.ADD)
                     || cfile.getType().equals(Type.DELETE) ) && */!isLocked(cfile.file.toPath())) {
                    changeList.add("Operation: " + cfile.type + " On file: " + cfile.file.name + " is done")
                    println(
                        "Operation: " + cfile.type
                                + " On file: " + cfile.file.name + " is done"
                    )
                }
            }
        }
    }

    fun getListOfChangedFile(): List<String> {
        return changeList
    }

    private fun isLocked(path: Path): Boolean {
        try {
            FileChannel.open(path, StandardOpenOption.WRITE).use { ch ->
                ch.tryLock().use { lock -> return lock == null }
            }
        } catch (e: IOException) {
            return true
        }
    }
}