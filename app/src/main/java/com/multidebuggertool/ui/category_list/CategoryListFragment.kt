package com.multidebuggertool.ui.category_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.multidebuggertool.R

class CategoryListFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[CategoryListViewModel::class.java]
    }

    private val messageAdapter by lazy { MessageListAdapter() }

    private var categoryName: String = "NULL"

    companion object {
        fun newInstance(argsBundle: Bundle): CategoryListFragment {
            val fragment = CategoryListFragment()
            fragment.arguments = argsBundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvMessageList = view.findViewById<RecyclerView>(R.id.rvMessageList)
        rvMessageList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = messageAdapter
        }
        categoryName = arguments?.getString("CATEGORY_NAME") ?: "NULL"
        viewModel.getDebugMessages(categoryName).observe(viewLifecycleOwner) { messageList ->
            messageAdapter.submitList(messageList)
        }
    }
}
