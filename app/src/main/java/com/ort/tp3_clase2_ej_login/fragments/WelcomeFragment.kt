package com.ort.tp3_clase2_ej_login.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.ort.tp3_clase2_ej_login.R

class WelcomeFragment : Fragment() {

    lateinit var v : View;

    lateinit var btnBack : Button;
    lateinit var textWelcome : TextView;
    lateinit var textName : TextView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_wolcome, container, false);

        btnBack = v.findViewById(R.id.btnWolcome_Back);
        textWelcome = v.findViewById(R.id.textWelcome);
        textName = v.findViewById(R.id.textName);

        var arguments = WelcomeFragmentArgs.fromBundle(requireArguments()).userName
        // recibo los arguments que espera este fragment                    //. userName es el nomnre del arg


        textName.text = arguments;

        return v;
    }

    override fun onStart() {
        super.onStart()

        btnBack.setOnClickListener {
            findNavController().navigateUp();
        }
    }



}