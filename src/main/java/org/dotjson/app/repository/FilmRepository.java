package org.dotjson.app.repository;

import java.util.Optional;
import org.dotjson.app.model.Film;
import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.inject.Inject;

public class FilmRepository {
    
    @Inject
    JPAStreamer jpaStreamer;

    public Optional<Film> getFilm(short filmId) {
        return jpaStreamer.stream(Film.class)
            .filter(Film$.filmId.equal(filmId))
            .findFirst();
        
    }
}
