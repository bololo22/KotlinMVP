package com.example.manolofernandez.te2.view

import com.example.manolofernandez.te2.model.Item

/**
 * Created by manolofernandez on 4/1/18.
 */

interface MainActivityView {
    fun showImagesList(itemList: List<Item>)
    fun showCallFailed()
}
