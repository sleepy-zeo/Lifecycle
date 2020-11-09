package com.sleepy.zeo.demo;

import com.sleepy.zeo.Lifecycle;
import com.sleepy.zeo.LifecycleEvent;
import com.sleepy.zeo.LifecycleListener;
import com.sleepy.zeo.LifecycleSupport;

public class Light implements Lifecycle {
    private LifecycleSupport lifecycleSupport = new LifecycleSupport(this);

    @Override
    public void addLifecycleListener(LifecycleListener listener) {
        lifecycleSupport.addLifecycleListener(listener);
    }

    @Override
    public void removeLifecycleListener(LifecycleListener listener) {
        lifecycleSupport.removeLifecycleListener(listener);
    }

    @Override
    public void fireLifecycleEvent(String type, Object data) {
        lifecycleSupport.fireLifecycleEvent(type, data);
    }

    @Override
    public LifecycleListener[] getLifecycleListeners() {
        return lifecycleSupport.getLifecycleListeners();
    }

    @Override
    public void start() {
        fireLifecycleEvent(LifecycleEvent.TYPE_BEFORE_START, null);
        System.out.println("light " + this.name + " starting...");
        fireLifecycleEvent(LifecycleEvent.TYPE_AFTER_START, null);
    }

    @Override
    public void stop() {
        fireLifecycleEvent(LifecycleEvent.TYPE_BEFORE_STOP, null);
        System.out.println("light " + this.name + " stopping...");
        fireLifecycleEvent(LifecycleEvent.TYPE_AFTER_STOP, null);
    }

    private String name;

    public Light(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}