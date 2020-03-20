package com.notekeeping

import android.content.Context
import android.widget.RemoteViews
import android.widget.RemoteViewsService

class AppWidgetRemoteViewsFactory(val context: Context) : RemoteViewsService.RemoteViewsFactory {
    override fun onCreate() {
        TODO("Not yet implemented")
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onDataSetChanged() {
        TODO("Not yet implemented")
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getViewAt(position: Int): RemoteViews {
        val rv = RemoteViews(context.packageName, R.layout.item_note_widget)
        rv.setTextViewText(R.id.note_title, DataManager.notes[position].title)

        return rv
    }

    override fun getCount(): Int {
        return DataManager.notes.size
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}