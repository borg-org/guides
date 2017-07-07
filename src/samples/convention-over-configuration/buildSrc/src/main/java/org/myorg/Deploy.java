package org.myorg;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.PropertyState;
import org.gradle.api.provider.Provider;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class Deploy extends DefaultTask {
    private final PropertyState<String> url;
    
    public Deploy() {
        this.url = getProject().property(String.class);
    }
    
    @Input
    public String getUrl() {
        return url.get();
    }
    
    public void setUrl(Provider<String> url) {
        this.url.set(url);
    }
    
    @TaskAction
    public void deploy() {
        System.out.println("Deploying to URL " + getUrl());
    }
}