import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by geoguitar on 22/06/15.
 */
public class AcessoWEB {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String produto = bundle.getString("produto");

        webView.loadUrl("http://compare.buscape.com.br/"+produto);

    }
}
