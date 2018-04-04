package com.example.manolofernandez.te2.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

import com.example.manolofernandez.te2.R
import com.example.manolofernandez.te2.model.Item
import com.example.manolofernandez.te2.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityView {
    internal lateinit var imagesAdapter: ImagesAdapter
    internal lateinit var presenter: MainActivityPresenter
    internal lateinit var imagesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imagesRecyclerView = findViewById<RecyclerView>(R.id.imagesRecyclerView)
        presenter = MainActivityPresenter(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.getImagesList()
    }

    override fun showImagesList(itemList: List<Item>) {
        imagesAdapter = ImagesAdapter(this, itemList)
        imagesRecyclerView.layoutManager = GridLayoutManager(this, 2)
        imagesRecyclerView.adapter = imagesAdapter
    }

    override fun showCallFailed() {
        Toast.makeText(this, "Call FAILED", Toast.LENGTH_LONG)
    }
}
