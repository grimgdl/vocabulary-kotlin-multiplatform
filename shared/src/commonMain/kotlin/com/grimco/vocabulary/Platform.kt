package com.grimco.vocabulary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform