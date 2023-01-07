package com.example.images.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import com.example.images.R
import com.example.images.databinding.FragmentImageDetailsBinding
import com.example.images.viewmodel.ImageViewModel

class ImageDetailsFragment : Fragment() {

    private val viewModel: ImageViewModel by activityViewModels()
    val SEARCH_PREFIX = "https://unsplash.com/@"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentImageDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        // Inflate the layout for this fragment

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var authorUn = viewModel.imagePicked.value?.author
        if (authorUn != null) {
            authorUn = authorUn.replace("\\s".toRegex(), "")
        }
        val searchButton: ImageButton = view.findViewById(R.id.ndbutton)
        searchButton.setOnClickListener {
            val queryUri: Uri = Uri.parse("${SEARCH_PREFIX}${authorUn}")
            val intent = Intent(Intent.ACTION_VIEW, queryUri)
            context?.startActivity(intent)
        }
    }
}