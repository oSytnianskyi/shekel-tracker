#!/bin/bash

PROJECT_ID="hb"
REGION="$1"
ENV="$2"

export AWS_DEFAULT_REGION=$REGION

LAMBDA_NAME="home_bookkeeping-api-$ENV"
COMMIT_SHA=$(git rev-parse --short=7 HEAD)
aws lambda update-function-configuration --function-name $LAMBDA_NAME --description $COMMIT_SHA > /dev/null
aws lambda wait function-updated --function-name $LAMBDA_NAME
NEW_VERSION=$(aws lambda update-function-code --function-name $LAMBDA_NAME --zip-file fileb://api/build/function.zip --publish | jq -r '.Version')
aws lambda update-alias --function-name $LAMBDA_NAME --name live --function-version $NEW_VERSION
aws lambda wait function-updated --function-name $LAMBDA_NAME
