package com.natasaandzic.retrofit.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class ImageDownloader : AsyncTask<String, Void, Bitmap>() {

    override fun doInBackground(vararg urls: String?): Bitmap? {
        try {
            val url = URL(urls[0])
            val connection =  url.openConnection() as HttpURLConnection
            connection.connect()
            val inputStream = connection.inputStream

            val myBitmap = BitmapFactory.decodeStream(inputStream)
            return myBitmap
        }
        catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}