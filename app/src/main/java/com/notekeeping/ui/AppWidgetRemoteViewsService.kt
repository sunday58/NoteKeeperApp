package com.notekeeping.ui

import android.content.Intent
import android.widget.RemoteViewsService
import com.notekeeping.AppWidgetRemoteViewsFactory

class AppWidgetRemoteViewsService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        return AppWidgetRemoteViewsFactory(applicationContext)
    }
}