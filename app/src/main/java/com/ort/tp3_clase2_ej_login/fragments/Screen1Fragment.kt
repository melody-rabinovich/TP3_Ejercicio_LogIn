package com.ort.tp3_clase2_ej_login.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.ort.tp3_clase2_ej_login.R

class Screen1Fragment : Fragment() {


   lateinit var v : View; // necesito esta variable para poder interactuar con la vista específica de mi fragment

    //y ahora hago los find by IDs con v

    lateinit var textNav: TextView;
    lateinit var btnNav: Button;

    override fun onCreateView( // este es el método que se va a ejecutar cuando se cree el fragment
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // devuelve un objeto de tipo view. Dejo comentado cémo viene por default.
        // return inflater.inflate(R.layout.fragment_screen1, container, false)
        v = inflater.inflate(R.layout.fragment_screen1, container, false); // así obtengo la vista y la guardo en la variable v


        textNav = v.findViewById(R.id.textNavigate);
        btnNav = v.findViewById(R.id.btnNavigation);

        return v; //y ahí la devuelvo como me pedía la función original.
    }

    /*
    * El onCreate() es un método que se ejecuta UNA vez, al crearse el fragment.
    * Para que sea más eficiente y óptimo el sistema, es preferible usar también el método onStart()
    * El onStart() se ejecuta cada vez que arranca el fragment.
    * no estoy muy segura de haber entendido la diferencia, pero creo que el on create, es cuando
    * arranca la aplicación, y este es por cada vez que se abre el fragment
    *
    * acá se suelen poner los listeners
    */


    override fun onStart() {
        super.onStart()

        btnNav.setOnClickListener {
            // acá tengo que definir al action (la flechita en el navgraph que uno a screen1 con screen2)
            val action = Screen1FragmentDirections.actionScreen1FragmentToScreen2Fragment();
                            // llamo al screen1     y después a su acción (que en este caso es la única)

            findNavController().navigate(action);
            // llamo al controller      .navigate() para que navegue    y por parametro le paso la accion que definí antes

        }
    }





}