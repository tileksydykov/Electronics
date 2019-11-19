package com.example.electronics.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import me.dm7.barcodescanner.zxing.ZXingScannerView
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.Result


class QrCodeScanner : AppCompatActivity(), ZXingScannerView.ResultHandler {
    private var mScannerView: ZXingScannerView? = null

    public override fun onCreate(state: Bundle?) {
        super.onCreate(state)

        mScannerView = ZXingScannerView(this)

        setContentView(mScannerView)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA), 1)
        }
    }

    public override fun onResume() {
        super.onResume()

        mScannerView!!.setResultHandler(this)

        mScannerView!!.startCamera()
    }

    public override fun onPause() {
        super.onPause()

        mScannerView!!.stopCamera()
    }

    override fun handleResult(rawResult: Result) {

        Log.d("electrek", rawResult.text)

        Log.d("electrek", rawResult.barcodeFormat.toString())

        val intent = Intent()

        intent.putExtra("text", rawResult.text)

        setResult(1, intent)

        finish()
    }
}