mkdir target
javac -cp "libs/*" -d "target" sk/fei/ci/MovieList.java
javac -cp "libs/*;target" -d "target" sk/fei/ci/MovieListTest.java
java -cp  "libs/*;target" org.junit.runner.JUnitCore sk.fei.ci.MovieListTest
