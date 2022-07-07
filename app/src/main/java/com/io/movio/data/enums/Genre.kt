package com.io.movio.data.enums

import androidx.annotation.StringRes
import com.io.movio.R

enum class Genre (@StringRes val genreNameId: Int, val id:Int) {
    HORROR ( R.string.genre_horror ,27),
    ACTION(R.string.genre_action,28),
    ADVENTURE(R.string.genre_adventure,12),
    ANIMATION(R.string.genre_animation,16),
    COMEDY(R.string.genre_comedy ,35),
    CRIME(R.string.genre_crime, 80),
    DOCUMENTARY(R.string.genre_documentary, 99),
    DRAMA(R.string.genre_drama,18),
    FAMILY(R.string.genre_family,10751),
    FANTASY(R.string.genre_fantasy,14),
    HISTORY(R.string.genre_history,36),
    MUSIC(R.string.genre_music, 10402),
    MYSTERY(R.string.genre_mystery,9648),
    ROMANCE(R.string.genre_romance,10749),
    SCIENCE_FICTION(R.string.genre_sci_fi, 878),
    TV_MOVIE(R.string.genre_tv_movie, 10770),
    THRILLER(R.string.genre_thriller ,53),
    WAR(R.string.genre_war ,10752),
    WESTERN(R.string.genre_western,37);

    companion object {
        fun getByValue(value: Int) = values().first { it.id == value }
    }
}




