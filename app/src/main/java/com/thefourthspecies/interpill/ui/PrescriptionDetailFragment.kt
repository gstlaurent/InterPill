package com.thefourthspecies.interpill.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thefourthspecies.interpill.R
import com.thefourthspecies.interpill.model.PillContent
import com.thefourthspecies.interpill.model.PrescriptionItem
import kotlinx.android.synthetic.main.activity_prescription_detail.*
import kotlinx.android.synthetic.main.prescription_detail.view.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [PrescriptionListActivity]
 * in two-pane mode (on tablets) or a [PrescriptionDetailActivity]
 * on handsets.
 */
class PrescriptionDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: PrescriptionItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = PillContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                activity?.toolbar_layout?.title = item?.drugName
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.prescription_detail, container, false)

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.item_detail.text = it.alarms.toString()
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
