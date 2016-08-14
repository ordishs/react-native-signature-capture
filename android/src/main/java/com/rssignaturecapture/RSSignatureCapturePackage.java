package com.rssignaturecapture;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import android.app.Activity;
import android.content.Intent;
import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RSSignatureCapturePackage extends ReactContextBaseJavaModule implements ActivityEventListener, LifecycleEventListener {
  private boolean initialized = false;
  private Intent launchIntent;
  private Context context;

  private RSSignatureCaptureViewManager mRSSignatureCaptureViewManager;

  public RSSignatureCapturePackage(ReactApplicationContext reactApplicationContext, RSSignatureCaptureViewManager rSSignatureCaptureViewManager) {
    super(reactApplicationContext);
    mRSSignatureCaptureViewManager = rSSignatureCaptureViewManager;
    reactApplicationContext.addLifecycleEventListener(this);
  }

  @Override
  public String getName() {
    return "RSSignatureCapturePackage";
  }

  @Override
  public void initialize() {
    // do nothing
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent) {

  }

  @Override
  public void onHostResume() {
    if (!initialized) {
      Activity activity = getCurrentActivity();
      if (activity == null) {
        return;
      }
      launchIntent = activity.getIntent();
      context = activity.getApplicationContext();

      if (launchIntent.hasExtra("forceReload")) {
        activity.moveTaskToBack(true);
      }

      mRSSignatureCaptureViewManager.setActivity(activity);

      initialized = true;
    }
  }

  @Override
  public void onHostPause() {

  }

  @Override
  public void onHostDestroy() {

  }
}
