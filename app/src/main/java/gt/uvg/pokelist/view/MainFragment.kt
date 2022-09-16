package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.databinding.FragmentMainBinding
import gt.uvg.pokelist.repository.PokemonRepository

class MainFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        super.onViewCreated(view, savedInstanceState)

        val pokemonList = PokemonRepository().getPokemonList()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = PokemonListAdapter(pokemonList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}