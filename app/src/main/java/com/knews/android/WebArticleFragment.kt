package com.knews.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Created by asafvaron on 02/10/2017.
 */
class WebArticleFragment : Fragment() {

    private val TAG : String = "WebArticleFragment"

    private var mUrl: String? = null

    @SuppressLint("JavascriptInterface", "AddJavascriptInterface", "SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val root = inflater.inflate(R.layout.webview_fragment, container, false)

        mUrl = arguments.getString(KEY_URL)

        with(root) {
            if (TextUtils.isEmpty(mUrl)) {
                throw IllegalArgumentException("Empty url passed to WebViewFragment!")
            } else {
                val webView = findViewById<WebView>(R.id.web_view)
                val settings = webView.settings

                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true

                webView.webViewClient = WebViewClient()
                webView.loadUrl(mUrl)
                Log.d(TAG, "url loaded")
            }
        }

        return root
    }

    companion object {
        val KEY_URL = "key:url"
        fun newInstance(url: String?): WebArticleFragment {
            val fragment = WebArticleFragment()
            val args = Bundle()
            args.putString(KEY_URL, url)
            fragment.arguments = args
            return fragment
        }
    }
}