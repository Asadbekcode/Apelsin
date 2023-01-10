package com.example.apelsinclone.ui.fragments.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.apelsinclone.R
import com.example.apelsinclone.databinding.FragmentHomePageBinding
import com.example.apelsinclone.databinding.FragmentMainBinding
import com.example.apelsinclone.ui.fragments.adapters.BasicViewPager2Adapter
import com.example.apelsinclone.ui.fragments.adapters.FastEnterListAdapter
import com.example.apelsinclone.ui.fragments.models.FastEnterObject
import com.example.apelsinclone.utils.setCurrentItem
import java.util.*


class HomePageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        val view = binding.root
        initView()
        return view
    }

    private fun initView() {
        val adapter =  FastEnterListAdapter(requireContext())
        binding.rvFastEnter.adapter = adapter
        val list = mutableListOf<FastEnterObject>()
        list.add(FastEnterObject(R.drawable.ic_qr,"QR-To'lov"))
        list.add(FastEnterObject(R.drawable.ic_fast_temp,"HUMO pay"))
        list.add(FastEnterObject(R.drawable.ic_report,"Tarix"))
        list.add(FastEnterObject(R.drawable.ic_home_2,"Mening uyim"))
        list.add(FastEnterObject(R.drawable.ic_fast_temp,"Valyutalar kursi"))
        adapter.submitList(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}