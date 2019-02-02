package com.example.app_to_stories

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_share.*
import java.io.FileNotFoundException

class ShareFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(activity!!, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_share, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shareBtn.setOnClickListener { shareContent() }
    }

    private fun shareContent() {
        Log.d("Tag", "sharing content")
        val intent = activity!!.packageManager.getLaunchIntentForPackage("com.instagram.android")
        val shareIntent = Intent("com.instagram.share.ADD_TO_STORY")
        //shareIntent.setPackage("com.instagram.android")

        val drawable = ContextCompat.getDrawable(activity!!, R.drawable.liverpool)
        Log.d("FKZ", "drawable: $drawable")

        val bitmap = (drawable as? BitmapDrawable)?.bitmap
        Log.d("FKZ", "bitmap: $bitmap")

        val path = MediaStore.Images.Media.insertImage(
            activity!!.contentResolver,
            bitmap,
            "Liverpool.jpg",
            "You will never walk alone"
        )
        Log.d("FKZ", "path: $path")

        val uri = Uri.parse(path)

        shareIntent.setDataAndType(uri, "image/*")


        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
        activity!!.grantUriPermission("com.instagram.android", uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)

        startActivityForResult(shareIntent, 42)

    }
}
