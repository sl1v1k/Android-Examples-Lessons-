package ua.com.tod.examples.androidexamples.model;

public class NetworkManager implements INetworkManager {
    @Override
    public void login(String login, String pass, Callback callback) {
        callback.onData("Data");
    }
}
