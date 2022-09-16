package gt.uvg.pokelist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.Pokemon
import java.lang.Exception

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {

    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.binding.pokemonName.text = pokemon.name

        val imageView = holder.binding.pokemonPhoto

        Picasso.get()
            .load(pokemon.imageUrlFront)
            .resize(200,200)
            //.centerCrop()
            .centerInside()
            .placeholder(R.drawable.wait)
            .error(R.drawable.no)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    // no-op
                }

                override fun onError(e: Exception?) {
                    e?.printStackTrace()
                }

            })

        holder.binding.button.setOnClickListener(){
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(position)
            holder.binding.root.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }
}