package me.sakshisindhuja.messmate.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import me.sakshisindhuja.messmate.adapters.ComplaintsListAdapter
import me.sakshisindhuja.messmate.adapters.MealsListAdapter
import me.sakshisindhuja.messmate.databinding.FragmentHomeBinding
import me.sakshisindhuja.messmate.datamodels.ComplaintsDataInterface
import me.sakshisindhuja.messmate.datamodels.MealsDataInterface

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val recyclerViewMeals: RecyclerView = binding.homeMealsListRecyclerView
        val myDatasetMeals = MealsDataInterface().loadMealsForToday(requireContext())
        recyclerViewMeals.adapter = MealsListAdapter(myDatasetMeals)

        val recyclerViewComplaints: RecyclerView = binding.homeComplaintsListRecyclerView
        val myDatasetComplaints = ComplaintsDataInterface().loadComplaints(requireContext())
        recyclerViewComplaints.adapter = ComplaintsListAdapter(myDatasetComplaints)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}