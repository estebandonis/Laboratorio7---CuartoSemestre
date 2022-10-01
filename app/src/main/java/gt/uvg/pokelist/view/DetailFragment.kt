package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.databinding.FragmentDetailBinding
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.repository.PokemonRepository
import java.lang.Exception

class DetailFragment : Fragment() {
    val args: DetailFragmentArgs by navArgs()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.id + 1
        val name = args.name
        val pokemon = Pokemon(id, name)

        val imageViewFront = view.findViewById<ImageView>(R.id.imageView2)
        val imageViewBack = view.findViewById<ImageView>(R.id.imageView3)
        val imageViewFrontShinny = view.findViewById<ImageView>(R.id.imageView4)
        val imageViewBackShinny = view.findViewById<ImageView>(R.id.imageView5)

        Picasso.get()
            .load(pokemon.imageUrlFront)
            .resize(200,200)
            //.centerCrop()
            .centerInside()
            .placeholder(R.drawable.wait)
            .error(R.drawable.no)
            .into(imageViewFront, object : Callback {
                override fun onSuccess() {
                    // no-op
                }

                override fun onError(e: Exception?) {
                    e?.printStackTrace()
                }

            })

        Picasso.get()
            .load(pokemon.imageUrlBack)
            .resize(200,200)
            //.centerCrop()
            .centerInside()
            .placeholder(R.drawable.wait)
            .error(R.drawable.no)
            .into(imageViewBack, object : Callback {
                override fun onSuccess() {
                    // no-op
                }

                override fun onError(e: Exception?) {
                    e?.printStackTrace()
                }

            })

        Picasso.get()
            .load(pokemon.imageUrlShinnyFront)
            .resize(200,200)
            //.centerCrop()
            .centerInside()
            .placeholder(R.drawable.wait)
            .error(R.drawable.no)
            .into(imageViewFrontShinny, object : Callback {
                override fun onSuccess() {
                    // no-op
                }

                override fun onError(e: Exception?) {
                    e?.printStackTrace()
                }

            })

        Picasso.get()
            .load(pokemon.imageUrlShinnyBack)
            .resize(200,200)
            //.centerCrop()
            .centerInside()
            .placeholder(R.drawable.wait)
            .error(R.drawable.no)
            .into(imageViewBackShinny, object : Callback {
                override fun onSuccess() {
                    // no-op
                }

                override fun onError(e: Exception?) {
                    e?.printStackTrace()
                }

            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}