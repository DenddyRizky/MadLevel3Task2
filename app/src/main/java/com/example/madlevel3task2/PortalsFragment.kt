package com.example.madlevel3task2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_portals.*


class PortalsFragment : Fragment() {
    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portals, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews(){
        rvPortals.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
        rvPortals.adapter = portalAdapter

        addPortalResult()
    }

    private fun addPortalResult(){
        setFragmentResultListener(REQ_PORTAL_KEY) { key, bundle ->
            val portalTitle = bundle.getString(BUNDLE_PORTAL_TITLE)
            val portalUrl = bundle.getString(BUNDLE_PORTAL_URL)
            if(!portalTitle.isNullOrBlank() && !portalUrl.isNullOrBlank()) {
                val portal = Portal(portalTitle, portalUrl)

                portals.add(portal)
                portalAdapter.notifyDataSetChanged()
            }
        }
    }
}