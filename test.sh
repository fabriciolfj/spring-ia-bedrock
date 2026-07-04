REGION="us-east-1"

for model in $(aws bedrock list-foundation-models \
  --region $REGION \
  --by-provider anthropic \
  --query "modelSummaries[].modelId" \
  --output text); do

  echo "=== $model ==="
  aws bedrock get-foundation-model-availability \
    --region $REGION \
    --model-id "$model" \
    --query "{agreement:agreementAvailability.status, auth:authorizationStatus, region:regionAvailability}" \
    --output text
  echo ""
done