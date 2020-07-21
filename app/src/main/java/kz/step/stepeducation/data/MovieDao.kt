package kz.step.stepeducation.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert
    fun initiateInsertMovie(movie: Movie)

    @Insert
    fun initiateInsertMovies(movies: List<Movie>)

    @Query("SELECT * FROM movie")
    fun initiateGetMovies(): List<Movie>

    @Query("SELECT * FROM movie WHERE id = :movieId")
    fun initiateGetMovieById(movieId: Int): Movie


}