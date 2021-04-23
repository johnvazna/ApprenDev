package com.apprendev.instagramfake.ui.explorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.apprendev.instagramfake.R
import com.apprendev.instagramfake.data.local.entities.ExploreEntity
import com.apprendev.instagramfake.ui.adapters.ExploreAdapter
import kotlinx.android.synthetic.main.fragment_explorer.*

class ExplorerFragment : Fragment(), ExploreContract.View {

    private var adapter: ExploreAdapter? = null
    private var presenter: ExplorePresenter? = null
    private var data = arrayListOf<ExploreEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explorer, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ExplorePresenter(requireContext(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvExplorer.setHasFixedSize(true)
        rvExplorer.layoutManager = GridLayoutManager(requireContext(), 3)
        adapter = ExploreAdapter(data)
        rvExplorer.adapter = adapter

        presenter!!.getExploreData()
    }

    override fun setExploreData(data: ArrayList<ExploreEntity>) {
        adapter!!.updateData(data)
    }

    override fun onError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

}