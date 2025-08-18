package com.mywishlist.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishlistAdapter
    private val items = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val fabAdd: FloatingActionButton = findViewById(R.id.fabAdd)

        adapter = WishlistAdapter(items)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // تحميل العناصر من Firebase
        FirebaseManager.getWishlistItems { list ->
            items.clear()
            items.addAll(list)
            adapter.notifyDataSetChanged()
        }

        // زر الإضافة
        fabAdd.setOnClickListener {
            val dialog = NewItemDialog { newItem ->
                FirebaseManager.addWishlistItem(newItem) { success ->
                    if (success) {
                        items.add(newItem)
                        adapter.notifyItemInserted(items.size - 1)
                    }
                }
            }
            dialog.show(supportFragmentManager, "NewItemDialog")
        }
    }
}
