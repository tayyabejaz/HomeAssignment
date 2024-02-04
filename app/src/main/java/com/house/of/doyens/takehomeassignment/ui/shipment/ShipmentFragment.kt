package com.house.of.doyens.takehomeassignment.ui.shipment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.house.of.doyens.takehomeassignment.data.ShipmentModel
import com.house.of.doyens.takehomeassignment.data.ShipmentStatusType
import com.house.of.doyens.takehomeassignment.databinding.FragmentShipmentBinding

@Suppress("UNUSED_EXPRESSION")
class ShipmentFragment : Fragment() {

    private var _binding: FragmentShipmentBinding? = null
    private var adapter: ShipmentRecyclerAdapter? = null
    private var data: MutableList<ShipmentModel> = mutableListOf()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(ShipmentViewModel::class.java)

        _binding = FragmentShipmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        initData()
        initTabsBadges()
        initRecyclerView()
        binding.tlShipment.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (tab.position) {
                        0 -> {
                            Log.i(
                                activity!!.javaClass.simpleName,
                                "You selected ${tab.text} tab at ${tab?.position} position"
                            )
                        }//Completed
                        1 -> {
                            Log.i(
                                activity!!.javaClass.simpleName,
                                "You selected ${tab.text} tab at ${tab?.position} position"
                            )
                        } // In Progress
                        2 -> {
                            Log.i(
                                activity!!.javaClass.simpleName,
                                "You selected ${tab?.text} tab at ${tab?.position} position"
                            )
                        } //In Transit
                        3 -> {
                            Log.i(
                                activity!!.javaClass.simpleName,
                                "You selected ${tab?.text} tab at ${tab?.position} position"
                            )
                        } //Cancelled
                        else -> {}
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                true
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.let {
                    when (tab.position) {
                        0 -> {
                            Log.i(
                                activity!!.javaClass.simpleName,
                                "You selected ${tab.text} tab at ${tab?.position} position"
                            )
                        }//Completed
                        1 -> {
                            Log.i(
                                activity!!.javaClass.simpleName,
                                "You selected ${tab.text} tab at ${tab?.position} position"
                            )
                        } // In Progress
                        2 -> {
                            Log.i(
                                activity!!.javaClass.simpleName,
                                "You selected ${tab?.text} tab at ${tab?.position} position"
                            )
                        } //In Transit
                        3 -> {
                            Log.i(
                                activity!!.javaClass.simpleName,
                                "You selected ${tab?.text} tab at ${tab?.position} position"
                            )
                        } //Cancelled
                        else -> {}
                    }
                }
            }

        })
    }

    private fun initRecyclerView() {
        data?.let { shipmentData ->
            binding.rvShipment.layoutManager = LinearLayoutManager(requireActivity().baseContext)
            adapter = ShipmentRecyclerAdapter(this.requireContext(), shipmentData, itemClick = {
                Toast.makeText(requireContext(), "Item Clicked", Toast.LENGTH_SHORT).show()
            })
            binding.rvShipment.adapter = adapter
        }

    }

    private fun initTabsBadges(){
        binding.tlShipment.getTabAt(0)?.orCreateBadge?.number  = 10
        binding.tlShipment.getTabAt(1)?.orCreateBadge?.number  = 20
        binding.tlShipment.getTabAt(2)?.orCreateBadge?.number  = 8
        binding.tlShipment.getTabAt(3)?.orCreateBadge?.number  = 9
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initData(){
        data.add(ShipmentModel(status = ShipmentStatusType.InProgress.name , statusUpdate = "Arriving Today", statusDescription = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today", shipmentAmount = "3570", shipmentDate = "Jan 20, 2024"))
        data.add(ShipmentModel(status = ShipmentStatusType.Pending.name , statusUpdate = "Arriving Today", statusDescription = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today", shipmentAmount = "2000", shipmentDate = "Sep 20, 2024"))
        data.add(ShipmentModel(status =  ShipmentStatusType.Loading.name, statusUpdate = "Arriving Today", statusDescription = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today", shipmentAmount = "2000", shipmentDate = "Sep 20, 2024"))
        data.add(ShipmentModel(status = ShipmentStatusType.Completed.name , statusUpdate = "Arriving Today", statusDescription = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today", shipmentAmount = "2000", shipmentDate = "Sep 20, 2024"))
        data.add(ShipmentModel(status = ShipmentStatusType.Completed.name , statusUpdate = "Arriving Today", statusDescription = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today", shipmentAmount = "2000", shipmentDate = "Sep 20, 2024"))
        data.add(ShipmentModel(status = ShipmentStatusType.Loading.name , statusUpdate = "Arriving Today", statusDescription = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today", shipmentAmount = "2000", shipmentDate = "Sep 20, 2024"))
        data.add(ShipmentModel(status = ShipmentStatusType.Pending.name, statusUpdate = "Arriving Today", statusDescription = "Your delivery, #NEJ20089934122231 from Atlanta, is arriving today", shipmentAmount = "2000", shipmentDate = "Sep 20, 2024"))
    }
}