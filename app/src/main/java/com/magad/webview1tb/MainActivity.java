package com.magad.webview1tb;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    WebView wv;
    ProgressBar pb;
    TextInputEditText edturl;
    LayoutInflater inflater;
    AlertDialog.Builder dialog;
    private View dialogView;
    Handler dly = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pb = findViewById(R.id.pbprog);
        wv = findViewById(R.id.webv);
        edturl = findViewById(R.id.edtsrch);


        wv.setWebViewClient(new MyWebClient());
        // webview kita inisialisasi bersama class webviewclient
        wv.setWebViewClient(new MyWebClient());
        // kita ubah jenis loading nya menjadi garis yang sedang peroses
        pb.setIndeterminate(true);

        // memasukan code javascript agar bisa di jalankan
        wv.getSettings().setJavaScriptEnabled(true);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogShow();
            }
        });
    }

    private void dialogShow() {
        dialog = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialogpop, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        dialog.setIcon(android.R.mipmap.sym_def_app_icon);
        dialog.setTitle("entah");

        final TextInputEditText edtemail, edtpassword;
        final Button log, reg;

        edtemail = dialogView.findViewById(R.id.email);
        edtpassword = dialogView.findViewById(R.id.password);
        log = dialogView.findViewById(R.id.btnlogin);
        reg = dialogView.findViewById(R.id.signup);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtemail.getText().toString().trim().length() == 0) {
                    edtemail.setError("anda lupa menaruh emailnya");
                }
                if (edtpassword.getText().toString().trim().length() == 0) {
                    edtpassword.setError("anda lupa menaruh emailnya");
                } else {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class)
                            .putExtra("email", edtemail.getText().toString())
                    );

                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Search(View view) {
        if (edturl.getText().toString().trim().length() == 0) {
            edturl.setError("maaf silahkan isi terlebih dahulu sebelum mencari");
        } else {
            wv.loadUrl(edturl.getText().toString());
        }
    }

    private class MyWebClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pb.setVisibility(view.GONE);
            pb.setIndeterminate(false);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(String.valueOf(request));
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}
