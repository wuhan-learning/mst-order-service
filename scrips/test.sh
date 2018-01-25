#! /usr/bin/env bash
set -x 
set -e

docker run --rm -v /tmp/gradle-caches:/root/.gradle/caches -v $WORKDIR/pipelines/$GOPIPELINENAME:/opt/app -w /opt/app gradle:3.5-jdk8 gradle clean test
