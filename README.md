# reviews-simulator
./mvnw package

podman build -f src/main/docker/Dockerfile.jvm -t quay.io/globex-sentiment-analysis/reviews-simulator:latest .

podman push quay.io/globex-sentiment-analysis/reviews-simulator:latest

podman build -f src/main/docker/Dockerfile.jvm -t quay.io/globex-sentiment-analysis/reviews-simulator:jc-wip .

podman push quay.io/globex-sentiment-analysis/reviews-simulator:jc-wip

