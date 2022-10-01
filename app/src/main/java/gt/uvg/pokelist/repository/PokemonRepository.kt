package gt.uvg.pokelist.repository

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import gt.uvg.pokelist.model.GetFirst100PokemonResponse
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.model.PokemonAPI
import gt.uvg.pokelist.view.PokemonListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PokemonRepository {
    val pokemonList = mutableListOf<Pokemon>()

    // Obtain pokemon list from https://pokeapi.co/
    fun getPokemonList(adapter: PokemonListAdapter): List<Pokemon> {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val pokeService: PokemonAPI = retrofit.create(PokemonAPI::class.java)

        //if(pokemonList.size == 1) {
            pokeService.getFirst100Pokemon().enqueue(object : Callback<GetFirst100PokemonResponse> {
                override fun onResponse(
                    call: Call<GetFirst100PokemonResponse>,
                    response: Response<GetFirst100PokemonResponse>
                ) {
                    Log.i("RESPONSE FROM API", response.toString())

                    val body = response.body()!!
                    var i: Int = 1
                    for (pokemon in body.results) {
                        pokemonList.add(Pokemon(i++, pokemon.name))
                    }

                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<GetFirst100PokemonResponse>, t: Throwable) {
                    Log.i("MainFragment", t.message ?: "Null message")
                }
            })
        return pokemonList
    }
}