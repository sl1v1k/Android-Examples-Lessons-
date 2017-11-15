package ua.com.tod.examples.androidexamples;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import ua.com.tod.examples.androidexamples.model.NetworkModule;

public class MyApp extends Application {

    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        graph = ObjectGraph.create(getModules().toArray());
    }

    protected List<?> getModules() {
        return Arrays.asList(
                new NetworkModule()
        );
    }

    public void inject(Object object) {
        graph.inject(object);
    }


}
