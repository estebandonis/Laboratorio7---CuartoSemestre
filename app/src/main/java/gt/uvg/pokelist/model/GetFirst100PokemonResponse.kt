package gt.uvg.pokelist.model

data class GetFirst100PokemonResponse(val count: Int = 0, val next: String = "", val previous: String? = "", val results: List<NamedAPIResource> = listOf()){
    data class NamedAPIResource(val name: String, val url: String)
}
