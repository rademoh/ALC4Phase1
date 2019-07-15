package rabiu.com.alc4challengeone;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class AboutActivity extends AppCompatActivity {

    WebView browser;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mProgressBar = (ProgressBar) findViewById(R.id.pb);
        browser = findViewById(R.id.webview);
        browser.setWebViewClient(new MyWebViewClient());
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(android.webkit.WebView view, int newProgress) {
                mProgressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
        browser.loadUrl("https://andela.com/alc/");


    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String url) {
            webView.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(android.webkit.WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mProgressBar.setVisibility(View.VISIBLE);
        }


        @Override
        public void onPageFinished(android.webkit.WebView view, String url) {
            mProgressBar.setVisibility(View.GONE);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onReceivedError(android.webkit.WebView view, WebResourceRequest request, WebResourceError error) {
        }

        @Override
        public void onReceivedSslError(android.webkit.WebView view, SslErrorHandler handler, SslError error) {
            Log.d("ssl error response", error.toString() + " " + error.getPrimaryError());
            handler.proceed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.browser.canGoBack()) {
            this.browser.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
