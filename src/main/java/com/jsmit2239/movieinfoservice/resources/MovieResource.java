package com.jsmit2239.movieinfoservice.resources;

import com.jsmit2239.movieinfoservice.models.Movie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) throws IOException, ParseException {
        return getMoviesFromJson(movieId);
    }

    private Movie getMoviesFromJson(String movieId) throws IOException, ParseException {
        Movie movie = new Movie();
        File stubbedData = getFileFromResources("stubbedData/stubbedData.json");
        Object obj = new JSONParser().parse(new FileReader(stubbedData.getCanonicalPath()));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObject.get("movies");

        jsonArray.forEach(item -> {
            JSONObject object = (JSONObject) item;
            if (object.get("movieId").equals(movieId)) {
                movie.setMovieId(object.get("movieId").toString());
                movie.setName(object.get("name").toString());
                movie.setDescription(object.get("description").toString());
            }
        });
        return movie;
    }

    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        System.out.println("path: " + resource.getPath());
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
