package com.example.smartprofilevupk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smartprofilevupk.data.UserProfileAdapter
import com.example.smartprofilevupk.data.UserProfileViewModel

class ViewProfileFragment : Fragment() {

    private lateinit var userProfileViewModel: UserProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_profile, container, false)

        val userProfileAdapter = UserProfileAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = userProfileAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        userProfileViewModel = ViewModelProvider(this).get(UserProfileViewModel::class.java)
        userProfileViewModel.allUserProfiles.observe(viewLifecycleOwner, Observer { userProfiles ->
            userProfiles?.let {
                userProfileAdapter.setUserProfiles(it)
            }
        })

        return view
    }
}

private fun ViewModelProvider.get(modelClass: Class<UserProfileViewModel>): UserProfileViewModel {
    TODO("Not yet implemented")
}
