package com.mywishlist.app

import android.net.Uri
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

object FirebaseManager {

    private val db = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance().reference

    // رفع صورة إلى Firebase Storage
    fun uploadImage(imageUri: Uri, onResult: (String?) -> Unit) {
        val fileName = "images/${System.currentTimeMillis()}.jpg"
        val imageRef = storage.child(fileName)

        val uploadTask = imageRef.putFile(imageUri)
        uploadTask.addOnSuccessListener {
            imageRef.downloadUrl.addOnSuccessListener { uri ->
                onResult(uri.toString()) // رابط الصورة
            }
        }.addOnFailureListener {
            onResult(null)
        }
    }

    // إضافة عنصر إلى Firestore
    fun addWishlistItem(item: WishlistItem, onComplete: (Boolean) -> Unit) {
        db.collection("wishlist")
            .add(item)
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }

    // جلب العناصر من Firestore
    fun getWishlistItems(onResult: (List<WishlistItem>) -> Unit) {
        db.collection("wishlist")
            .get()
            .addOnSuccessListener { result ->
                val items = result.map { doc ->
                    doc.toObject(WishlistItem::class.java)
                }
                onResult(items)
            }
            .addOnFailureListener {
                onResult(emptyList())
            }
    }
}
