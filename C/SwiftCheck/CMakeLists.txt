cmake_minimum_required(VERSION 3.9)
project(SwiftCheck)

add_custom_target(SwiftCheck ALL
        COMMAND /usr/bin/swift build
        WORKING_DIRECTORY ${CMAKE_SOURCE_DIR}
        SOURCES Sources/main.swift)
