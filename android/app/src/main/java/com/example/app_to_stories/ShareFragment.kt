package com.example.app_to_stories

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_share.*

class ShareFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        // Define image asset URI and attribution link URL
        val backgroundAssetUri = Uri.parse("https://sa.kapamilya.com/absnews/abscbnnews/media/2018/news/10/16/20181016_bolt.jpg")
        //String attributionLinkUrl = "https://www.my-aweseome-app.com/p/BhzbIOUBval/";

        // Instantiate implicit intent with ADD_TO_STORY action,
        // background asset, and attribution link
        val intent = Intent("com.instagram.share.ADD_TO_STORY")
        //intent.setType("image/*")

        intent.setDataAndType(backgroundAssetUri, "image/*")
        intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        intent.putExtra("top_background_color", "#33FF33")
        intent.putExtra("bottom_background_color", "#FF00FF")

        // Instantiate activity and verify it will resolve implicit intent
        //Activity activity = getActivity();
        if (activity!!.packageManager.resolveActivity(intent, 0) != null) {
            Log.d("Tag", "resolved")
            activity!!.startActivity(intent)
            Log.d("Tag", "resolved2")
        }
    }
}
