package ua.com.tod.examples.androidexamples.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.tod.examples.androidexamples.MainActivity;

@Module(
        injects = MainActivity.class,
        complete = false
)
public class NetworkModule {
    @Provides
    @Singleton
    INetworkManager provideLocationManager() {
        return new NetworkManager();
    }
}
