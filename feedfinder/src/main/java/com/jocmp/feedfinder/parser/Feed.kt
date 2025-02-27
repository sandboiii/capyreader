package com.jocmp.feedfinder.parser

import com.jocmp.rssparser.model.RssItem
import java.net.URL

interface Feed {
    fun isValid(): Boolean

    val name: String

    val feedURL: URL

    val siteURL: URL?

    val faviconURL: URL?

    val items: List<RssItem>
}
