FROM circleci/android:api-28-alpha
WORKDIR sampleapp
RUN yes | sdkmanager --licenses || true
RUN sudo mkdir -p .gradle app/build/outputs/logs
COPY --chown=circleci:circleci . .
RUN sudo chown -R circleci:circleci . && sudo chmod -R 777 .
RUN ./gradlew androidDependencies
ENTRYPOINT ["/sampleapp/start.sh"]
