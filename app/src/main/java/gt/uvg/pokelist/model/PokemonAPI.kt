package gt.uvg.pokelist.model


import retrofit2.Call
import retrofit2.http.GET

interface PokemonAPI {
    @GET("pokemon?limit=100&offset=0")
    fun getFirst100Pokemon(): Call<GetFirst100PokemonResponse>
}