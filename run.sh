#!/bin/bash

exec java ${JAVA_OPTIONS} \
        -cp ./libs \
        org.springframework.boot.loader.JarLauncher
