package com.ravn.starwarswiki.data.model

data class PageInfoModel(
    val hasNextPage: Boolean,
    val hasPreviousPage: Boolean,
    val startCursor: String,
    val endCursor: String,
)