package com.jocmp.capy.accounts

import android.database.sqlite.SQLiteException
import com.jocmp.capy.db.ArticlesQueries

fun ArticlesQueries.create(
    id: String,
    feed_id: String?,
    title: String?,
    author: String?,
    content_html: String?,
    extracted_content_url: String?,
    url: String?,
    summary: String?,
    image_url: String?,
    published_at: Long?,
) {
    try {
        this.insert(
            id = id,
            feed_id = feed_id,
            title = title,
            author = author,
            content_html = content_html,
            extracted_content_url = extracted_content_url,
            url = url,
            summary = summary,
            image_url = image_url,
            published_at = published_at,
        )
    } catch (e: SQLiteException) {
        this.updateFull(
            id = id,
            feed_id = feed_id,
            title = title,
            author = author,
            content_html = content_html,
            extracted_content_url = extracted_content_url,
            url = url,
            summary = summary,
            image_url = image_url,
            published_at = published_at,
        )
    }
}

fun ArticlesQueries.createStatus(
    article_id: String,
    updated_at: Long,
    read: Boolean,
) {
    try {
        this.createStatusOld(
            article_id = article_id,
            updated_at = updated_at,
            read = read,
        )
    } catch (e: SQLiteException) {
        // Do nothing
    }
}

fun ArticlesQueries.updateStatus(
    article_id: String,
    updated_at: Long,
    last_read_at: Long?,
    read: Boolean,
    starred: Boolean,
) {
    try {
        this.insertStatus(
            article_id = article_id,
            updated_at = updated_at,
            last_read_at = last_read_at,
            read = read,
            starred = starred,
        )
    } catch (e: SQLiteException) {
        this.updateStatusOld(
            article_id = article_id,
            updated_at = updated_at,
            last_read_at = last_read_at,
            read = read,
            starred = starred,
        )
    }
}

fun ArticlesQueries.upsertUnread(articleID: String, updatedAt: Long) {
    try {
        this.insertUnread(
            articleID = articleID,
            updatedAt = updatedAt
        )
    } catch (e: SQLiteException) {
        this.updateUnread(
            articleID = articleID,
            updatedAt = updatedAt
        )
    }
}

fun ArticlesQueries.upsertStarred(articleID: String, updatedAt: Long) {
    try {
        this.insertStarred(
            articleID = articleID,
            updatedAt = updatedAt
        )
    } catch (e: SQLiteException) {
        this.updateStarred(
            articleID = articleID,
            updatedAt = updatedAt
        )
    }
}
