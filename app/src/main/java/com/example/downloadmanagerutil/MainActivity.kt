package com.example.downloadmanagerutil

import android.Manifest
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var permissionUtils: PermissionsUtil

    private lateinit var downloadBtn: Button
    private lateinit var downloadManager: DownloadManagerUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        permissionUtils = PermissionsUtil.getInstance(this, this.activityResultRegistry)
        lifecycle.addObserver(permissionUtils)
        downloadBtn = findViewById(R.id.button)
        downloadManager = DownloadManagerUtil.newInstance(this, "Demo PDF")
        downloadBtn.setOnClickListener {
            permissionUtils.requestPermission(
                arrayOf(Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                object : PermissionsUtil.PermissionsListenerCallback {
                    override fun onPermissionGranted() {
                        downloadManager.downloadPdfFile("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf")
                    }

                    override fun onPermissionDialogCancel() {}
                })
        }
    }
}