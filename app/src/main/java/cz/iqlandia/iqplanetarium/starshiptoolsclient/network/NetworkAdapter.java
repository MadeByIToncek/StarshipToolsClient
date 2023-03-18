package cz.iqlandia.iqplanetarium.starshiptoolsclient.network;

import okhttp3.OkHttpClient;

public abstract class NetworkAdapter {

    private final String baseUrl;
    private final OkHttpClient client = new OkHttpClient();

    public NetworkAdapter(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public abstract void onError(String error);

    public String getScriptURL() {
        return baseUrl + "/script.html";
    }
}
