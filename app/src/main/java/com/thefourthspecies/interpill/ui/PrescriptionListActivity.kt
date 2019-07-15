package com.thefourthspecies.interpill.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.thefourthspecies.interpill.R

import com.thefourthspecies.interpill.model.PillContent
import com.thefourthspecies.interpill.model.Prescription
import com.thefourthspecies.interpill.model.PrescriptionItem
import com.thefourthspecies.interpill.viewmodel.PrescriptionListViewModel
import kotlinx.android.synthetic.main.activity_prescription_list.*
import kotlinx.android.synthetic.main.prescription_list_content.view.*
import kotlinx.android.synthetic.main.prescription_list.*
import kotlinx.android.synthetic.main.prescription_list.view.*

/**
 * An activity representing a list of Prescriptions. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [PrescriptionDetailActivity] representing
 * item alarms. On tablets, the activity presents the list of items and
 * item alarms side-by-side using two vertical panes.
 */
class PrescriptionListActivity : AppCompatActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    private lateinit var model: PrescriptionListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prescription_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        if (item_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        // Get the ViewModel
        model = ViewModelProviders.of(this).get(PrescriptionListViewModel::class.java)

        prescription_list.adapter = ArrayAdapter(
            this, R.layout.prescription_list_content, model.prescriptions)
    }

}

/*
private fun setupRecyclerView(recyclerView: RecyclerView) {
    recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, DummyContent.ITEMS, twoPane)
}

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter =
            SimpleItemRecyclerViewAdapter(
                this,
                PillContent.ITEMS,
                twoPane
            )
    }

    class SimpleItemRecyclerViewAdapter(
        private val parentActivity: PrescriptionListActivity,
        private val values: List<PrescriptionItem>,
        private val twoPane: Boolean
    ) :
        RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                val item = v.tag as PrescriptionItem
                if (twoPane) {
                    val fragment = PrescriptionDetailFragment().apply {
                        arguments = Bundle().apply {
                            putString(PrescriptionDetailFragment.ARG_ITEM_ID, item.drugName)
                        }
                    }
                    parentActivity.supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.item_detail_container, fragment)
                        .commit()
                } else {
                    val intent = Intent(v.context, PrescriptionDetailActivity::class.java).apply {
                        putExtra(PrescriptionDetailFragment.ARG_ITEM_ID, item.drugName)
                    }
                    v.context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.prescription_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
            holder.idView.text = item.drugName
            holder.contentView.text = "Next Scheduled: " + item.nextScheduled // TODO fix

            with(holder.itemView) {
                tag = item
                setOnClickListener(onClickListener)
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idView: TextView = view.id_text
            val contentView: TextView = view.content
        }
    }
}
*/
