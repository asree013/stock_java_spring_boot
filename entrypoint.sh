#!/bin/sh
set -e

# Wait for MySQL to be ready
until nc -z mysql 3306; do
  echo "Waiting for MySQL..."
  sleep 2
done

# Run the application
exec java -jar app.jar
