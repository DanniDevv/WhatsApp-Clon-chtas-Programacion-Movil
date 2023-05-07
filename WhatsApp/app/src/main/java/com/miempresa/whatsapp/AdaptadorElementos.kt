package com.miempresa.whatsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorElementos (val ListaElementos:ArrayList<Elementos>): RecyclerView.Adapter<AdaptadorElementos.ViewHolder>(){
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val fTexto: TextView = itemView.findViewById(R.id.elemento_texto)
        val fFecha: TextView = itemView.findViewById(R.id.elemento_fecha)
        val fSubtexto: TextView = itemView.findViewById(R.id.elemento_subtexto) // Agregar vista del subtexto
        val fNumero: TextView = itemView.findViewById(R.id.elemento_numero)
        val fImagem: ImageView = itemView.findViewById(R.id.elemento_imagen);
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdaptadorElementos.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.elementoslistachats, parent, false);
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdaptadorElementos.ViewHolder, position: Int) {
        holder?.fTexto?.text=ListaElementos[position].texto
        holder?.fFecha?.text=ListaElementos[position].fecha
        holder?.fSubtexto?.text = ListaElementos[position].subtexto
        holder?.fNumero?.text = ListaElementos[position].numero.toString()
        holder?.fImagem?.setImageBitmap(ListaElementos[position].imagen)

        holder.itemView.setOnCreateContextMenuListener { contextMenu, _, _ ->
            contextMenu.setHeaderTitle("Se eligio opcion " + (position+1))
            true
        }
    }
    override fun getItemCount(): Int {
        return ListaElementos.size;
    }

}