package uz.gita.memorygame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.gita.memorygame.databinding.FragmentMenuBinding
import uz.gita.memorygame.model.Levels

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private var _binding: FragmentMenuBinding? =null
private val binding get() =_binding!!
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding= FragmentMenuBinding.inflate(inflater,container,false)
        binding.mid.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.main,LevelsFragment.newInstance(Levels.MIDDLE.level)).commit()
        }
        binding.easy.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.main,LevelsFragment.newInstance(Levels.EASY.level)).commit()
        }
        binding.hard.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.main,LevelsFragment.newInstance(Levels.HARD.level)).commit()
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}