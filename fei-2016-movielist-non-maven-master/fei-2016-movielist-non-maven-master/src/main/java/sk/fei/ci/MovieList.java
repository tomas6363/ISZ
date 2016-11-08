package sk.fei.ci;

import static spark.Spark.*;

public class MovieList {

	public static void main(String[] args) {
		port(getHerokuAssignedPort());
		get("/", (req, res) -> "Index page");
		get("/hello", (req, res) -> "Hello World<br/>Save private ryan");
	}

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567;
	}
}
