package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_portal.*
import kotlinx.android.synthetic.main.item_portal.*

const val REQ_PORTAL_KEY = "req_portal"
const val BUNDLE_PORTAL_KEY = "bundle_portal"
const val REQ_TITLE_KEY = "req_title"
const val BUNDLE_TITLE_KEY = "bundle_title"

class AddPortalFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btAddPortal.setOnClickListener{
            onAddPortal()
        }
    }

    private fun onAddPortal(){
        val portalTitle = etPortalTitle.text.toString()
        val portalUrl = etPortalUrl.text.toString()

        if (portalTitle.isBlank() && portalUrl.isNotBlank()){
            Toast.makeText(activity,"Invalid title", Toast.LENGTH_SHORT).show()
        }

        else if(portalTitle.isNotBlank() && portalUrl.isBlank()){
            Toast.makeText(activity,"Invalid URL", Toast.LENGTH_SHORT).show()
        }

        else if(portalTitle.isBlank() && portalUrl.isBlank()){
            Toast.makeText(activity,"Invalid title and invalid URL", Toast.LENGTH_SHORT).show()
        }

        else{
            setFragmentResult(REQ_PORTAL_KEY, bundleOf(Pair(BUNDLE_PORTAL_KEY, portalUrl)))
            setFragmentResult(REQ_TITLE_KEY, bundleOf(Pair(BUNDLE_TITLE_KEY, portalTitle)))

            findNavController().popBackStack()
        }
    }
}