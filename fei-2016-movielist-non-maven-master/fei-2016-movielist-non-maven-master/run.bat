mkdir target
echo "Compiling project"
javac -cp "libs/*" -d "target" sk/fei/ci/MovieList.java
echo "Try to access http://localhost:4567/hello via your browser"
java -cp "libs/*;./target" sk.fei.ci.MovieList
