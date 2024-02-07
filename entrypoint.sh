#!/bin/bash

run_service() {
  exec java -Dspring.profiles.active=parametrized -jar /app/app.jar
}

run_service