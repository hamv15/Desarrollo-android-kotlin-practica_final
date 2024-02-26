package com.hamv.modulo4.componentesgraficos.recyclerview


import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout.LayoutParams
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.hamv.modulo4.R
import com.squareup.picasso.Picasso

class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
    //Obtención de referncias de objetos en la vista
    val ivUser = view.findViewById<ImageView>(R.id.ivUser)
    val tvUser = view.findViewById<TextView>(R.id.tvUser)

    //Referencias para agregarles el listener
    val root = view.findViewById<ConstraintLayout>(R.id.root)
    val card = view.findViewById<CardView>(R.id.card)

    fun render(user:User, onItemSelected : ((User)->Unit)?){
        //Seteo de valores del objeto en la lista al elemento visual
        tvUser.text=user.mail

        //Asignación de imagenes a traves de los siguientes mètodos
        //Asignando un recurso guradado en resources
        //ivUser.setImageResource(R.drawable.img_placeholder)

        //A traves de un drawable
        //ivUser.setImageDrawable(ContextCompat.getDrawable(tvUser.context, R.drawable.img_placeholder))

        //Se pueden modificar o asignar los atributos o caracteristicas
        //de xml para los elementos de la vista
        //val param = ConstraintLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        //ivUser.layoutParams = param

        //Cargando imagen desde una URL
        if (user.imageUri.isNotEmpty()){
            Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU")
                .error(R.drawable.img_placeholder)//coloca una imagen en caso de que no logre descargar la imagen
                .placeholder(R.drawable.img_logo) //Coloca una imagen en lo que carga la imagen objetivo
                .into(ivUser)
        }


        tvUser.typeface = ResourcesCompat.getFont(tvUser.context, R.font.bernier_shade_regular)

        //Función lamda para invocar item seleccionado **importante: tu decides a que componente de tu vista le agregas el escuchador de eventos
        root.setOnClickListener{
            onItemSelected?.invoke(user)
        }
    }
}