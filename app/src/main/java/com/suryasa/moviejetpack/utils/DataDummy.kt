package com.suryasa.moviejetpack.utils

import com.suryasa.moviejetpack.data.source.local.entity.MovieEntity
import com.suryasa.moviejetpack.data.source.local.entity.TvShowEntity
import com.suryasa.moviejetpack.data.source.remote.response.MovieResponse
import com.suryasa.moviejetpack.data.source.remote.response.TvShowResponse

object DataDummy {
    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity("399579",
            "Alita: Battle Angel",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "Action, Science Fiction, Adventure",
            "7.2",
            true)
        )
        movies.add(
            MovieEntity("297802",
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            "Action, Fantasy, Adventure",
            "6.9")
        )
        movies.add(
            MovieEntity("424694",
            "Bohemian Rhapsody",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
            "Music, Drama, History",
            "8.0")
        )
        movies.add(
            MovieEntity("450465",
            "Glass",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
            "Thriller, Drama, Science Fiction",
            "6.7")
        )
        movies.add(
            MovieEntity("460465",
            "Mortal Kombat",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
            "Action, Fantasy, Adventure",
            "7.6")
        )
        movies.add(
            MovieEntity("399566",
            "Godzilla vs. Kong",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "Science Fiction, Action, Drama",
            "8.1")
        )
        movies.add(
            MovieEntity("615457",
            "Nobody",
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
            "Action, Thriller, Crime, Comedy",
            "8.4")
        )
        movies.add(
            MovieEntity("527774",
            "Raya and the Last Dragon",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
            "Animation, Adventure, Fantasy, Family, Action",
            "8.2")
        )
        movies.add(
            MovieEntity("587807",
            "Tom & Jerry",
            "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8XZI9QZ7Pm3fVkigWJPbrXCMzjq.jpg",
            "Comedy, Family, Animation",
            "7.3")
        )
        movies.add(
            MovieEntity("385128",
            "F9",
            "Dominic Toretto is leading a quiet life off the grid with Letty and his son, little Brian, but they know that danger always lurks just over their peaceful horizon. This time, that threat will force Dom to confront the sins of his past if he’s going to save those he loves most. His crew joins together to stop a world-shattering plot led by the most skilled assassin and high-performance driver they’ve ever encountered: a man who also happens to be Dom’s forsaken brother, Jakob.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
            "Action, Thriller, Crime",
            "8.7")
        )
        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()
        tvShows.add(
            TvShowEntity("1416",
            "Grey's Anatomy",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ezHR68DZeyKgRraAZd3eGCgmIl.jpg",
            "Drama",
            "8.2",
            true)
        )
        tvShows.add(
            TvShowEntity("120168",
            "Who Killed Sara?",
            "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
            "Drama, Crime, Mystery",
            "7.8")
        )
        tvShows.add(
            TvShowEntity("88396",
            "The Falcon and the Winter Soldier",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
            "7.9")
        )
        tvShows.add(
            TvShowEntity("60735",
            "The Flash",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "Drama, Sci-Fi & Fantasy",
            "7.7")
        )
        tvShows.add(
            TvShowEntity("93484",
            "Jupiter's Legacy",
            "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
            "Sci-Fi & Fantasy, Action & Adventure, Drama, Mystery",
            "7.4")
        )
        tvShows.add(
            TvShowEntity("105971",
            "The Bad Batch",
            "Follow the elite and experimental Clones of the Bad Batch as they find their way in a rapidly changing galaxy in the aftermath of the Clone Wars.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/WjQmEWFrOf98nT5aEfUfVYz9N2.jpg",
            "Sci-Fi & Fantasy, Action & Adventure, Animation",
            "8.9")
        )
        tvShows.add(
            TvShowEntity("46260",
            "Naruto",
            "In another world, ninja are the ultimate power, and in the Village Hidden in the Leaves live the stealthiest ninja in the land. Twelve years earlier, the fearsome Nine-Tailed Fox terrorized the village and claimed many lives before it was subdued and its spirit sealed within the body of a baby boy. That boy, Naruto Uzumaki, has grown up to become a ninja-in-training who's more interested in pranks than in studying ninjutsu.. but Naruto is determined to become the greatest ninja ever!",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vauCEnR7CiyBDzRCeElKkCaXIYu.jpg",
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            "8.4")
        )
        tvShows.add(
            TvShowEntity("71712",
            "The Good Doctor",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
            "Drama",
            "8.6")
        )
        tvShows.add(
            TvShowEntity("86430",
            "Your Honor",
            "New Orleans judge Michael Desiato is forced to confront his own deepest convictions when his son is involved in a hit and run that embroils an organized crime family.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xWJZjIKPeEZhK3JRYKOe06yW6IU.jpg",
            "Drama",
            "8.2")
        )
        tvShows.add(
            TvShowEntity("456",
            "The Simpsons",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zLudbPueg8CxGhMS2tyDh3p0TdK.jpg",
            "Family, Animation, Comedy",
            "7.8")
        )
        return tvShows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse("399579",
            "Alita: Battle Angel",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "Action, Science Fiction, Adventure",
            "7.2")
        )
        movies.add(
            MovieResponse("297802",
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            "Action, Fantasy, Adventure",
            "6.9")
        )
        movies.add(
            MovieResponse("424694",
            "Bohemian Rhapsody",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
            "Music, Drama, History",
            "8.0")
        )
        movies.add(
            MovieResponse("450465",
            "Glass",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
            "Thriller, Drama, Science Fiction",
            "6.7")
        )
        movies.add(
            MovieResponse("460465",
            "Mortal Kombat",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
            "Action, Fantasy, Adventure",
            "7.6")
        )
        movies.add(
            MovieResponse("399566",
            "Godzilla vs. Kong",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "Science Fiction, Action, Drama",
            "8.1")
        )
        movies.add(
            MovieResponse("615457",
            "Nobody",
            "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
            "Action, Thriller, Crime, Comedy",
            "8.4")
        )
        movies.add(
            MovieResponse("527774",
            "Raya and the Last Dragon",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
            "Animation, Adventure, Fantasy, Family, Action",
            "8.2")
        )
        movies.add(
            MovieResponse("587807",
            "Tom & ModelResponse",
            "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8XZI9QZ7Pm3fVkigWJPbrXCMzjq.jpg",
            "Comedy, Family, Animation",
            "7.3")
        )
        movies.add(
            MovieResponse("385128",
            "F9",
            "Dominic Toretto is leading a quiet life off the grid with Letty and his son, little Brian, but they know that danger always lurks just over their peaceful horizon. This time, that threat will force Dom to confront the sins of his past if he’s going to save those he loves most. His crew joins together to stop a world-shattering plot led by the most skilled assassin and high-performance driver they’ve ever encountered: a man who also happens to be Dom’s forsaken brother, Jakob.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
            "Action, Thriller, Crime",
            "8.7")
        )
        return movies
    }

    fun generateRemoteDummyTvShows(): List<TvShowResponse> {
        val tvShows = ArrayList<TvShowResponse>()
        tvShows.add(
            TvShowResponse("1416",
            "Grey's Anatomy",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ezHR68DZeyKgRraAZd3eGCgmIl.jpg",
            "Drama",
            "8.2")
        )
        tvShows.add(
            TvShowResponse("120168",
            "Who Killed Sara?",
            "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
            "Drama, Crime, Mystery",
            "7.8")
        )
        tvShows.add(
            TvShowResponse("88396",
            "The Falcon and the Winter Soldier",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
            "7.9")
        )
        tvShows.add(
            TvShowResponse("60735",
            "The Flash",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "Drama, Sci-Fi & Fantasy",
            "7.7")
        )
        tvShows.add(
            TvShowResponse("93484",
            "Jupiter's Legacy",
            "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
            "Sci-Fi & Fantasy, Action & Adventure, Drama, Mystery",
            "7.4")
        )
        tvShows.add(
            TvShowResponse("105971",
            "The Bad Batch",
            "Follow the elite and experimental Clones of the Bad Batch as they find their way in a rapidly changing galaxy in the aftermath of the Clone Wars.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/WjQmEWFrOf98nT5aEfUfVYz9N2.jpg",
            "Sci-Fi & Fantasy, Action & Adventure, Animation",
            "8.9")
        )
        tvShows.add(
            TvShowResponse("46260",
            "Naruto",
            "In another world, ninja are the ultimate power, and in the Village Hidden in the Leaves live the stealthiest ninja in the land. Twelve years earlier, the fearsome Nine-Tailed Fox terrorized the village and claimed many lives before it was subdued and its spirit sealed within the body of a baby boy. That boy, Naruto Uzumaki, has grown up to become a ninja-in-training who's more interested in pranks than in studying ninjutsu.. but Naruto is determined to become the greatest ninja ever!",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vauCEnR7CiyBDzRCeElKkCaXIYu.jpg",
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            "8.4")
        )
        tvShows.add(
            TvShowResponse("71712",
            "The Good Doctor",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
            "Drama",
            "8.6")
        )
        tvShows.add(
            TvShowResponse("86430",
            "Your Honor",
            "New Orleans judge Michael Desiato is forced to confront his own deepest convictions when his son is involved in a hit and run that embroils an organized crime family.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xWJZjIKPeEZhK3JRYKOe06yW6IU.jpg",
            "Drama",
            "8.2")
        )
        tvShows.add(
            TvShowResponse("456",
            "The Simpsons",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zLudbPueg8CxGhMS2tyDh3p0TdK.jpg",
            "Family, Animation, Comedy",
            "7.8")
        )
        return tvShows
    }

    fun generateRemoteDummyDetailMovie(movieId: String): MovieResponse {
        return MovieResponse(
            movieId,
            "Alita: Battle Angel",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "Action, Science Fiction, Adventure",
            "7.2"
        )
    }

    fun generateRemoteDummyDetailTvShow(tvshowId: String): TvShowResponse {
        return TvShowResponse(
            tvshowId,
            "Grey's Anatomy",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ezHR68DZeyKgRraAZd3eGCgmIl.jpg",
            "Drama",
            "8.2"
        )
    }

    fun generateDummyDetailMovie(movieId: String): MovieEntity {
        return MovieEntity(
            "399579",
            "Alita: Battle Angel",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "Action, Science Fiction, Adventure",
            "7.2"
        )
    }

    fun generateDummyDetailTvShow(tvshowId: String): TvShowEntity {
        return TvShowEntity(
            "1416",
            "Grey's Anatomy",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ezHR68DZeyKgRraAZd3eGCgmIl.jpg",
            "Drama",
            "8.2"
        )
    }

    fun generateBookmarkMovie(): List<MovieEntity> {
        val movie = ArrayList<MovieEntity>()
        generateDummyMovies().forEach {
            if (it.bookmark) movie.add(it)
        }
        return movie
    }

    fun generateBookmarkTvShow(): List<TvShowEntity> {
        val tvshow = ArrayList<TvShowEntity>()
        generateDummyTvShows().forEach {
            if (it.bookmark) tvshow.add(it)
        }
        return tvshow
    }
}