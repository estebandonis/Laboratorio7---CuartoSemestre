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

        val repository = PokemonRepository()

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = PokemonListAdapter(repository.pokemonList)
        recyclerView.adapter = adapter

        val pokemonList = repository.getPokemonList(adapter)

        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}