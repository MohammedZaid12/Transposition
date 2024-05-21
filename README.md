RUN
./gradlew clean build
cd build/libs
java -jar transposition-task-1.0.jar {input file path} {semitone} {output file path} 
# Example
java -jar transposition-task-1.0.jar ../../input.json -3 ../../output.json
