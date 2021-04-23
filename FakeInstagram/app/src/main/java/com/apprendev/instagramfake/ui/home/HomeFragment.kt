package com.apprendev.instagramfake.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.apprendev.instagramfake.R
import com.apprendev.instagramfake.data.local.entities.PostEntity
import com.apprendev.instagramfake.ui.adapters.PostAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private var presenter: HomePresenter? = null
    private var adapter: PostAdapter? = null
    private var posts = arrayListOf<PostEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(requireContext(), this)

        adapter = PostAdapter(requireContext(), posts)
        presenter!!.getPosts()

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onCancel()
    }

    override fun onStop() {
        super.onStop()
        presenter!!.onCancel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvPosts.setHasFixedSize(true)
        rvPosts.layoutManager = LinearLayoutManager(requireContext())
        rvPosts.adapter = adapter

    }

    override fun setPosts(post: ArrayList<PostEntity>) {
        adapter?.updatePosts(post)
    }

    override fun onError(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

}