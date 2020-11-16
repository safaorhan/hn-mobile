package school.cactus.hnmobile

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import school.cactus.hnmobile.FruitAdapter.FruitViewHolder

class FruitAdapter : RecyclerView.Adapter<FruitViewHolder>() {

    val fruits = listOf(
        Fruit("Elma", 12),
        Fruit("Armut", 9),
        Fruit("Portakal", 8),
        Fruit("Mandalin", 12),
        Fruit("Muz", 12),
        Fruit("Karpuz", 12),
        Fruit("Kavun", 24),
        Fruit("Ayva", 40),
        Fruit("Nar", 12),
        Fruit("Çilek", 29),
        Fruit("Yaban Mersini", 12)
    )

    override fun getItemCount() = fruits.size


    // Yeni bir item view ve ViewHolder oluşturulmalı
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fruit, parent, false)

        Log.e("FruitAdapter", "onCreateViewHolder")

        return FruitViewHolder(view)
    }


    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.nameText.text = fruits[position].name
        holder.priceText.text = "${fruits[position].price} TL"

        Log.e("FruitAdapter", "onBindViewHolder for: ${fruits[position]}")
    }


    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameText: TextView = itemView.findViewById(R.id.nameText)
        var priceText: TextView = itemView.findViewById(R.id.priceText)
    }

    data class Fruit(var name: String, var price: Int)
}