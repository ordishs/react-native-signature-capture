package com.rssignaturecapture;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// import android.app.Activity;

import com.rssignaturecapture.RSSignatureCaptureViewManager;

import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class RSSignatureCapture implements ReactPackage {
  private RSSignatureCaptureViewManager rSSignatureCaptureViewManager = new RSSignatureCaptureViewManager();

  @Override
  public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
    List<NativeModule> modules = new ArrayList<>();
    modules.add(new RSSignatureCapturePackage(reactApplicationContext, rSSignatureCaptureViewManager));
    return modules;
  }

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
    return Arrays.<ViewManager>asList(rSSignatureCaptureViewManager);
  }

  @Override
  public List<Class<? extends JavaScriptModule>> createJSModules() {
    return Arrays.asList();
  }
}
