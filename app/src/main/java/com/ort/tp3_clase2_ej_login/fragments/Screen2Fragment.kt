package com.ort.tp3_clase2_ej_login.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ort.tp3_clase2_ej_login.R
import com.ort.tp3_clase2_ej_login.entities.User

class Screen2Fragment : Fragment() {


    lateinit var v : View;
    lateinit var btnLogIn : Button;
    lateinit var editTextName : EditText;
    lateinit var editTextEmail : EditText;
    lateinit var editTextPassword : EditText;
    lateinit var btnBack   : Button;


    lateinit var usuarios : MutableList<User>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_screen2, container, false);

        usuarios = mutableListOf()

        btnLogIn = v.findViewById(R.id.btnLogIn);
        btnBack = v.findViewById(R.id.btnBack);

        editTextName = v.findViewById(R.id.editTextName);
        editTextEmail = v.findViewById(R.id.editTextEmail);
        editTextPassword = v.findViewById(R.id.editTextPassword);


        usuarios.add(User("a@gmail.com", "12345678"))
        usuarios.add(User("b@gmail.com", "12345678"))
        usuarios.add(User("c@gmail.com", "12345678"))
        usuarios.add(User("d@gmail.com", "12345678"))

        return v;
    }

    override fun onStart() {
        super.onStart()

        btnLogIn.setOnClickListener {
            val action = Screen2FragmentDirections.actionScreen2FragmentToWolcomeFragment();

            /*if(!existeUsuario(editTextEmail.text.toString())){
                Snackbar.make(v, "el usuario no existe", Snackbar.LENGTH_SHORT).show()
            } else if (editTextEmail.text.isEmpty() &&
               editTextName.text.isEmpty() &&
               editTextPassword.text.isEmpty()){
                Snackbar.make(v, "campos vacíos", Snackbar.LENGTH_SHORT).show()
                // mosrtar una notificación
           } else if(){
                // la manda para la siguiente pantalla
                findNavController().navigate(action);
           }*/


            if(editTextEmail.text.isEmpty() &&
                editTextName.text.isEmpty() &&
                editTextPassword.text.isEmpty()){

                Snackbar.make(v, "campos vacíos", Snackbar.LENGTH_SHORT).show()
                // mosrtar una notificación
            } else if(!existeUsuario(editTextEmail.text.toString())){
                Snackbar.make(v, "el usuario no existe", Snackbar.LENGTH_SHORT).show()
            } else if(!mismaContraseña(editTextPassword.text.toString())){
                Snackbar.make(v, "contraseña incorrecta", Snackbar.LENGTH_SHORT).show()
            }else{
                findNavController().navigate(action);
            }

        }

        btnBack.setOnClickListener {
            // para volver en el stack de pantallas
            findNavController().navigateUp()
        }
    }

    fun existeUsuario(mail: String) : Boolean{
        var existe : Boolean = false;
        var i : Int = 0;

        while (i < usuarios.size && !existe){
            if(usuarios[i].email.equals(mail)){
                existe = true;
            }
                i ++;

        }
        return existe;
    }

    fun mismaContraseña(contraseña : String) : Boolean{
        var misma : Boolean = false;
        val usuarioEncontrado = usuarios.find { it.email == editTextEmail.text.toString() }
        if (usuarioEncontrado != null) {
            if( usuarioEncontrado.password == contraseña){
                misma = true;
            }
        }
        return misma;
    }

}