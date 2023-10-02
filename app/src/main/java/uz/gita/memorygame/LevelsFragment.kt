package uz.gita.memorygame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import uz.gita.memorygame.databinding.FragmentLevelsBinding

private const val ARG_PARAM1 = "param1"
private var _binding: FragmentLevelsBinding? =null
private val binding get() =_binding!!
class LevelsFragment : Fragment() {
    private var param1: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        loadUI(param1!!)
        return inflater.inflate(R.layout.fragment_levels, container, false)
    }
    fun loadUI(level: Int){
        binding.mainLinear.weightSum=level.toFloat()
        for (i in 0..level-1){
            var innerLayout = binding.mainLinear.getChildAt(i) as LinearLayout
            for (i in 0..innerLayout.childCount-1){
            var image:ImageView= ImageView(requireContext()).apply {
                layoutParams=LinearLayout.LayoutParams(0,innerLayout.layoutParams.height,1f)
                setImageResource(R.drawable.unknown)
            }
            innerLayout.addView(image)
            }

        }

    }


    companion object {
        @JvmStatic
        fun newInstance(level: Int) =
            LevelsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, level)
                }
            }
    }
}