package com.miempresa.whatsapp

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listachats.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        listachats.layoutManager = LinearLayoutManager(this);
        var llenralista = ArrayList<Elementos>()
        llenralista.add(Elementos("Juan Mamani", "12:45 AM","Vamos por unos",5,
            BitmapFactory.decodeResource(resources, R.drawable.bard)))
        llenralista.add(Elementos("Luis Carvajal", "1:45 PM","como estas mano",10,
            BitmapFactory.decodeResource(resources, R.drawable.lisa)))
        llenralista.add(Elementos("Andres Medina", "5:45 AM","No puedo esperar a ",15,
            BitmapFactory.decodeResource(resources, R.drawable.imge1)))
        llenralista.add(Elementos("Sandra Suarez", "10:45 AM","Ese concierto de",20,
            BitmapFactory.decodeResource(resources, R.drawable.img6)))
        llenralista.add(Elementos("Lucas Idalgoi", "2:50 PM","Qué tal si salimos",1,
            BitmapFactory.decodeResource(resources, R.drawable.img9)))
        llenralista.add(Elementos("Ricardo Mamani", "12:00 AM","Wassup bro",5,
            BitmapFactory.decodeResource(resources, R.drawable.img7)))
        llenralista.add(Elementos("Sandra Quispe", "12:49 AM","Loco,viste el parido?",8,
            BitmapFactory.decodeResource(resources, R.drawable.kratos)))

        val adapter = AdaptadorElementos(llenralista)
        listachats.adapter = adapter

        registerForContextMenu(listachats)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal, menu)
        return true
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nombre -> {
                Toast.makeText(this, "Elegiste nombre", Toast.LENGTH_LONG).show()
            }
            R.id.estado -> {
                Toast.makeText(this, "Elegiste estado", Toast.LENGTH_LONG).show()
            }
            R.id.numero -> {
                Toast.makeText(this, "Elegiste numero", Toast.LENGTH_LONG).show()
            }
            R.id.email -> {
                Toast.makeText(this, "Crear grupo", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ){
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menucontextual, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.configuracion){
            /*Toast.makeText(this, "Elegiste menu configuracion", Toast.LENGTH_LONG).show();*/
            val llamaractividad =  Intent(applicationContext, Configuracion::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == R.id.chat){
            /*Toast.makeText(this, "Elegiste menu chat", Toast.LENGTH_LONG).show();*/
            val llamaractividad = Intent(applicationContext, Chat::class.java)
            startActivity(llamaractividad)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
