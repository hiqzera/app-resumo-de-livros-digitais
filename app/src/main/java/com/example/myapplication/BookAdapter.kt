package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val bookImages: List<Int>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    // ViewHolder interno para gerenciar os itens do RecyclerView
    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookImage: ImageView = itemView.findViewById(R.id.bookImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        // Configurar a imagem do livro
        holder.bookImage.setImageResource(bookImages[position])
    }

    override fun getItemCount(): Int {
        return bookImages.size
    }
}
