package com.example.k2dbinarywatch.presentation

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.k2dbinarywatch.R
import com.example.k2dbinarywatch.domain.updateTime
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * Implementation of App Widget functionality.
 */
class K2DBinaryWatchWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

            val views = RemoteViews(context.packageName, R.layout.k2_d_binary_watch_widget)
            views.setOnClickPendingIntent(R.id.appwidget_top, pendingIntent)
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    var widgetText: String
    var widgetTextMinutes: String
    var widgetTextSeconds: String
    val scope = MainScope()
    scope.launch {

        while (true) {
            delay(1000)
            val myDate = updateTime()

            var binaryHours = myDate[0].toString()
            binaryHours += myDate[1]
            var binaryMinutes = myDate[3].toString()
            binaryMinutes += myDate[4]
            var binarySeconds = myDate[6].toString()
            binarySeconds += myDate[7]
            widgetText = binaryHours.toInt().toString(2)
            widgetTextMinutes = binaryMinutes.toInt().toString(2)
            widgetTextSeconds = binarySeconds.toInt().toString(2)

            val views = RemoteViews(context.packageName, R.layout.k2_d_binary_watch_widget)
            views.setTextViewText(R.id.appwidget_text, widgetText)
            appWidgetManager.updateAppWidget(appWidgetId, views)
            val viewsMinutes = RemoteViews(context.packageName, R.layout.k2_d_binary_watch_widget)
            viewsMinutes.setTextViewText(R.id.appwidget_text_minutes, widgetTextMinutes)
            appWidgetManager.updateAppWidget(appWidgetId, viewsMinutes)
            val viewsSeconds = RemoteViews(context.packageName, R.layout.k2_d_binary_watch_widget)
            viewsSeconds.setTextViewText(R.id.appwidget_text_seconds, widgetTextSeconds)
            appWidgetManager.updateAppWidget(appWidgetId, viewsSeconds)
        }
    }
}