# Stage 1: Build the application
FROM openjdk:11 AS build
WORKDIR /app
COPY TaskManagementApp.java Tasks.java TaskManager.java /app/
RUN javac TaskManagementApp.java Tasks.java TaskManager.java

# Stage 2: Run the application
FROM openjdk:11
WORKDIR /app
COPY --from=build /app/*.class /app/
CMD ["java", "TaskManagementApp"]

