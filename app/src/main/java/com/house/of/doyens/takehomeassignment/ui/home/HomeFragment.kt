package com.house.of.doyens.takehomeassignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.house.of.doyens.takehomeassignment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardCargoFreight.setOnClickListener {
            Toast.makeText(this.requireContext(), "Cargo Freight Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.cardAirFreight.setOnClickListener {
            Toast.makeText(this.requireContext(), "Air Freight Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.cardOceanFreight.setOnClickListener {
            Toast.makeText(this.requireContext(), "Ocean Freight Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.cardLocalCourier.setOnClickListener {
            Toast.makeText(this.requireContext(), "Local Freight Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.tvAddStop.setOnClickListener{
            Toast.makeText(this.requireContext(), "This feature is coming soon", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}