#!/bin/bash
set -e

find src -name "*.java" -print >javafiles
if [ ! -d bin ]; then
    mkdir bin
fi
javac -d bin -cp lib/dpprocessor.jar -source 8 -target 8 @javafiles

jar -cfm jeu.jar manifest.mf -C bin/ .
