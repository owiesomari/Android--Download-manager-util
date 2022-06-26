package com.example.downloadmanagerutil

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var downloadBtn: Button
    private lateinit var downloadManager: DownloadManagerUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        downloadBtn = findViewById(R.id.button)
        downloadManager = DownloadManagerUtil.newInstance(this, "Demo PDF")
        downloadBtn.setOnClickListener { downloadManager.downloadPdfFile("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf") }
    }
}