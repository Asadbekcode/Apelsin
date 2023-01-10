package com.example.apelsinclone.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.apelsinclone.R
import com.example.apelsinclone.databinding.FragmentMainBinding
import com.example.apelsinclone.ui.fragments.adapters.BasicViewPager2Adapter
import com.example.apelsinclone.ui.fragments.pages.*
import com.example.apelsinclone.utils.setCurrentItem
import java.util.*


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val fragments: MutableList<Fragment> = LinkedList()
    private var lastClickedId = R.id.home

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        initView()
        return view
    }

    private fun initView() {
        binding.viewPager2.isUserInputEnabled = false

        binding.viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        lastClickedId = R.id.home
                    }
                    1 -> {
                        lastClickedId = R.id.transfer
                    }
                    2 -> {
                        lastClickedId = R.id.payment
                    }
                    3 -> {
                        lastClickedId = R.id.chat
                    }
                    4 -> {
                        lastClickedId = R.id.menu
                    }
                }
                binding.bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })

        fragments.add(HomePageFragment())
        fragments.add(TransferPageFragment())
        fragments.add(PaymentPageFragment())
        fragments.add(ChatPageFragment())
        fragments.add(MenuPageFragment())
        binding.viewPager2.adapter = BasicViewPager2Adapter(requireActivity(), fragments)
        binding.viewPager2.offscreenPageLimit = 5

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            if (lastClickedId != item.itemId) {
                when (item.itemId) {
                    R.id.home -> {
                        binding.viewPager2.setCurrentItem(0,150)
                        lastClickedId = R.id.home
                    }
                    R.id.transfer -> {
                        binding.viewPager2.setCurrentItem(1,150)
                        lastClickedId = R.id.transfer
                    }
                    R.id.payment -> {
                        binding.viewPager2.setCurrentItem(2,150)
                        lastClickedId = R.id.payment
                    }
                    R.id.chat -> {
                        binding.viewPager2.setCurrentItem(3,150)
                        lastClickedId = R.id.chat
                    }
                    R.id.menu -> {
                        binding.viewPager2.setCurrentItem(4,150)
                        lastClickedId = R.id.menu
                    }
                }
                true
            } else {
                false
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}