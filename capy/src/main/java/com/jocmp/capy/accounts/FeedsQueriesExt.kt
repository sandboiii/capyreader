package com.jocmp.capy.accounts

import android.database.sqlite.SQLiteException
import com.jocmp.capy.db.FeedsQueries

fun FeedsQueries.upsert(
    id: String,
    subscription_id: String,
    title: String,
    feed_url: String,
    site_url: String?,
    favicon_url: String?,
) {
    try {
        this.insert(
            id = id,
            subscription_id = subscription_id,
            title = title,
            feed_url = feed_url,
            site_url = site_url,
            favicon_url = favicon_url,
        )
    } catch (e: SQLiteException) {
        this.updateFull(
            id = id,
            subscription_id = subscription_id,
            title = title,
            feed_url = feed_url,
            site_url = site_url,
            favicon_url = favicon_url,
        )
    }
}
