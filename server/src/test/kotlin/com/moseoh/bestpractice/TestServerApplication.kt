package com.moseoh.bestpractice

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<ServerApplication>().with(TestcontainersConfiguration::class).run(*args)
}